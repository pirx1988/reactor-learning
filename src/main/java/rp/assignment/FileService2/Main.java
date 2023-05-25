package rp.assignment.FileService2;

import rp.courseutil.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        Path path = Paths.get("src/main/resources/assignment/sec03/input.csv");
        FileReaderService fileService = new FileReaderService();
        fileService.read(path).subscribe(Util.subscriber());

        Path path2 = Paths.get("src/main/resources/assignment/sec03/Apache_2k.log");
        FileReaderService fileService2 = new FileReaderService();
        fileService.read(path2).subscribe(Util.subscriber());

        Path path3 = Paths.get("src/main/resources/assignment/sec03/Hadoop_2k.log");
        FileReaderService fileService3 = new FileReaderService();
        fileService3.read(path3).subscribe(Util.subscriber());

        FileReaderService fileService4 = new FileReaderService();
        fileService4.read(path3).map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 10);
                    if( integer > 8) {
                        throw new RuntimeException("oops");
                    }
                    return s;
                })
                .take(10)
                .subscribe(Util.subscriber());
    }
}
