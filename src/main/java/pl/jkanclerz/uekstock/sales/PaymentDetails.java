package pl.jkanclerz.uekstock.sales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDetails {
    private String reservationId;
    private String paymentId;
    private String paymentUrl;

    public String getId() {
        return paymentId;
    }

    public String getUrl() {
        return paymentUrl;
    }
}
