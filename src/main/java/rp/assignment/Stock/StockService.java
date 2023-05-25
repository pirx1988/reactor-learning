package rp.assignment.Stock;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class StockService {
    private Long stockPrice = 100l;
    private boolean isInitial = true;
    private static final int INTERVAL_IN_SECONDS = 1;

    private static int getRandomNumberInRange(int min, int max) { // max is exclusive
        Random random = new Random();
        return random.nextInt(max-min) + min;
    }

    public Flux<Long> getPricesGenerator() {
        return Flux.interval(Duration.ofSeconds(INTERVAL_IN_SECONDS)).map((item) -> {
            if (isInitial) {
                isInitial = false;
                return stockPrice;
            }
            stockPrice += getRandomNumberInRange(0,6);
            return  stockPrice;
        });
    }


}
