package pl.jkanclerz.uekstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.jkanclerz.uekstock.productcatalog.ProductCatalog;
import pl.jkanclerz.uekstock.productcatalog.ProductStorage;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public ProductCatalog createProductCatalog(ProductStorage storage) {
        return new ProductCatalog();
    }

    @Bean
    public ProductStorage crateProductStorage() {
        return new ProductStorage();
    }
}
