![video_spider](https://socialify.git.ci/chensoul/spring-boot-3-microservices/image?forks=1&issues=1&language=1&name=1&owner=1&stargazers=1&theme=Light)

<p align="center">
<a href="README_CN.md">中文文档</a>
</p>

Build resilient and scalable microservices using Spring Cloud, Istio, and Kubernetes.

![microservices-architecture](./docs/microservices-architecture.jpg)

## Modules

- Chapter01：Restful、SpringDoc、Resilience4j、RestClient、Rabbitmq
- Chapter02：Kafka
- Chapter03：Spring Cloud Stream
- Chapter04：Feign
- Chapter05：负载均衡 Spring Cloud Loadbalancer
- Chapter06：服务发现 Eureka
- Chapter07：配置服务 Spring Cloud Config
- Chapter08：服务网关 Spring Cloud Gateway
- Chapter09: 监控服务 Spring Boot Admin
- Chapter11: 链路追踪 Zipkin
- Chapter12: Loki
- Chapter13：Grafana
- Chapter14：ELK
- Chapter15：Helm
- Chapter16：Kubernetes
- Chapter17：Istio
- chapter18: Service Mesh
- chapter19: Native

## Tech Stack

* Building Spring Boot REST APIs
* Creating Aggregated Swagger Documentation at API Gateway
* Database Persistence using Spring Data JPA, MySQL, Mongodb, Flyway
* Distributed Tracing using Zipkin
* Distributed Logging using ELK, Loki
* Event Driven Async Communication using Spring Kafka, RabbitMQ, ActiveMQ, Spring Cloud Stream
* Implementing API Gateway using Spring Cloud Gateway
* Implementing Resiliency using Resilience4j
* Using WebClient, Declarative HTTP Interfaces to invoke other APIs
* Local Development Setup using Docker, Docker Compose and Testcontainers
* Monitoring & Observability using Grafana, Prometheus, Tempo
* Testing using JUnit 5, RestAssured, Testcontainers, Awaitility, WireMock
* Deployment to Kubernetes using Kind, Helm


| 技术选型                                    | 使用版本     | 最新版本                                                                                                                                                                                                                                  | 备注 |
|-----------------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----|
| Java                                    | 21       | 23                                                                                                                                                                                                                                    |    |
| Maven                                   | 3.9.9    | 3.9.9                                                                                                                                                                                                                                 |    |
| PostgreSQL                              | 17       | 17                                                                                                                                                                                                                                    |    |
| MongoDB                                 | 8.0.4    | 8.0.4                                                                                                                                                                                                                                 |    |
| Rabbitmq                                | 4        | 4                                                                                                                                                                                                                                     |    |
| Kafka                                   | 3.8      | 3.8                                                                                                                                                                                                                                   |    |
| Kubernetes                              | 1.31     |                                                                                                                                                                                                                                       |    |
| Grafana (Prometheus/Grafana/Loki/Tempo) |          |                                                                                                                                                                                                                                       |    |
| ELK                                     | 8.5.3    |                                                                                                                                                                                                                                       |    |
| Spring Boot                             | 3.4.2    | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=3&metadataUrl=https://s01.oss.sonatype.org/content/repositories/releases/org/springframework/boot/spring-boot-dependencies/maven-metadata.xml">     |    |
| Spring Boot Admin                       | 3.4.1    | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=3&metadataUrl=https://repo1.maven.org/maven2/de/codecentric/spring-boot-admin-starter-server/maven-metadata.xml">                                   |    |
| Spring Cloud                            | 2024.0.0 | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=202&metadataUrl=https://s01.oss.sonatype.org/content/repositories/releases/org/springframework/cloud/spring-cloud-dependencies/maven-metadata.xml"> |    |
| SpringDoc OpenAPI                       | 2.8.4    | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&metadataUrl=https://oss.sonatype.org/content/repositories/releases/org/springdoc/springdoc-openapi/maven-metadata.xml">                                           |    |


## Local Development Setup

- Install Java 21 and Maven 3. Recommend using [SDKMAN](https://sdkman.io/).
- Install [Docker](https://www.docker.com/). Recommend using [OrbStack](https://orbstack.dev/) for Macos.
- Install [IntelliJ](https://www.jetbrains.com/idea) IDEA or any of your favorite IDE
- Install [Postman](https://www.postman.com/) or any REST Client

## References

Video：

- [Mastering Microservices: Spring boot, Spring Cloud and Keycloak In 7 Hours](https://www.youtube.com/watch?v=jdeSV0GRvwI)
- [Distributed version of the Spring PetClinic Sample Application built with Spring Cloud and Spring AI](https://github.com/odedia/spring-boot3-microservices)
- [Spring Boot 3 Microservices with Kubernetes and Angular Complete Course in 7 Hours](https://www.youtube.com/watch?v=yn_stY3HCr8)

Code：

- https://github.com/chensoul/Microservices-with-Spring-Boot-and-Spring-Cloud-Third-Edition
- https://github.com/eazybytes/microservices Grafana + Prometheus + Loki + Tempo
- https://github.com/chensoul/spring-boot-3-microservices-course
- https://github.com/chensoul/spring-petclinic-microservices
- https://github.com/chensoul/spring-boot-microservices-course
- https://github.com/chensoul/spring-boot-3-microservices-course
- https://github.com/in28minutes/spring-microservices-v3
- https://github.com/ali-bouali/microservices-full-code
- https://github.com/jhipster/jhipster-lite
- https://github.com/sivaprasadreddy/spring-boot-microservices-series
- https://github.com/Nasruddin/spring-boot-based-microservices