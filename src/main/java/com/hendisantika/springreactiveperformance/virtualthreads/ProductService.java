package com.hendisantika.springreactiveperformance.virtualthreads;

import com.hendisantika.springreactiveperformance.model.Price;
import com.hendisantika.springreactiveperformance.model.Product;
import lombok.RequiredArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 08:59
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class ProductService {
    private final String PRODUCT_ADDED_TO_CART_TOPIC = "product-added-to-cart";

    private final ProductRepository repository;
    private final DiscountService discountService;
    private final KafkaTemplate<String, ProductAddedToCartEvent> kafkaTemplate;

    public void addProductToCart(String productId, String cartId) {
        Thread.startVirtualThread(() -> computePriceAndPublishMessage(productId, cartId));
    }

    private void computePriceAndPublishMessage(String productId, String cartId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("not found!"));

        Price price = computePrice(productId, product);

        var event = new ProductAddedToCartEvent(productId, price.value(), price.currency(), cartId);
        kafkaTemplate.send(PRODUCT_ADDED_TO_CART_TOPIC, cartId, event);
    }
}
