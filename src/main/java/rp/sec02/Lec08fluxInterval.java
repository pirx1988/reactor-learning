package rp.sec02;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.time.Duration;

public class Lec08fluxInterval {
    public static void main(String[] args) {

        // non blocking async way, uses different thread pool
        // case - periodically send info to user
        Flux.interval(Duration.ofSeconds(1)).subscribe(
                Util.onNext()
        );
        Util.sleepSeconds(20);
    }
}
