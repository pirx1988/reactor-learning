package rp.sec01;

import reactor.core.publisher.Mono;
import rp.courseutil.Util;

public class Lec04MonoEmptyOrError {
    public static void main(String[] args) {
        userRepository(22).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());

    }

    private static Mono<String> userRepository(int userId) {
        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null, no data, invoke onComplete
        } else {
            return Mono.error(new RuntimeException("No in the allowed range"));
        }
    }
}
