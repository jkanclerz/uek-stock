package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.productcatalog.Product;

interface ProductDetailsProvider {
    ProductDetails getProductDetails(String productId);
}
