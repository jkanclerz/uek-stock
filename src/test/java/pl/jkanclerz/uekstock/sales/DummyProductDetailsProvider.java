package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.sales.catalog.ProductDetails;
import pl.jkanclerz.uekstock.sales.catalog.ProductDetailsProvider;

import java.util.HashMap;
import java.util.Map;

public class DummyProductDetailsProvider implements ProductDetailsProvider {
    Map<String, ProductDetails> products;

    public DummyProductDetailsProvider() {
        this.products = new HashMap<>();
    }

    @Override
    public ProductDetails getProductDetails(String productId) {
        return products.get(productId);
    }
}
