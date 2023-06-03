package rp.sec04.helper;

import lombok.Data;
import lombok.ToString;
import rp.courseutil.Util;

@Data
@ToString
public class PurchaseOrder {
    private String item;
    private String price;
    private int userId;

    PurchaseOrder(int userId) {
        this.userId = userId;
        this.item = Util.faker().commerce().productName();
        this.price = Util.faker().commerce().price();
    }
}
