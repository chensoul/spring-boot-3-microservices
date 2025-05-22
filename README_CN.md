![](https://socialify.git.ci/chensoul/spring-boot3-microservices/image?forks=1&issues=1&language=1&name=1&owner=1&stargazers=1&theme=Light)

<p align="center">
<a href="README.md">English Documentation</a>
</p>

使用 Spring Cloud、Istio 和 Kubernetes 构建的一个电商 [微服务](http://www.martinfowler.com/articles/microservices.html)
项目。

![microservices-architecture](./docs/microservices-architecture.png)

## 模块

- chapter01：Restful、SpringDoc、Resilience4j、RestClient、Redis
- chapter02：Rabbitmq
- chapter03：Kafka
- chapter04：Spring Cloud Stream
- chapter05：Zipkin Feign
- chapter06: Loki
- chapter07：ELK
- chapter08：Grafana
- chapter09：Spring Boot Admin Server
- chapter10：Eureka
- chapter11：Feign
- chapter12：Circuit Breaker
- chapter13：Spring Cloud Gateway
- chapter14：Spring Cloud Config
- chapter15：Helm
- chapter16：Kubernetes
- chapter17：Istio
- chapter18: Service Mesh
- chapter19: Native

## 技术栈

| 技术选型                                    | 使用版本     | 最新版本                                                                                                                                                                                                                                  | 备注 |
|-----------------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----|
| Spring Boot                             | 3.4.5        | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=3&metadataUrl=https://s01.oss.sonatype.org/content/repositories/releases/org/springframework/boot/spring-boot-dependencies/maven-metadata.xml">     |       |
| Spring Cloud                            | 2024.0.1     | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=202&metadataUrl=https://s01.oss.sonatype.org/content/repositories/releases/org/springframework/cloud/spring-cloud-dependencies/maven-metadata.xml"> |       |
| SpringDoc OpenAPI                       | 2.8.6        | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&metadataUrl=https://oss.sonatype.org/content/repositories/releases/org/springdoc/springdoc-openapi/maven-metadata.xml">                                           |       |
| Spring Boot Admin                       | 3.4.5        | <img src="https://img.shields.io/maven-metadata/v?label=&color=blue&versionPrefix=3&metadataUrl=https://repo1.maven.org/maven2/de/codecentric/spring-boot-admin-starter-server/maven-metadata.xml">                                   |       |

## 本地开发环境准备

- [Git](https://git-scm.com/downloads)
- [Docker](https://docs.docker.com/get-docker/)
- [Java](https://www.azul.com/downloads/#zulu)
- [Curl](https://curl.haxx.se/download.html)
- [Jq](https://stedolan.github.io/jq/download/)
- [Spring Boot CLI](https://docs.spring.io/spring-boot/docs/3.0.4/reference/html/getting-started.html#getting-started.installing.cli)
- [Siege](https://github.com/JoeDog/siege#where-is-it)
- [Helm](https://helm.sh/docs/intro/install/)
- [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl-macos/)
- [Minikube](https://minikube.sigs.k8s.io/docs/start/)
- [Istioctl](https://istio.io/latest/docs/setup/getting-started/#download)

安装软件：

```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

brew install orbstack
brew install spring-io/tap/spring-boot 
brew install openjdk@21 
brew install maven
brew install jq 
brew install siege 
brew install helm
brew install minikub 
brew install kubectl 
brew install istioctl

echo 'export JAVA_HOME=$(/usr/libexec/java_home -v8)' >> ~/.bash_profile
source ~/.bash_profile
```

验证版本：

```bash
git version && \
docker version -f json | jq -r .Client.Version && \
java -version 2>&1 | grep "openjdk version" && \
mvn -v | grep "Maven" && \
curl --version | grep "curl" | sed 's/(.*//' && \
jq --version && \
spring --version && \
siege --version 2>&1 | grep SIEGE && \
helm version --short && \
kubectl version --client -o json | jq -r .clientVersion.gitVersion && \
minikube version | grep "minikube" && \
istioctl version --remote=false
```

## 如何运行

以 Chapter01 为例，进入 microservices 目录，使用 Maven 插件构建镜像

```bash
cd Chapter01
cd microservices
mvn -ntp spring-boot:build-image -DskipTests
```

在某个章节的根目录下使用 docker 启动服务：

```bash
cd Chapter01
docker-compose -f docker-compose.yml -f docker-compose-app.yml up -d
```

### 使用 K8s 运行服务

## 参考

Video：

- [Mastering Microservices: Spring boot, Spring Cloud and Keycloak In 7 Hours](https://www.youtube.com/watch?v=jdeSV0GRvwI)
- [Distributed version of the Spring PetClinic Sample Application built with Spring Cloud and Spring AI](https://github.com/odedia/spring-boot3-microservices)
- [Spring Boot 3 Microservices with Kubernetes and Angular Complete Course in 7 Hours](https://www.youtube.com/watch?v=yn_stY3HCr8)

Code：

- https://github.com/chensoul/spring-boot-microservices-course
- https://github.com/PacktPublishing/Microservices-with-Spring-Boot-and-Spring-Cloud-Third-Edition
- https://github.com/eazybytes/microservices Grafana + Prometheus + Loki + Tempo
- https://github.com/abhisheksr01/spring-boot-microservice-best-practices
- https://github.com/odedia/spring-petclinic-microservices
- https://github.com/SaiUpadhyayula/spring-boot-3-microservices-course
- https://github.com/sivaprasadreddy/spring-boot-microservices-series
- https://github.com/in28minutes/spring-microservices-v3
- https://github.com/ali-bouali/microservices-full-code
- https://github.com/jhipster/jhipster-lite
- https://github.com/Nasruddin/spring-boot-based-microservices

## 贡献

非常欢迎[提出请求](https://help.github.com/articles/creating-a-pull-request) 。

## 许可

learn-spring-authorization-server 是在 [Apache 2.0 许可](https://www.apache.org/licenses/LICENSE-2.0.html)
下发布的开源软件 。
