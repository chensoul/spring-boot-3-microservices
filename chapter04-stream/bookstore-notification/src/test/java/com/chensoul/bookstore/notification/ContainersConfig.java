package com.chensoul.bookstore.notification;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {
    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:17-alpine"));
    }

    @Bean
    @ServiceConnection
    MongoDBContainer mongoDBContainer() {
        return new MongoDBContainer(DockerImageName.parse("mongo:8.0.4"));
    }

    @Bean
    @ServiceConnection
    RabbitMQContainer rabbitContainer() {
        return new RabbitMQContainer(DockerImageName.parse("rabbitmq:4-alpine"));
    }

    @Bean
    GenericContainer<?> mailhogContainer() {
        GenericContainer<?> container =
                new GenericContainer(DockerImageName.parse("mailhog/mailhog:v1.0.1")).withExposedPorts(1025);
        container.start();
        return container;
    }

    @Bean
    DynamicPropertyRegistrar apiPropertiesRegistrar(GenericContainer mailhogContainer) {
        return registry -> {
            registry.add("spring.mail.host", mailhogContainer::getContainerIpAddress);
            registry.add("spring.mail.port", mailhogContainer::getFirstMappedPort);
        };
    }
}
