package com.chensoul.bookstore.order;

import com.github.dockerjava.api.model.PortBinding;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.containers.RabbitMQContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
// @ContextConfiguration(initializers = ContainersConfig.EnvInitializer.class)
public class ContainersConfig {
    @Container
    static GenericContainer<?> authServer;

    static {
        authServer = new GenericContainer<>("chensoul/spring-authorization-server:0.0.1")
                .withExposedPorts(9000)
                .withCreateContainerCmdModifier(cmd -> cmd.withPortBindings(PortBinding.parse("9000:9000")));
        authServer.start();
    }

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add(
                "spring.security.oauth2.resourceserver.jwt.issuer-uri",
                () -> "http://localhost:" + authServer.getFirstMappedPort());
    }

    static class EnvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(String.format(
                            "spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:%s",
                            authServer.getFirstMappedPort()))
                    .applyTo(applicationContext);
        }
    }

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
}
