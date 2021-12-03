package pl.jkanclerz.uekstock.productcatalog;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
public class Product {
    @Id
    private String id;
    private String title;
    private BigDecimal price;
    @Transient
    private List<String> keywords;
    private String mediaPath;

    private Product() {}

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
