package com.chensoul.bookstore.order.event;

import com.chensoul.bookstore.api.order.OrderCancelledEvent;
import com.chensoul.bookstore.api.order.OrderCreatedEvent;
import com.chensoul.bookstore.api.order.OrderDeliveredEvent;
import com.chensoul.bookstore.api.order.OrderErrorEvent;
import com.chensoul.bookstore.order.config.ApplicationProperties;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {
    private final KafkaTemplate kafkaTemplate;
    private final ApplicationProperties properties;

    OrderEventPublisher(KafkaTemplate kafkaTemplate, ApplicationProperties properties) {
        this.kafkaTemplate = kafkaTemplate;
        this.properties = properties;
    }

    public void publish(OrderCreatedEvent event) {
        this.send(properties.newOrderQueue(), event);
    }

    public void publish(OrderDeliveredEvent event) {
        this.send(properties.deliveredOrderQueue(), event);
    }

    public void publish(OrderCancelledEvent event) {
        this.send(properties.cancelledOrderQueue(), event);
    }

    public void publish(OrderErrorEvent event) {
        this.send(properties.errorOrderQueue(), event);
    }

    private void send(String routingKey, Object payload) {
        kafkaTemplate.send(properties.orderEventExchange(), routingKey, payload);
    }
}
