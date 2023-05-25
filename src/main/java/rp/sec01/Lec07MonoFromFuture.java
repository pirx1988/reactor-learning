package rp.sec01;

import reactor.core.publisher.Mono;
import rp.courseutil.Util;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.onNext());
        System.out.println("siemka");
        Util.sleepSeconds(3);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync( () -> Util.faker().name().fullName());
    }
}
