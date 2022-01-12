package pl.jkanclerz.uekstock.sales;


import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SalesFacade {
    private BasketStorage basketStorage;
    private ProductDetailsProvider productDetailsProvider;


    public SalesFacade(BasketStorage basketStorage, ProductDetailsProvider productDetailsProvider) {
        this.basketStorage = basketStorage;
        this.productDetailsProvider = productDetailsProvider;
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

        List<OfferLine> lines = basket.getBasketItems()
                .stream()
                .map(this::createOfferLine)
                .collect(Collectors.toList());

        BigDecimal offerTotal = lines
                .stream()
                .map(offerLine -> offerLine.getTotal())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);


        return Offer.of(offerTotal, lines);
    }

    private OfferLine createOfferLine(BasketItem basketItem) {
        return new OfferLine(basketItem.getProductId(), basketItem.getQuantity(), productDetailsProvider.getProductDetails(basketItem.getProductId()).getPrice());
    }

    public ReservationDetails acceptOffer(String customerId, CustomerData customerData) {
        return ReservationDetails.ofPayment("reservationId", "paymentId", "paymentUrl");
    }
}
