package pl.jkanclerz.uekstock.productcatalog;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProductCatalogTest {
    @Test
    void testIfItWorks() {
        assertEquals("123", "123");
    }

    @Test
    void itAllowAddProductToCatalog() {
        ProductCatalog catalog = thereIsProductCatalog();

        String productId = catalog.addProduct(
                "Nice Picture",
                BigDecimal.valueOf(10.10),
                Arrays.asList("#tag1", "#tag2"),
                "images/image1.jpeg"
        );

        productExistsWithinTheSystem(catalog, productId);
    }

    private void productExistsWithinTheSystem(ProductCatalog catalog, String productId) {
        assertTrue(catalog.isProductExists(productId));
    }

    private ProductCatalog thereIsProductCatalog() {
        return new ProductCatalog();
    }
}
