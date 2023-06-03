package rp.sec04;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import rp.courseutil.Util;

public class Lec06OnError {
    public static void main(String[] args) {
        Flux.range(1, 10)
//                .log()
                .map(i -> 10 / (3 - i))
                .onErrorReturn(-1) // handle / 0 error
//                .onErrorResume(e -> fallback()) // handle by one more signal emit
//                .onErrorContinue((err, obj) -> {
                    // if function is empty, simple skit this case and continue
//                })
                .subscribe(Util.subscriber());
    }

    private static Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }
}
