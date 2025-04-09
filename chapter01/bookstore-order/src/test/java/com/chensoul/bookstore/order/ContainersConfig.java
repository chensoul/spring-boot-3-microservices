package com.chensoul.bookstore.order;

import com.github.dockerjava.api.model.PortBinding;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistrar;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class ContainersConfig {
    @Bean
    GenericContainer<?> authServerContainer() {
        GenericContainer<?> container = new GenericContainer<>(
                        DockerImageName.parse("chensoul/spring-authorization-server:0.0.1"))
                .withExposedPorts(9000)
                .withCreateContainerCmdModifier(cmd -> cmd.withPortBindings(PortBinding.parse("9000:9000")));

        container.start();
        return container;
    }

    @Bean
    GenericContainer<?> redisContainer() {
        GenericContainer<?> container = new GenericContainer<>(DockerImageName.parse("redis:7")).withExposedPorts(6379);
        container.start();
        return container;
    }

    @Bean
    DynamicPropertyRegistrar apiPropertiesRegistrar(
            GenericContainer<?> authServerContainer, GenericContainer<?> redisContainer) {
        return registry -> {
            registry.add(
                    "spring.security.oauth2.resourceserver.jwt.issuer-uri",
                    () -> "http://localhost:" + authServerContainer.getFirstMappedPort());

            registry.add("spring.data.redis.host", redisContainer::getHost);
            registry.add("spring.data.redis.port", redisContainer::getFirstMappedPort);
        };
    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return new PostgreSQLContainer<>(DockerImageName.parse("postgres:17-alpine"));
    }
}
