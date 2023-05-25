package rp.sec02;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(0, 10)
                .log()
                .map(
                number -> Util.faker().name().fullName())
                .log()
                .subscribe(
                        Util.onNext()
                );
    }

    ;
}
