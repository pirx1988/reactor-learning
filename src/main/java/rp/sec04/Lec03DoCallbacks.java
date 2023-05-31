package rp.sec04;

import reactor.core.publisher.Flux;
import rp.courseutil.Util;

public class Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {

                    System.out.println("inside create");
                    for (int i = 0; i < 5; i++) {
                        fluxSink.next(i);
                    }
//                    fluxSink.complete();
                    fluxSink.error(new RuntimeException("oops"));
                    System.out.println("--completed");

                }).doOnComplete(() -> {
                    System.out.println("doOnComplete");
                }).doFirst(() -> System.out.println("doFirst 1"))
                .doOnNext(o -> System.out.println("doOnNext : " + o))
                .doOnSubscribe(s -> System.out.println("doOnSubscribe :" + s))
                .doOnRequest(l -> System.out.println("doOnRequest : " + l))
//                .doFirst(() -> System.out.println("doFirst 2"))
                .doOnError(err -> System.out.println("doOnError :" + err.getMessage()))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
//                .doFirst(() -> System.out.println("doFirst 3"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
//                .doOnSubscribe(s -> System.out.println("doOnSubscribe 2" + s))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
//                .doFirst(() -> System.out.println("doFirst 4"))
                .take(2)
                .doFinally(signal -> System.out.println("doFinally :" + signal)) // do anything as a last
                .subscribe(Util.subscriber());
    }
}
