package com.chensoul.bookstore.webapp.client.product;

import com.chensoul.bookstore.api.common.PagedResult;
import com.chensoul.bookstore.api.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@FeignClient(name = "bookstore-product")
public interface ProductServiceClient {

    @GetMapping("/api/products")
    PagedResult<Product> getProducts(@RequestParam int page);

    @GetMapping("/api/products/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code);
}
