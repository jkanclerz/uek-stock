package pl.jkanclerz.uekstock.sales;

import pl.jkanclerz.uekstock.sales.offerting.Offer;

import java.util.List;

public class Reservation {
    public static Reservation of(Offer currentOffer, List<BasketItem> basketItems, CustomerData customerData) {
        return null;
    }

    public boolean isPending() {
        return false;
    }

    public String getCustomerEmail() {
        return "";
    }

    public int getLinesCount() {
        return 0;
    }

    public void registerPayment(PaymentGateway paymentGateway) {

    }

    public String getId() {
        return null;
    }

    public PaymentDetails paymentDetails() {
        return null;
    }
}
