package com.hendisantika.springreactiveperformance.webflux;

import com.hendisantika.springreactiveperformance.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

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
interface ProductRepository extends ReactiveMongoRepository<Product, String> {
}
