package rp.sec01;

import reactor.core.publisher.Mono;
import rp.courseutil.Util;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {

        // use only when you already have data
//        Mono<String> mono = Mono.just(getName());

        Supplier<String> stringSupplier = () -> getName();

        Mono<String> mono = Mono.fromSupplier(stringSupplier);
        mono.subscribe(
                Util.onNext()
        );

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable);

        mono.subscribe(
                Util.onNext()
        );
        System.out.println("siemka, siemka panowie!!!!");
    }
    private static String getName() {
        System.out.println("Generating name..");
        return Util.faker().name().fullName();
    }
}
