package com.chensoul.bookstore.notification.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

@Configuration(proxyBeanMethods = false)
public class KafkaConfiguration {

    private final ConcurrentKafkaListenerContainerFactory<?, ?> concurrentKafkaListenerContainerFactory;

    public KafkaConfiguration(ConcurrentKafkaListenerContainerFactory<?, ?> concurrentKafkaListenerContainerFactory) {
        this.concurrentKafkaListenerContainerFactory = concurrentKafkaListenerContainerFactory;
    }

    @PostConstruct
    void setup() {
        this.concurrentKafkaListenerContainerFactory.getContainerProperties().setObservationEnabled(true);
    }
}
