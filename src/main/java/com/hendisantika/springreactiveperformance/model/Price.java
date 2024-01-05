package com.hendisantika.springreactiveperformance.model;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 08:57
 * To change this template use File | Settings | File Templates.
 */
public record Price(BigDecimal value, String currency) {
    public Price applyDiscount(BigDecimal discount) {
        return new Price(value.subtract(discount), currency);
    }
}
