package com.chensoul.bookstore.api.order;

import com.chensoul.bookstore.api.event.EventAware;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderErrorEvent(
        String eventId,
        String orderNumber,
        Set<OrderItem> items,
        Customer customer,
        Address deliveryAddress,
        String reason,
        LocalDateTime createdAt)
        implements EventAware {}
