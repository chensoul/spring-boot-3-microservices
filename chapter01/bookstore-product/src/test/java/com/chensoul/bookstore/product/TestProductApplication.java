package com.chensoul.bookstore.product;

import org.springframework.boot.SpringApplication;

public class TestProductApplication {

    public static void main(String[] args) {
        SpringApplication.from(ProductApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
