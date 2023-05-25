package rp.sec02;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromArrayOrList {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b", "c");

        Flux.fromIterable(strings).subscribe(Util.onNext());

        Integer[] arr = {2, 4, 5, 6, 88};
        Flux.fromArray(arr).subscribe(Util.onNext());
     }
}
