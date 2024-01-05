package com.hendisantika.springreactiveperformance.webflux;

import com.hendisantika.springreactiveperformance.config.KafkaTemplate;
import com.hendisantika.springreactiveperformance.model.ProductAddedToCartEvent;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 09:03
 * To change this template use File | Settings | File Templates.
 */
@RequiredArgsConstructor
public class ProductService {
    private final String PRODUCT_ADDED_TO_CART_TOPIC = "product-added-to-cart";

    private final ProductRepository repository;
    private final DiscountService discountService;
    private final KafkaTemplate<String, ProductAddedToCartEvent> kafkaTemplate;

    public void addProductToCart(String productId, String cartId) {
        repository.findById(productId)
                .switchIfEmpty(Mono.error(() -> new IllegalArgumentException("not found!")))
                .flatMap(this::computePrice)
                .map(price -> new ProductAddedToCartEvent(productId, price.value(), price.currency(), cartId))
                .subscribe(event -> kafkaTemplate.send(PRODUCT_ADDED_TO_CART_TOPIC, cartId, event));
    }
}
