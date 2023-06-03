package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter( i -> i > 10)
                .switchIfEmpty(fallback()) // switch to other producer if nothing emitted
                .subscribe(Util.subscriber());
    }

    // db query
    private static Flux<Integer> fallback() {
        return Flux.range(20, 5);
    }

    // example - redis cache
    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 9);
    }
}
