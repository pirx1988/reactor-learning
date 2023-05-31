package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec01Handle {
    public static void main(String[] args) {
        Flux.range(1, 20)
                .handle((integer, synchronousSink) -> {
                    if(integer == 7) {
                        synchronousSink.complete();
                    }
                    if(integer % 2 == 0 ) {
                        synchronousSink.next(integer); // filter
                    } else {
                        synchronousSink.next(integer + "a"); // map
                    }
                }).subscribe(Util.subscriber());
    }
}
