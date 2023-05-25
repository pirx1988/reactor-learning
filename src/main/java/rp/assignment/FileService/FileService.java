package rp.assignment.FileService;

import reactor.core.publisher.Mono;
import rp.courseutil.Util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec01");

    public static Mono<String> read(String filename) {
        return Mono.fromSupplier(() -> readFile(filename));
    }

    public static Mono<Void> write(String filename, String content) {
        return Mono.fromRunnable(() -> writeFile(filename, content));
    }

    public static Mono<Void> delete(String filename) {
        return Mono.fromRunnable(() -> deleteFile(filename));
    }


    public static String readFile(String filename) {
        try {
            Util.sleepSeconds(4);
            return Files.readString(PATH.resolve(filename));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void writeFile(String filename, String content) {
        try {
            Files.writeString(PATH.resolve(filename), content);
            Util.sleepSeconds(4);
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void deleteFile(String filename) {
        try {
            Files.delete(PATH.resolve(filename));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
