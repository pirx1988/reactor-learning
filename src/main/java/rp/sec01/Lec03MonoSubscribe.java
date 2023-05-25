package rp.sec01;

import reactor.core.publisher.Mono;
import rp.courseutil.Util;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l / 0);

        // 1
//        mono.subscribe();
        // 2
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
