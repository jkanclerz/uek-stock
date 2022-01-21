package pl.jkanclerz.uekstock.sales;

import lombok.Data;

@Data
public class PaymentDetails {
    private String paymentId;
    private String paymentUrl;

    public String getId() {
        return paymentId;
    }

    public String getUrl() {
        return paymentUrl;
    }
}
