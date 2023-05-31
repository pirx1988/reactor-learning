package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.time.Duration;

public class Lec04LimitRate {
    public static void main(String[] args) {
        Flux.range(1, 100)
                .log()
                .limitRate(10, 2)
//                .delayElements(Duration.ofMillis(1000))
                .subscribe(Util.subscriber());


//    Flux.range(1, 1000)
//            .log()
//            .delayElements(Duration.ofMillis(100))
//            .subscribe(System.out::println);
    }
}
