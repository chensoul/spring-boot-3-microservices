package com.chensoul.bookstore.api.order;

public record CreateOrderResponse(String orderNumber, OrderStatus status) {}
