package com.hendisantika.springreactiveperformance.config;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-reactive-performance
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/5/24
 * Time: 09:01
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
public class KafkaTemplate<K, V> {

    // For simplicity in this example and article, an actual Kafka client isn't utilized.
    // The focus remains on demonstrating the basic principles without the complexities of a full Kafka client setup.

    public CompletableFuture<Void> send(String topic, K key, V value) {
        log.info("Sending message to topic: " + topic + " with value: " + value);
        return CompletableFuture.completedFuture(null);
    }
}
