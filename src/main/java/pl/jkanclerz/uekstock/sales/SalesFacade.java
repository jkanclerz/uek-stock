package pl.jkanclerz.uekstock.sales;


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
        return new Offer();
    }
}
