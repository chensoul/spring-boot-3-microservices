package com.chensoul.bookstore.order;

import org.springframework.boot.SpringApplication;

public class TestOrderApplication {

    public static void main(String[] args) {
        SpringApplication.from(OrderApplication::main)
                .with(ContainersConfig.class)
                .run(args);
    }
}
