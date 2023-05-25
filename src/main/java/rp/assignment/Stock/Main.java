package rp.assignment.Stock;

import rp.courseutil.Util;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 30; i++) {
//            System.out.println(StockService.getRandomNumberInRange(0,6));
//        }
        CountDownLatch latch = new CountDownLatch(1);
        StockService s = new StockService();
        s.getPricesGenerator().log().takeWhile(item -> {
                    if(item < 90 || item > 110) {
                        System.out.println("Item out of the range, value: " + item);
                            latch.countDown();
                        return false;
                    }
                    return true;
                })
                .subscribe(Util.onNext(), Util.onError(), () -> {
                    System.out.println("Completed!");
                    latch.countDown();
                });
//        Util.sleepSeconds(60);
        latch.await();
    }
}
