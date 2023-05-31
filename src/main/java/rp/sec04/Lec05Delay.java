package rp.sec04;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import rp.courseutil.Util;

import java.time.Duration;

public class Lec05Delay {
    public static void main(String[] args) {
        Flux.range(1, 1000).log()
                .delayElements(Duration.ofSeconds(1), Schedulers.parallel())
                .subscribe(Util.subscriber());
    }
}
