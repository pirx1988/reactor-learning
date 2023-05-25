package rp.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import rp.courseutil.Util;

public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        getName();
        String s = getName().subscribeOn(Schedulers.boundedElastic())
//                 .subscribe(Util.onNext());
        .block(); // blocking subscriber
        System.out.println(s);

    }

    // publisher
    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
