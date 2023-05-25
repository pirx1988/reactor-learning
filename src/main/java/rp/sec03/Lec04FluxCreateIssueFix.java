package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {

        // only one instance of fluxsink
        Flux.create(fluxSink -> {
                    String country;

                    do {
                        country = Util.faker().country().name();
                        System.out.println("emmitting : " + country);
                        fluxSink.next(country);
                    // sink may be not aware that subscribe has been cancelled and will still emit data
                    } while (!country.toLowerCase().equals("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();

                }).take(3)
                .subscribe(Util.subscriber());
    }
}
