package com.chensoul.bookstore.order.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "order")
public record ApplicationProperties(
        String productServiceUrl,
        String orderEventExchange,
        String newOrderQueue,
        String deliveredOrderQueue,
        String cancelledOrderQueue,
        String errorOrderQueue) {}
