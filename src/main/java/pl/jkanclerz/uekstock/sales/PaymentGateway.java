package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.sales.ordering.CustomerDetails;
import pl.jkanclerz.uekstock.sales.ordering.PaymentDetails;

import java.math.BigDecimal;

public interface PaymentGateway {
    PaymentDetails register(String id, BigDecimal total, CustomerDetails customerDetails);
}
