package rp.sec02;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec01FluxIntro {
    public static void main(String[] args) {
//        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
//        Flux<Integer> flux = Flux.empty();
        Flux<Object> flux = Flux.just(1, 2, Util.faker().name().fullName(), "sss");
        flux.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete());

    }
}
