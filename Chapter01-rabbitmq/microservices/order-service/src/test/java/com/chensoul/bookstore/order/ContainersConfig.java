package com.chensoul.bookstore.order;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {
    @Container
    static GenericContainer<?> authServer =
            new GenericContainer<>("chensoul/spring-authorization-server:0.0.1").withExposedPorts(9000);

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:17-alpine"));
    }

    @Bean
    @ServiceConnection
    RabbitMQContainer rabbitContainer() {
        return new RabbitMQContainer(DockerImageName.parse("rabbitmq:4-alpine"));
    }

    @DynamicPropertySource
    static void clientRegistrationProperties(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.security.oauth2.resourceserver.jwt.issuer-uri",
                () -> "http://localhost:" + authServer.getExposedPorts().get(0));
    }
}
