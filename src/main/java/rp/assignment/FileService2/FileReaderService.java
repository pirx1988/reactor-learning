package rp.assignment.FileService2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileReaderService {

    private Callable<BufferedReader> openReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> consumeContentFile() {
        return (br, sink) -> {
            try {
                String line = br.readLine();
                System.out.println("reading --- " + line);
                if (Objects.isNull(line)) {
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                sink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                br.close();
                System.out.println("--closed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
    public Flux<String> read(Path path) {
        return Flux.generate(
                openReader(path),
                consumeContentFile(),
                closeReader()
        );
    }

}
