package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.productcatalog.Product;

public interface ProductDetailsProvider {
    ProductDetails getProductDetails(String productId);
}
