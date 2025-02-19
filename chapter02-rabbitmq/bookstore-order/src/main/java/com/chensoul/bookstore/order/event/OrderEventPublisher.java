package com.chensoul.bookstore.order.event;

import com.chensoul.bookstore.api.order.OrderCancelledEvent;
import com.chensoul.bookstore.api.order.OrderCreatedEvent;
import com.chensoul.bookstore.api.order.OrderDeliveredEvent;
import com.chensoul.bookstore.api.order.OrderErrorEvent;
import com.chensoul.bookstore.order.config.ApplicationProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;
    private final ApplicationProperties properties;

    OrderEventPublisher(RabbitTemplate rabbitTemplate, ApplicationProperties properties) {
        this.rabbitTemplate = rabbitTemplate;
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
        rabbitTemplate.convertAndSend(properties.orderEventExchange(), routingKey, payload);
    }
}
