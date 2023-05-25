package rp.sec02;

import com.github.javafaker.File;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rp.courseutil.Util;

public class Lec09FluxFromMono {
    public static void main(String[] args) {
//        Mono<String> mono = Mono.just("a");
//        Flux<String> flux = Flux.from(mono);
//        doSomething(flux);

        // convert flux to mono
        Flux.range(1, 10)
                .filter(i -> i > 3)
                .next() // converting to mono, only 1 item
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

    private static void doSomething(Flux<String> flux) {
        flux.subscribe(Util.onNext());
    }
}
