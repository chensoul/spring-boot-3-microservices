package com.chensoul.bookstore.api.event;

import com.chensoul.bookstore.api.order.OrderEventType;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BookstoreEvent extends ApplicationEvent {
    public static String REDIS_CHANNEL = "bookstore-topic";

    private final OrderEventType orderEventType;
    private final Object source;

    public BookstoreEvent(OrderEventType orderEventType, Object source) {
        super(source);
        this.orderEventType = orderEventType;
        this.source = source;
    }
}
