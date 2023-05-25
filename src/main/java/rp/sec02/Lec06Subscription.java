package rp.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import rp.courseutil.Util;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1, 20).log().subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                // publisher will be giving the subscription object to me by calling onSubscribe method
                System.out.println("Received Subscription" + s);
                atomicReference.set(s);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("on Next" + integer);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("onError" + t.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });

        Util.sleepSeconds(4);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel(); // once subscription is cancelled you won't be able to get any item!
        Util.sleepSeconds(3);
        atomicReference.get().request(4);

        Util.sleepSeconds(4);
    }
}
