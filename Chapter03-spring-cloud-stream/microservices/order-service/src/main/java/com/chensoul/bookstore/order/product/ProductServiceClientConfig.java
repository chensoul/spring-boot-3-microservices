package com.chensoul.bookstore.order.product;

import com.chensoul.bookstore.order.config.ApplicationProperties;
import java.time.Duration;
import org.springframework.boot.web.client.ClientHttpRequestFactories;
import org.springframework.boot.web.client.ClientHttpRequestFactorySettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
class ProductServiceClientConfig {
    @Bean
    RestClient restClient(RestClient.Builder builder, ApplicationProperties properties) {
        return builder.baseUrl(properties.productServiceUrl())
                .requestFactory(ClientHttpRequestFactories.get(ClientHttpRequestFactorySettings.DEFAULTS
                        .withConnectTimeout(Duration.ofSeconds(5))
                        .withReadTimeout(Duration.ofSeconds(5))))
                .build();
    }
}
