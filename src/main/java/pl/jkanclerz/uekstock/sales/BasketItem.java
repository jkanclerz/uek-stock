package pl.jkanclerz.uekstock.sales;

import java.math.BigDecimal;

public class BasketItem {
    private String productId;
    private BigDecimal price;

    public BasketItem(String productId, BigDecimal price) {
        this.productId = productId;
        this.price = price;
    }

    static BasketItem of(String productId, BigDecimal price) {
        return new BasketItem(productId, price);
    }
}
