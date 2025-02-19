package com.chensoul.bookstore.webapp.client.order;

import com.chensoul.bookstore.api.order.CreateOrderRequest;
import com.chensoul.bookstore.api.order.CreateOrderResponse;
import com.chensoul.bookstore.api.order.OrderDTO;
import com.chensoul.bookstore.api.order.OrderSummary;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

@FeignClient(name = "bookstore-order")
public interface OrderServiceClient {
    @PostMapping("/api/orders")
    CreateOrderResponse createOrder(
            @RequestHeader Map<String, ?> headers, @RequestBody CreateOrderRequest orderRequest);

    @GetMapping("/api/orders")
    List<OrderSummary> getOrders(@RequestHeader Map<String, ?> headers);

    @GetMapping("/api/orders/{orderNumber}")
    OrderDTO getOrder(@RequestHeader Map<String, ?> headers, @PathVariable String orderNumber);
}
