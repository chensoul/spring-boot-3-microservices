package com.chensoul.bookstore.notification.event;

import static com.chensoul.bookstore.api.event.BookstoreEvent.REDIS_CHANNEL;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import com.chensoul.bookstore.api.event.BookstoreEvent;
import com.chensoul.bookstore.api.order.*;
import com.chensoul.bookstore.notification.AbstractIT;
import com.chensoul.bookstore.notification.config.ApplicationProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

class OrderEventHandlerTests extends AbstractIT {
    private final String REDIS_CHANNEL = "test-topic";

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    ObjectMapper objectMapper;

    Customer customer = new Customer("Chensoul", "ichensoul@gmail.com", "999999999");
    Address address = new Address("addr line 1", null, "Hyderabad", "TS", "500072", "India");

    @Test
    void shouldHandleOrderCreatedEvent() throws JsonProcessingException {
        String orderNumber = UUID.randomUUID().toString();

        OrderCreatedEvent event = new OrderCreatedEvent(
                UUID.randomUUID().toString(), orderNumber, Set.of(), customer, address, LocalDateTime.now());
        stringRedisTemplate.convertAndSend(REDIS_CHANNEL, objectMapper.writeValueAsString(new BookstoreEvent(OrderEventType.ORDER_CREATED, objectMapper.writeValueAsString(event))));

        await().atMost(30, SECONDS).untilAsserted(() -> {
            verify(notificationService).sendOrderCreatedNotification(any(OrderCreatedEvent.class));
        });
    }

    @Test
    void shouldHandleOrderDeliveredEvent() throws JsonProcessingException {
        String orderNumber = UUID.randomUUID().toString();

        var event = new OrderDeliveredEvent(
                UUID.randomUUID().toString(), orderNumber, Set.of(), customer, address, LocalDateTime.now());
        stringRedisTemplate.convertAndSend(REDIS_CHANNEL, objectMapper.writeValueAsString(new BookstoreEvent(OrderEventType.ORDER_DELIVERED, objectMapper.writeValueAsString(event))));

        await().atMost(30, SECONDS).untilAsserted(() -> {
            verify(notificationService).sendOrderDeliveredNotification(any(OrderDeliveredEvent.class));
        });
    }

    @Test
    void shouldHandleOrderCancelledEvent() throws JsonProcessingException {
        String orderNumber = UUID.randomUUID().toString();

        OrderCancelledEvent event = new OrderCancelledEvent(
                UUID.randomUUID().toString(),
                orderNumber,
                Set.of(),
                customer,
                address,
                "test cancel reason",
                LocalDateTime.now());
        stringRedisTemplate.convertAndSend(REDIS_CHANNEL, objectMapper.writeValueAsString(new BookstoreEvent(OrderEventType.ORDER_CANCELLED, objectMapper.writeValueAsString(event))));

        await().atMost(30, SECONDS).untilAsserted(() -> {
            verify(notificationService).sendOrderCancelledNotification(any(OrderCancelledEvent.class));
        });
    }

    @Test
    void shouldHandleOrderErrorEvent() throws JsonProcessingException {
        String orderNumber = UUID.randomUUID().toString();

        var event = new OrderErrorEvent(
                UUID.randomUUID().toString(),
                orderNumber,
                Set.of(),
                customer,
                address,
                "test error reason",
                LocalDateTime.now());
        stringRedisTemplate.convertAndSend(REDIS_CHANNEL, objectMapper.writeValueAsString(new BookstoreEvent(OrderEventType.ORDER_ERROR, objectMapper.writeValueAsString(event))));

        await().atMost(30, SECONDS).untilAsserted(() -> {
            verify(notificationService).sendOrderErrorEventNotification(any(OrderErrorEvent.class));
        });
    }
}
