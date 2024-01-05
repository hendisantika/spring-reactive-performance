package com.hendisantika.springreactiveperformance.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collation = "products")
public record Product (
        @Id
        String id,
        String name,
        BigDecimal basePriceValue,
        String currency,
        Category category
) {

    public Price basePrice() {
        return new Price(basePriceValue, currency);
    }

    public enum Category {
        ELECTRONICS(false),
        CLOTHING(true),
        ACCESSORIES(false),
        GARDENING(false),
        SPORTS(true);

        private final boolean eligibleForPromotion;

        Category(boolean eligibleForPromotion) {
            this.eligibleForPromotion = eligibleForPromotion;
        }

        public boolean isEligibleForDiscount() {
            return eligibleForPromotion;
        }

        public boolean notEligibleForPromotion() {
            return !eligibleForPromotion;
        }
    }
}
