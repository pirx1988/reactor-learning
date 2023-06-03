package rp.sec04;

import rp.courseutil.Util;
import rp.sec04.helper.OrderService;
import rp.sec04.helper.UserService;

public class Lce12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .flatMapSequential(user -> OrderService.getOrders(user.getUserId()))  // mono / flux
                .filter(p -> Double.parseDouble(p.getPrice()) > 10)
                .subscribe(Util.subscriber());

    }
}
