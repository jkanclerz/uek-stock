package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.sales.offerting.Offer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Reservation {
    private final String id;
    private final BigDecimal total;
    private final CustomerDetails customerDetails;
    private final List<ReservationLine> lines;
    private PaymentDetails paymentDetails;
    private Instant paidAt;

    public Reservation(String id, BigDecimal total, CustomerDetails customerDetails, List<ReservationLine> lines) {
        this.id = id;
        this.total = total;
        this.customerDetails = customerDetails;
        this.lines = lines;
    }

    public static Reservation of(Offer currentOffer, List<BasketItem> basketItems, CustomerData customerData) {
        return new Reservation(
                UUID.randomUUID().toString(),
                currentOffer.getTotal(),
                CustomerDetails.of(
                        customerData.getFirstname(),
                        customerData.getLastname(),
                        customerData.getEmail()),
                basketItems.stream()
                        .map(bi -> new ReservationLine(bi.getProductId(), bi.getQuantity()))
                        .collect(Collectors.toList())

        );
    }

    public boolean isPending() {
        return paidAt == null;
    }

    public String getCustomerEmail() {
        return customerDetails.email;
    }

    public int getLinesCount() {
        return lines.size();
    }

    public void registerPayment(DummyPaymentGateway paymentGateway) {
        paymentDetails = paymentGateway.register(id, total, customerDetails);
    }

    public String getId() {
        return id;
    }

    public PaymentDetails paymentDetails() {
        return paymentDetails;
    }
}
