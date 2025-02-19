package com.chensoul.bookstore.notification.config;

import com.chensoul.bookstore.api.event.BookstoreEvent;
import com.chensoul.bookstore.api.order.OrderCancelledEvent;
import com.chensoul.bookstore.api.order.OrderCreatedEvent;
import com.chensoul.bookstore.api.order.OrderEventType;
import com.chensoul.bookstore.notification.event.OrderEventHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    private static final Logger log = LoggerFactory.getLogger(MessageConfig.class);

    private final OrderEventHandler orderEventHandler;
    private final ObjectMapper objectMapper;

    public MessageConfig(OrderEventHandler orderEventHandler, ObjectMapper objectMapper) {
        this.orderEventHandler = orderEventHandler;
        this.objectMapper = objectMapper;
    }

    @Bean
    public Consumer<BookstoreEvent> messageProcessor() {
        return event -> {
            log.info("Process message {}...", event.getSource());

            switch (event.getOrderEventType()) {
                case OrderEventType.ORDER_CREATED:
                    OrderCreatedEvent orderCreatedEvent = null;
                    try {
                        orderCreatedEvent = objectMapper.readValue(
                                objectMapper.writeValueAsString(event.getSource()), OrderCreatedEvent.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    orderEventHandler.handle(orderCreatedEvent);
                    break;

                case OrderEventType.ORDER_CANCELLED:
                    OrderCancelledEvent orderCancelledEvent = null;
                    try {
                        orderCancelledEvent = objectMapper.readValue(
                                objectMapper.writeValueAsString(event.getSource()), OrderCancelledEvent.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    orderEventHandler.handle(orderCancelledEvent);
                    break;
            }

            log.info("Message processing done!");
        };
    }
}
