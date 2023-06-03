package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        // synchronous sink
        Flux.generate(synchronousSink -> {
                    // you can emit maximum only one item
                    // you don't have to maintain any loop
                    System.out.println("emitting");
                    synchronousSink.next(Util.faker().country().name());
//                    synchronousSink.complete();
//                    synchronousSink.error(new RuntimeException("oops"));
                    // if you're trying to emit one more item it will create an error
//            synchronousSink.next(Util.faker().country().name());

                })
                .take(2)
//                .takeUntil(element -> ((String) element).toLowerCase().equals("canada"))
                .subscribe(Util.subscriber());
    }
}
