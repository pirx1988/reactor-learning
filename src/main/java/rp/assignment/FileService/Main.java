package rp.assignment.FileService;

import com.github.javafaker.Faker;
import com.github.javafaker.File;
import reactor.core.publisher.Mono;
import rp.courseutil.Util;

public class Main {
    public static void main(String[] args) {
        FileService.read("input.csv").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
        System.out.println("siemka");
//        FileService.write("test.txt", Faker.instance().name().fullName()).subscribe(
//                Util.onNext(),
//                Util.onError(),
//                Util.onComplete()
//        );
//        FileService.delete("test.txt").subscribe(
//                Util.onNext(),
//                Util.onError(),
//                Util.onComplete()
//        );
    }
}
