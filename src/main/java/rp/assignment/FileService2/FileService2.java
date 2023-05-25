package rp.assignment.FileService2;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rp.courseutil.Util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class FileService2 {

    private BufferedReader bufferedReader;

    public FileService2(String filename) {
        File file = new File(PATH.resolve(filename).toString());
        try {
            FileInputStream stream = new FileInputStream(file);
            InputStreamReader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
            this.bufferedReader = new BufferedReader(streamReader);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String readLine() throws IOException {
        return bufferedReader.readLine();
    }

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec03");

    public Flux<String> read() {
        return Flux.generate(synchronousSink -> {
            try {
                String line = readLine();
                if(line  == null) {
                    synchronousSink.complete();
                } else {
                    System.out.println("Emitting");
                    synchronousSink.next(line);
                }

            } catch (IOException e) {
                synchronousSink.error(new RuntimeException(e));
            }
        });
    }


}
