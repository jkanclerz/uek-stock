package pl.jkanclerz.uekstock.productcatalog;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class Product {
    private final String id;
    private final String title;
    private final BigDecimal price;
    private final List<String> keywords;
    private final String mediaPath;

    public Product(UUID id, String title, BigDecimal price, List<String> keywords, String mediaPath) {
        this.id = id.toString();
        this.title = title;
        this.price = price;
        this.keywords = keywords;
        this.mediaPath = mediaPath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public String getMediaPath() {
        return mediaPath;
    }
}
