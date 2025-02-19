package com.chensoul.bookstore.order.event;

import com.chensoul.bookstore.api.event.BookstoreEvent;
import com.chensoul.bookstore.api.order.*;
import lombok.RequiredArgsConstructor;
import org.flywaydb.core.internal.util.JsonUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import static com.chensoul.bookstore.api.event.BookstoreEvent.REDIS_CHANNEL;

@RequiredArgsConstructor
@Component
public class OrderEventPublisher {
    private final ApplicationEventPublisher eventPublisher;
    private final StringRedisTemplate stringRedisTemplate;

    public void publish(OrderCreatedEvent event) {
        this.send(OrderEventType.ORDER_CREATED, event);
    }

    public void publish(OrderDeliveredEvent event) {
        this.send(OrderEventType.ORDER_DELIVERED, event);
    }

    public void publish(OrderCancelledEvent event) {
        this.send(OrderEventType.ORDER_CANCELLED, event);
    }

    public void publish(OrderErrorEvent event) {
        this.send(OrderEventType.ORDER_ERROR, event);
    }

    private void send(OrderEventType orderEventType, Object payload) {
        eventPublisher.publishEvent(new BookstoreEvent(orderEventType, payload));
        stringRedisTemplate.convertAndSend(REDIS_CHANNEL, JsonUtils.toJson(new BookstoreEvent(orderEventType, JsonUtils.toJson(payload))));
    }
}
