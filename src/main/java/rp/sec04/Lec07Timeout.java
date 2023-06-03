package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.time.Duration;

public class Lec07Timeout {
    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(2), fallback()) // second argument is fallback ( will take control in case of error)
                .subscribe(Util.subscriber());

        Util.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumbers() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1)); // delay get schedule in separate thread
    }

    private static Flux<Integer> fallback() {
        return Flux.range(100, 10)
                .delayElements(Duration.ofMillis(200));
    }
}
