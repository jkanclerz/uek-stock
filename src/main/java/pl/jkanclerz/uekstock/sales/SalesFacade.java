package pl.jkanclerz.uekstock.sales;


import pl.jkanclerz.uekstock.sales.offerting.Offer;
import pl.jkanclerz.uekstock.sales.offerting.OfferMaker;
import pl.jkanclerz.uekstock.sales.ordering.InMemoryReservationStorage;
import pl.jkanclerz.uekstock.sales.ordering.Reservation;
import pl.jkanclerz.uekstock.sales.ordering.ReservationDetails;

public class SalesFacade {
    private BasketStorage basketStorage;
    private ProductDetailsProvider productDetailsProvider;
    private OfferMaker offerMaker;
    private InMemoryReservationStorage reservationStorage;
    private DummyPaymentGateway paymentGateway;


    public SalesFacade(BasketStorage basketStorage, ProductDetailsProvider productDetailsProvider, OfferMaker offerMaker, InMemoryReservationStorage reservationStorage, DummyPaymentGateway paymentGateway) {
        this.basketStorage = basketStorage;
        this.productDetailsProvider = productDetailsProvider;
        this.offerMaker = offerMaker;
        this.reservationStorage = reservationStorage;
        this.paymentGateway = paymentGateway;
    }

    public void addToBasket(String customerId, String productId) {
        Basket basket = loadBasketForCustomer(customerId);
        ProductDetails product = productDetailsProvider.getProductDetails(productId);

        basket.add(BasketItem.of(product.getId(), product.getPrice()));

        basketStorage.save(customerId, basket);
    }

    private Basket loadBasketForCustomer(String customerId) {
        return basketStorage.getForCustomer(customerId)
                .orElse(Basket.empty());
    }

    public Offer getCurrentOffer(String customerId) {
        Basket basket = loadBasketForCustomer(customerId);

        return offerMaker.makeAnOffer(basket);
    }

    public ReservationDetails acceptOffer(String customerId, CustomerData customerData) {
        Basket basket = loadBasketForCustomer(customerId);
        Offer currentOffer = offerMaker.makeAnOffer(basket);

        Reservation reservation = Reservation.of(currentOffer, basket.getBasketItems(), customerData);
        reservation.registerPayment(paymentGateway);

        reservationStorage.save(reservation);

        return ReservationDetails.ofPayment(
                reservation.getId(),
                reservation.paymentDetails().getId(),
                reservation.paymentDetails().getUrl()
        );
    }
}
