package pl.jkanclerz.uekstock.sales;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails register(String id, BigDecimal total, CustomerDetails customerDetails);
}
