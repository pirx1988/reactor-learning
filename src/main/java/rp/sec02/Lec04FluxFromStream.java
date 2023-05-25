package rp.sec02;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        //stream.forEach(System.out::println); // stream is closed after performing operation
        //stream.forEach(System.out::println);

//        Flux<Integer> integerFlux = Flux.fromStream(stream);
        Flux<Integer> integerFlux = Flux.fromStream(list::stream);

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
