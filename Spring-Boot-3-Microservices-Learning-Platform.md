# Spring Boot 3 微服务技术学习平台

## 项目概述

**项目名称**: `spring-boot-3-microservices-learning`
**核心理念**: 通过渐进式架构演进，聚焦技术栈学习，展示从单体应用到云原生微服务的完整技术路径
**学习目标**: 掌握微服务架构的完整技术栈，包括分布式事务、消息通信、可观测性、云原生等核心技术

## 核心设计原则

### 1. 技术学习导向
- **业务简化**: 只包含3个核心服务（用户服务、商品服务、通知服务）
- **技术聚焦**: 重点学习微服务相关技术栈，而非复杂业务建模
- **循序渐进**: 13个阶段逐步提升技术复杂度

### 2. 完整技术覆盖
- **基础技术**: Spring Boot、数据库、安全、测试
- **微服务技术**: 服务拆分、服务通信、消息队列
- **分布式技术**: 分布式事务、分布式锁、分布式缓存
- **企业级技术**: Spring Cloud、Spring Cloud Alibaba
- **云原生技术**: Kubernetes、Istio、Service Mesh

## 项目结构

```
spring-boot-3-microservices-learning/
├── phases/                         # 13个渐进式学习阶段
│   ├── 01-monolith/               # 单体应用
│   ├── 02-messaging/              # 消息通信
│   ├── 03-data-management/        # 数据管理
│   ├── 04-observability/          # 可观测性
│   ├── 05-security/               # 安全与认证
│   ├── 06-basic-microservices/    # 基础微服务
│   ├── 07-distributed-transactions/ # 分布式事务
│   ├── 08-spring-cloud/           # Spring Cloud生态
│   ├── 09-spring-cloud-alibaba/   # Spring Cloud Alibaba生态
│   ├── 10-spring-ai/              # Spring AI集成
│   ├── 11-performance/            # 性能优化
│   ├── 12-devops/                 # DevOps与CI/CD
│   └── 13-cloud-native/           # 云原生
├── shared/                        # 版本化共享资源
│   ├── v01-monolith/             # 阶段1共享资源
│   ├── v02-messaging/            # 阶段2共享资源
│   ├── v03-data-management/      # 阶段3共享资源
│   ├── v04-observability/        # 阶段4共享资源
│   ├── v05-security/             # 阶段5共享资源
│   ├── v06-basic-microservices/  # 阶段6共享资源
│   ├── v07-distributed-transactions/ # 阶段7共享资源
│   ├── v08-spring-cloud/         # 阶段8共享资源
│   ├── v09-spring-cloud-alibaba/ # 阶段9共享资源
│   ├── v10-spring-ai/            # 阶段10共享资源
│   ├── v11-performance/          # 阶段11共享资源
│   ├── v12-devops/               # 阶段12共享资源
│   └── v13-cloud-native/         # 阶段13共享资源
├── docs/                         # 技术文档
└── examples/                     # 技术示例
```

## 13个学习阶段详解

### 阶段1：单体应用 (Monolith)
**学习目标**: 理解基础Spring Boot应用、业务建模和测试策略
**技术栈**: 
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL
- SpringDoc OpenAPI
- JUnit 5 + Mockito
- Spring Boot Test
- TestContainers

**学习内容**:
- Spring Boot 3.5.6 基础
- Spring Data JPA
- Spring Web MVC
- SpringDoc OpenAPI
- 数据库设计
- 单元测试 (JUnit 5, Mockito)
- 集成测试 (Spring Boot Test, TestContainers)
- 测试策略和最佳实践

### 阶段2：消息通信 (Messaging)
**学习目标**: 掌握消息队列在单体应用中的使用
**技术栈**:
- RabbitMQ
- Apache Kafka
- Spring AMQP
- Spring Kafka

**学习内容**:
- 消息队列基础概念
- RabbitMQ 基础使用
- Apache Kafka 基础使用
- Spring AMQP 集成
- Spring Kafka 集成
- 消息模式 (发布/订阅、点对点)
- 消息可靠性保证

### 阶段3：数据管理 (Data Management)
**学习目标**: 掌握微服务环境下的数据管理策略
**技术栈**:
- Spring Data JPA + PostgreSQL
- Spring Data MongoDB
- Redis + Caffeine
- ShardingSphere
- Canal
- 分布式缓存策略

**学习内容**:
- 数据一致性模式
- 数据库分片和读写分离
- 缓存策略和失效模式
- 数据同步和迁移
- 多数据源管理

### 阶段4：可观测性 (Observability)
**学习目标**: 掌握微服务监控和链路追踪
**技术栈**:
- Micrometer + Prometheus
- Grafana
- Zipkin / Jaeger
- ELK Stack / Loki

**学习内容**:
- 监控指标收集
- 日志聚合和分析
- 分布式链路追踪
- 告警和通知
- 性能监控

### 阶段5：安全与认证 (Security & Authentication)
**学习目标**: 掌握微服务安全认证和授权
**技术栈**:
- Spring Security 6
- OAuth2 + JWT
- Spring Authorization Server
- 微服务安全网关

**学习内容**:
- 微服务安全架构
- OAuth2 授权流程
- JWT Token 管理
- 微服务间安全通信
- 安全配置管理

### 阶段6：基础微服务 (Basic Microservices)
**学习目标**: 掌握微服务拆分和基础架构
**技术栈**:
- Spring Boot + Docker
- Resilience4j
- Spring Boot Actuator
- 分布式ID生成 (雪花算法)
- 基础分布式锁 (Redis)

**学习内容**:
- 微服务拆分原则
- HTTP服务间通信
- Resilience4j 容错处理
- Spring Boot Actuator 健康检查
- Docker 容器化
- 基础服务发现
- 分布式ID生成

### 阶段7：分布式事务 (Distributed Transactions) ⭐ 核心阶段
**学习目标**: 掌握分布式事务的各种模式和实现
**技术栈**:
- Seata (AT模式)
- Saga模式
- TCC模式
- 事件溯源 (Event Sourcing)
- CQRS模式
- 分布式事务监控

**学习内容**:
- 分布式事务理论
- 2PC/3PC协议
- Saga模式实现
- TCC模式实现
- 事件溯源模式
- CQRS模式
- 分布式事务监控

### 阶段8：Spring Cloud生态 (Spring Cloud Ecosystem)
**学习目标**: 掌握Spring Cloud微服务工具集
**技术栈**:
- Spring Cloud Gateway
- Spring Cloud Config
- Spring Cloud OpenFeign
- Spring Cloud LoadBalancer
- Spring Cloud Circuit Breaker

**学习内容**:
- API网关设计
- 配置中心管理
- 服务间调用
- 负载均衡
- 熔断器模式

### 阶段9：Spring Cloud Alibaba生态 (Spring Cloud Alibaba)
**学习目标**: 掌握阿里云微服务生态
**技术栈**:
- Nacos (服务发现 + 配置中心)
- Sentinel (熔断限流)
- Seata (分布式事务)
- Dubbo (RPC通信)
- OSS (对象存储)

**学习内容**:
- Nacos 服务发现和配置管理
- Sentinel 熔断限流策略
- Seata 分布式事务管理
- Dubbo 高性能RPC通信
- OSS 对象存储服务

### 阶段10：Spring AI集成 (Spring AI Integration) ⭐ 新增
**学习目标**: 掌握Spring AI在微服务中的应用
**技术栈**:
- Spring AI
- OpenAI API / Azure OpenAI
- 向量数据库 (Pinecone / Weaviate / PostgreSQL pgvector)
- RAG (Retrieval-Augmented Generation)
- AI服务集成
- 向量搜索

**学习内容**:
- Spring AI基础概念
- AI模型集成 (OpenAI, Azure OpenAI, Ollama)
- 向量数据库集成
- RAG应用开发
- AI服务微服务化
- 智能推荐系统
- 自然语言处理
- 图像处理服务
- AI服务监控和可观测性

### 阶段11：性能优化 (Performance Optimization)
**学习目标**: 掌握微服务性能优化技术
**技术栈**:
- JMeter + JProfiler
- PostgreSQL 优化 + 缓存优化
- MyBatis Plus (主要) + Spring Data JPA (辅助)
- 分布式性能测试
- 分布式缓存优化
- 安全性能优化
- AI服务性能优化

**学习内容**:
- 性能测试和监控
- PostgreSQL 性能优化
- 缓存策略优化
- 异步处理优化
- 连接池调优
- 系统瓶颈分析
- 安全性能优化
- AI服务性能优化

### 阶段12：DevOps与CI/CD (DevOps & CI/CD)
**学习目标**: 掌握微服务DevOps实践
**技术栈**:
- Git + Jenkins + Docker
- Kubernetes + Helm
- ArgoCD

**学习内容**:
- 版本控制和分支策略
- 持续集成和持续部署
- 容器化最佳实践
- 自动化测试和部署
- 代码质量检查
- 环境管理
- 安全部署策略

### 阶段13：云原生 (Cloud Native)
**学习目标**: 掌握云原生技术和容器编排
**技术栈**:
- Kubernetes + Istio
- GraalVM Native
- Spring Cloud Kubernetes
- Service Mesh
- 云原生监控
- 云原生安全
- 云原生存储

**学习内容**:
- Kubernetes 基础
- Istio Service Mesh
- GraalVM Native 编译
- Spring Cloud Kubernetes
- 云原生监控和日志
- 云原生安全策略
- 云原生存储方案

## 核心业务服务

### 3个核心服务
1. **user-service**: 用户管理、认证授权
2. **product-service**: 商品管理、库存管理
3. **notification-service**: 消息发送、通知管理

### 业务场景演进

#### 阶段1-7：无安全认证的业务场景
- 用户注册/登录 → 基础用户管理（无认证）
- 商品浏览/搜索 → 基础商品管理
- 用户操作通知 → 基础通知功能
- 服务间调用 → 基础服务通信
- 系统监控 → 基础监控功能

#### 阶段8-13：包含安全认证的业务场景
- 用户注册/登录 → 完整认证授权流程
- 商品浏览/搜索 → 权限控制
- 用户操作通知 → 安全通知
- 服务间调用 → 安全服务通信
- 系统监控 → 安全监控

## 持久化技术演进

### 阶段1-5：Spring Data JPA + PostgreSQL 为主
- 重点学习JPA基础概念
- 掌握Repository模式
- 理解ORM映射关系
- 学习PostgreSQL特性

### 阶段6：对比学习
- 同时学习JPA和MyBatis Plus
- 对比两种技术的优缺点
- 理解不同场景下的选择

### 阶段7-10：混合使用
- 根据业务场景选择合适的技术
- 学习两种技术的集成
- 掌握技术选型原则

### 阶段11-13：性能优化
- 重点使用MyBatis Plus进行PostgreSQL性能优化
- 学习PostgreSQL SQL优化技巧
- 掌握高并发数据访问

## 技术栈覆盖完整性

### 基础技术栈
- **框架**: Spring Boot 3.5.6、Spring Cloud 2025.0.0
- **数据库**: PostgreSQL、MongoDB
- **缓存**: Redis、Caffeine
- **消息队列**: Kafka、RabbitMQ、RocketMQ
- **安全**: Spring Security、OAuth2、JWT

### 分布式技术栈
- **分布式事务**: Seata、Saga、TCC、事件溯源、CQRS
- **分布式锁**: Redis分布式锁、Zookeeper分布式锁
- **分布式缓存**: Redis集群、缓存一致性
- **分布式ID**: 雪花算法、UUID
- **分布式搜索**: Elasticsearch
- **分布式任务**: XXL-Job、SchedulerX

### 微服务技术栈
- **服务治理**: Eureka、Nacos、Consul
- **API网关**: Spring Cloud Gateway
- **配置中心**: Spring Cloud Config、Nacos
- **服务调用**: OpenFeign、Dubbo
- **熔断限流**: Hystrix、Sentinel
- **链路追踪**: Zipkin、Jaeger

### 可观测性技术栈
- **监控**: Prometheus、Grafana
- **日志**: ELK Stack、Loki
- **链路追踪**: Zipkin、Jaeger
- **指标收集**: Micrometer

### AI技术栈
- **AI框架**: Spring AI
- **AI模型**: OpenAI、Azure OpenAI、Ollama
- **向量数据库**: Pinecone、Weaviate、PostgreSQL pgvector
- **RAG应用**: 检索增强生成
- **AI服务**: 文本生成、图像处理、语音识别

### 云原生技术栈
- **容器化**: Docker、Podman
- **容器编排**: Kubernetes、Docker Swarm
- **Service Mesh**: Istio、Linkerd
- **包管理**: Helm
- **CI/CD**: Jenkins、GitLab CI、ArgoCD

## 学习路径设计

### 学习分组
1. **基础阶段 (1)**: 单体应用 (包含测试策略)
2. **技术基础阶段 (2-5)**: 消息通信 → 数据管理 → 可观测性 → 安全与认证
3. **微服务核心阶段 (6-7)**: 基础微服务 → 分布式事务 (重点)
4. **企业级阶段 (8-9)**: Spring Cloud生态 → Spring Cloud Alibaba生态
5. **AI集成阶段 (10)**: Spring AI集成 (重点)
6. **生产优化阶段 (11-13)**: 性能优化 → DevOps与CI/CD → 云原生

### 学习时间规划
- **阶段1**: 3-4周 (基础阶段，包含测试策略)
- **阶段2-5**: 4-5周 (技术基础阶段)
- **阶段6-7**: 4-5周 (微服务核心阶段)
- **阶段8-9**: 4-5周 (企业级阶段)
- **阶段10**: 3-4周 (AI集成阶段)
- **阶段11-13**: 4-6周 (生产优化阶段)

## 共享资源管理策略

### 版本化演进
- **v01-monolith**: 基础API契约和工具库 (包含测试策略)
- **v02-messaging**: 添加消息通信配置
- **v03-data-management**: 添加数据管理配置
- **v04-observability**: 添加监控和链路追踪配置
- **v05-security**: 添加安全认证配置
- **v06-basic-microservices**: 添加微服务通信
- **v07-distributed-transactions**: 添加分布式事务配置
- **v08-spring-cloud**: 添加Spring Cloud配置
- **v09-spring-cloud-alibaba**: 添加Alibaba组件配置
- **v10-spring-ai**: 添加Spring AI配置
- **v11-performance**: 添加性能优化配置
- **v12-devops**: 添加DevOps配置
- **v13-cloud-native**: 添加云原生配置

### 管理优势
- **清晰演进**: 每个阶段都有明确的共享资源版本
- **向后兼容**: 可以回退到之前的版本
- **独立维护**: 每个版本可以独立维护
- **学习友好**: 清楚展示共享资源的演进过程

## 项目优势

### 1. 技术覆盖完整
- 覆盖从单体到云原生的完整技术栈
- 特别强化分布式事务、Spring Cloud Alibaba等核心技术
- 包含消息通信、可观测性、云原生等关键技术

### 2. 学习路径清晰
- 13个阶段循序渐进，每个阶段都建立在前一阶段基础上
- 避免技术跳跃和重复学习
- 适合不同水平的学习者

### 3. 生产就绪
- 所有代码都是生产级别的
- 遵循最佳实践和设计原则
- 包含完整的测试和部署方案

### 4. 共享资源管理
- 版本化共享资源管理
- 支持阶段间演进
- 避免代码重复和维护困难

## 实施建议

### 1. 开发顺序
- 按阶段顺序开发，确保每个阶段完整可用
- 先完成基础阶段，再逐步添加高级特性
- 每个阶段都要有完整的文档和测试

### 2. 维护策略
- 共享资源采用版本化管理
- 提供阶段间迁移工具和指南
- 定期更新技术栈版本

### 3. 学习支持
- 提供详细的学习文档和教程
- 包含常见问题和解决方案
- 提供在线演示和视频教程

## 学习资源和支持

### 官方文档链接
- [Spring Boot 官方文档](https://spring.io/projects/spring-boot)
- [Spring Cloud 官方文档](https://spring.io/projects/spring-cloud)
- [Spring Cloud Alibaba 官方文档](https://github.com/alibaba/spring-cloud-alibaba)
- [Spring AI 官方文档](https://spring.io/projects/spring-ai)
- [Kubernetes 官方文档](https://kubernetes.io/docs/)

### 参考项目

#### 核心参考项目
- **[Packt微服务项目](https://github.com/PacktPublishing/Microservices-with-Spring-Boot-and-Spring-Cloud-Third-Edition)** - Spring Boot 3 + Spring Cloud 2022完整实现，包含Kubernetes和Istio部署
- **[Spring PetClinic微服务](https://github.com/odedia/spring-petclinic-microservices)** - Spring官方微服务示例，经典业务场景
- **[in28Minutes微服务v3](https://github.com/in28minutes/spring-microservices-v3)** - 500+教学视频配套代码，学习资源丰富

#### 最佳实践项目
- **[微服务最佳实践](https://github.com/abhisheksr01/spring-boot-microservice-best-practices)** - 生产级微服务架构最佳实践
- **[Spring Boot 3微服务课程](https://github.com/SaiUpadhyayula/spring-boot-3-microservices-course)** - 最新Spring Boot 3技术栈
- **[微服务系列](https://github.com/sivaprasadreddy/spring-boot-microservices-series)** - 完整的微服务开发系列

#### 监控和可观测性
- **[EazyBytes微服务](https://github.com/eazybytes/microservices)** - 集成Grafana + Prometheus + Loki + Tempo完整监控栈
- **[完整微服务代码](https://github.com/ali-bouali/microservices-full-code)** - 包含完整的监控和部署配置

#### 开发工具和脚手架
- **[JHipster Lite](https://github.com/jhipster/jhipster-lite)** - 微服务项目快速生成工具
- **[Spring Boot微服务基础](https://github.com/Nasruddin/spring-boot-based-microservices)** - 微服务开发基础框架

### 学习建议

#### 结合参考项目学习
1. **理论学习 + 代码实践**: 结合本学习平台的13个阶段和参考项目的具体代码实现
2. **对比学习**: 对比不同项目的实现方式，理解最佳实践
3. **渐进式实践**: 从简单的Spring PetClinic开始，逐步学习复杂的Packt项目

#### 推荐学习路径
1. **基础阶段 (1-5)**: 参考Spring PetClinic微服务项目
2. **进阶阶段 (6-9)**: 参考Packt微服务项目和最佳实践项目
3. **高级阶段 (10-13)**: 参考EazyBytes监控项目和完整微服务代码

#### 实践建议
- **代码对比**: 每个阶段学习时，对比参考项目的实现方式
- **功能扩展**: 在参考项目基础上添加本平台的新技术特性
- **问题解决**: 遇到问题时，参考多个项目的解决方案

## CI/CD 配置建议

### GitHub Actions 多项目构建策略

#### 1. 智能构建配置
```yaml
# .github/workflows/smart-build.yml
name: Smart Multi-Phase Build

on:
  push:
    branches: [ main, develop ]
    paths:
      - 'phases/**'
      - 'shared/**'
  pull_request:
    branches: [ main ]
    paths:
      - 'phases/**'
      - 'shared/**'

jobs:
  detect-changes:
    runs-on: ubuntu-latest
    outputs:
      phases: ${{ steps.changes.outputs.phases }}
      shared: ${{ steps.changes.outputs.shared }}
    steps:
      - uses: actions/checkout@v4
      - uses: dorny/paths-filter@v2
        id: changes
        with:
          filters: |
            phases:
              - 'phases/**'
            shared:
              - 'shared/**'

  build-shared:
    if: needs.detect-changes.outputs.shared == 'true'
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build shared resources
        run: |
          find shared -name "pom.xml" -exec mvn -f {} clean install \;

  build-phases:
    needs: [detect-changes, build-shared]
    if: needs.detect-changes.outputs.phases == 'true'
    runs-on: ubuntu-latest
    strategy:
      matrix:
        phase: [01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13]
    steps:
      - uses: actions/checkout@v4
      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          java-version: '17'
          distribution: 'temurin'
      - name: Build phase ${{ matrix.phase }}
        run: |
          cd phases/$(printf "%02d" ${{ matrix.phase }})-*
          mvn clean test
```

#### 2. 阶段依赖构建
```yaml
# .github/workflows/phase-dependency-build.yml
name: Phase Dependency Build

jobs:
  build-phase-01:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Build Phase 01 (Monolith)
        run: |
          cd phases/01-monolith
          mvn clean install

  build-phase-02:
    needs: build-phase-01
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Build Phase 02 (Messaging)
        run: |
          cd phases/02-messaging
          mvn clean install

  # 后续阶段类似...
```

#### 3. 部署配置
```yaml
# .github/workflows/deploy.yml
name: Deploy Phases

on:
  push:
    branches: [ main ]
    tags: [ 'v*' ]

jobs:
  deploy:
    runs-on: ubuntu-latest
    strategy:
      matrix:
        phase: [01, 02, 03, 04, 05, 06, 07, 08, 09, 10, 11, 12, 13]
    steps:
      - uses: actions/checkout@v4
      - name: Deploy Phase ${{ matrix.phase }}
        run: |
          cd phases/$(printf "%02d" ${{ matrix.phase }})-*
          docker build -t microservices-phase-${{ matrix.phase }} .
          # 推送到容器仓库
```

### 多项目构建优势

#### ✅ 优势
1. **并行构建**: 多个阶段可以并行构建
2. **智能触发**: 只有修改的阶段才会重新构建
3. **依赖管理**: 自动处理阶段间的依赖关系
4. **资源优化**: 避免不必要的构建，节省CI资源

#### ⚠️ 注意事项
1. **构建时间**: 13个阶段并行构建可能消耗较多资源
2. **依赖顺序**: 需要确保共享资源先构建完成
3. **测试策略**: 每个阶段都需要独立的测试环境
4. **部署复杂性**: 需要管理多个独立服务的部署

### 推荐配置

对于我们的学习平台，推荐使用**智能构建策略**：

1. **开发阶段**: 使用智能构建，只构建修改的部分
2. **发布阶段**: 使用完整构建，确保所有阶段都正常
3. **学习阶段**: 提供单阶段构建选项，方便学习者测试

## 总结

这个Spring Boot 3微服务技术学习平台提供了一个完整的、基于真实业务场景的微服务学习路径。通过13个渐进式阶段，学习者可以掌握从单体应用到云原生微服务的完整技术栈，特别强化了分布式事务、Spring Cloud Alibaba生态、Spring AI集成等核心技术的学习和实践。

项目设计既保持了技术学习的完整性，又避免了过度复杂化，是一个理想的微服务技术学习平台。
