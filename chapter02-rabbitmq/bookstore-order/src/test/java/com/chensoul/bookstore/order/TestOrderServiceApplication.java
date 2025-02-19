package com.chensoul.bookstore.order;

import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrderApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
