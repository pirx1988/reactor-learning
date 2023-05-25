package rp.sec03;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec06FluxGenerateAssignment {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    String countryName = Util.faker().country().name();
                    System.out.println("emitting: " + countryName);
                    // no need for loop
                    synchronousSink.next(countryName);
                    if(countryName.toLowerCase().equals("canada")) {
                        synchronousSink.complete();
                    }
                })
                .subscribe(Util.subscriber());
    }
}
