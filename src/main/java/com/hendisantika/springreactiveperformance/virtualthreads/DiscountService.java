package com.hendisantika.springreactiveperformance.virtualthreads;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
public class DiscountService {

    public BigDecimal discountForProduct(String productId) {
        return BigDecimal.valueOf(10);
    }
}
