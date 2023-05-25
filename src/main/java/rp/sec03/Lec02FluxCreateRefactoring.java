package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;
import rp.sec03.helper.NameProducer;

public class Lec02FluxCreateRefactoring {
    public static void main(String[] args) {
        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
                .subscribe(Util.subscriber());
        // reference to method which produces elements
        Runnable runnable = nameProducer::produce;

        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);

    }
}
