package com.chensoul.bookstore.notification.event;

import com.chensoul.bookstore.api.event.BookstoreEvent;
import com.chensoul.bookstore.api.order.*;
import com.chensoul.bookstore.notification.domain.NotificationService;
import com.chensoul.bookstore.notification.domain.OrderEventEntity;
import com.chensoul.bookstore.notification.domain.OrderEventRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
@Transactional
public class OrderEventHandler {
    private static final Logger log = LoggerFactory.getLogger(OrderEventHandler.class);

    private final NotificationService notificationService;
    private final OrderEventRepository orderEventRepository;
    private final ObjectMapper mapper;

    @Async
    @EventListener(BookstoreEvent.class)
    public void handleEvent(BookstoreEvent bookstoreEvent) throws JsonProcessingException {
        OrderEventType orderEventType = bookstoreEvent.getOrderEventType();
        Object source = bookstoreEvent.getSource();
        if (orderEventType.equals(OrderEventType.ORDER_CREATED)) {
            handle(source instanceof OrderCreatedEvent ? (OrderCreatedEvent) source : mapper.readValue(source.toString(), OrderCreatedEvent.class));
        } else if (orderEventType.equals(OrderEventType.ORDER_CANCELLED)) {
            handle(source instanceof OrderCancelledEvent ? (OrderCancelledEvent) source : mapper.readValue(source.toString(), OrderCancelledEvent.class));
        } else if (orderEventType.equals(OrderEventType.ORDER_DELIVERED)) {
            handle(source instanceof OrderDeliveredEvent ? (OrderDeliveredEvent) source : mapper.readValue(source.toString(), OrderDeliveredEvent.class));
        } else if (orderEventType.equals(OrderEventType.ORDER_ERROR)) {
            handle(source instanceof OrderErrorEvent ? (OrderErrorEvent) source : mapper.readValue(source.toString(), OrderErrorEvent.class));
        }
    }

    public void handle(OrderCreatedEvent orderCreatedEvent) {
        if (orderEventRepository.existsByEventId(orderCreatedEvent.eventId())) {
            log.warn("Received duplicate OrderCreatedEvent with eventId: {}", orderCreatedEvent.eventId());
            return;
        }
        log.info("Received a OrderCreatedEvent with orderNumber:{}: ", orderCreatedEvent.orderNumber());
        notificationService.sendOrderCreatedNotification(orderCreatedEvent);
        var orderEvent = new OrderEventEntity(orderCreatedEvent.eventId(), OrderEventType.ORDER_CREATED);
        orderEventRepository.save(orderEvent);
    }

    public void handle(OrderDeliveredEvent orderDeliveredEvent) {
        if (orderEventRepository.existsByEventId(orderDeliveredEvent.eventId())) {
            log.warn("Received duplicate OrderDeliveredEvent with eventId: {}", orderDeliveredEvent.eventId());
            return;
        }
        log.info("Received a OrderDeliveredEvent with orderNumber:{}: ", orderDeliveredEvent.orderNumber());
        notificationService.sendOrderDeliveredNotification(orderDeliveredEvent);
        var orderEvent = new OrderEventEntity(orderDeliveredEvent.eventId(), OrderEventType.ORDER_DELIVERED);
        orderEventRepository.save(orderEvent);
    }

    public void handle(OrderCancelledEvent orderCancelledEvent) {
        if (orderEventRepository.existsByEventId(orderCancelledEvent.eventId())) {
            log.warn("Received duplicate OrderCancelledEvent with eventId: {}", orderCancelledEvent.eventId());
            return;
        }
        notificationService.sendOrderCancelledNotification(orderCancelledEvent);
        log.info("Received a OrderCancelledEvent with orderNumber:{}: ", orderCancelledEvent.orderNumber());
        var orderEvent = new OrderEventEntity(orderCancelledEvent.eventId(), OrderEventType.ORDER_CANCELLED);
        orderEventRepository.save(orderEvent);
    }

    public void handle(OrderErrorEvent orderErrorEvent) {
        if (orderEventRepository.existsByEventId(orderErrorEvent.eventId())) {
            log.warn("Received duplicate OrderErrorEvent with eventId: {}", orderErrorEvent.eventId());
            return;
        }
        log.info("Received a OrderErrorEvent with orderNumber:{}: ", orderErrorEvent.orderNumber());
        notificationService.sendOrderErrorEventNotification(orderErrorEvent);
        OrderEventEntity orderEvent = new OrderEventEntity(orderErrorEvent.eventId(), OrderEventType.ORDER_ERROR);
        orderEventRepository.save(orderEvent);
    }
}
