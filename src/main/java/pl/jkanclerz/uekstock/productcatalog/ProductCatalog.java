package pl.jkanclerz.uekstock.productcatalog;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ProductCatalog {
    ProductStorage storage;

    public ProductCatalog() {
        this.storage = new ProductStorage();
    }

    public String addProduct(String title, BigDecimal price, List<String> keywords, String mediaPath) {
        Product product = new Product(UUID.randomUUID(), title, price, keywords, mediaPath);
        storage.save(product);
        return product.getId();
    }

    public boolean isProductExists(String productId) {
        return storage.load(productId).isPresent();
    }
}
