package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.time.Duration;

public class Lec08DefaultIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter( i -> i > 10)
                .defaultIfEmpty(-100) // emit default value if no value emitted. Go into only in case when nothing emitted
                .subscribe(Util.subscriber());
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 12);
    }
}
