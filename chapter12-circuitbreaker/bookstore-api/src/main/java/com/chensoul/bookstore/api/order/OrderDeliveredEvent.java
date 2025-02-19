package com.chensoul.bookstore.api.order;

import com.chensoul.bookstore.api.event.EventAware;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderDeliveredEvent(
        String eventId,
        String orderNumber,
        Set<OrderItem> items,
        Customer customer,
        Address deliveryAddress,
        LocalDateTime createdAt)
        implements EventAware {}
