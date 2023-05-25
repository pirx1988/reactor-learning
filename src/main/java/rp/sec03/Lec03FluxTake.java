package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec03FluxTake {

    // map
    // filter

    public static void main(String[] args) {
        Flux.range(1, 10)
                .log()
                .take(3) // cancels the subscription
                .log()
                .subscribe(Util.subscriber());
    }
}
