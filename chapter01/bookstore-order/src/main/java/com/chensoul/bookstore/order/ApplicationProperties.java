package com.chensoul.bookstore.order;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "order")
public record ApplicationProperties(
        String productUrl,
        String orderEventExchange,
        String newOrderQueue,
        String deliveredOrderQueue,
        String cancelledOrderQueue,
        String errorOrderQueue) {}
