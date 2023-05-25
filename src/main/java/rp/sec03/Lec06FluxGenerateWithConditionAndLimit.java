package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec06FluxGenerateWithConditionAndLimit {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        // first argument is similar accumulator in  reduce function in js
        // will be invoked again and again based on downstream demand ( take(n) - can restrict )
        Flux.generate(() -> 1, (counter, synchronousSink) -> {
                    String countryName = Util.faker().country().name();
                    System.out.println("emitting: " + countryName);
                    // no need for loop
                    synchronousSink.next(countryName);
                    atomicInteger.incrementAndGet();
                    if(countryName.toLowerCase().equals("canada") || counter == 10) {
                        synchronousSink.complete();
                    }
                    return counter + 1;
                })
                .subscribe(Util.subscriber());
    }
}
