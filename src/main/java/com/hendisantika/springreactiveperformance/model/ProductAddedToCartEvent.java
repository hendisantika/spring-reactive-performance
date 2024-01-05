package com.hendisantika.springreactiveperformance.model;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 09:02
 * To change this template use File | Settings | File Templates.
 */
public record ProductAddedToCartEvent(String productId, BigDecimal price, String currency, String cartId) {
}
