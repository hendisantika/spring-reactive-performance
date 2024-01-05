package com.hendisantika.springreactiveperformance.virtualthreads;

import com.hendisantika.springreactiveperformance.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

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
public interface ProductRepository extends MongoRepository<Product, String> {
}
