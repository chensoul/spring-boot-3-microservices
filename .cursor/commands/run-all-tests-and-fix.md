# 运行所有测试并修复失败用例

## 概览
运行完整测试套件并有条理地修复所有失败用例，确保代码质量与功能完好。基于Spring Boot + MyBatis Plus + MySQL技术栈的测试最佳实践。

## 测试类型与框架

### 测试分类
- **单元测试**: 使用JUnit 5 + Mockito测试单个组件
- **集成测试**: 使用@SpringBootTest + Testcontainers测试完整流程
- **契约测试**: 使用RestAssured测试API契约
- **架构测试**: 使用ArchUnit测试架构约束
- **性能测试**: 使用JMeter或Gatling进行压力测试

### 测试框架
- **JUnit 5**: 主要测试框架
- **Mockito**: Mock和Stub框架
- **Testcontainers**: 集成测试容器化
- **RestAssured**: API测试框架
- **ArchUnit**: 架构测试框架
- **JaCoCo**: 代码覆盖率工具

## 测试执行流程

### 1. 环境准备

#### 1.1 依赖服务启动
```bash
# 启动MySQL、Redis、RabbitMQ等依赖服务
docker-compose up -d

# 验证服务状态
docker-compose ps

# 检查服务健康状态
curl http://localhost:8080/actuator/health
```

#### 1.2 测试环境配置
```bash
# 设置测试环境变量
export SPRING_PROFILES_ACTIVE=test
export MYSQL_DATABASE=test_db
export REDIS_HOST=localhost

# 清理测试数据
mvn clean
```

### 2. 运行测试套件

#### 2.1 完整测试执行
```bash
# 运行所有测试（单元测试 + 集成测试）
mvn clean test

# 运行集成测试
mvn test -Dtest="*IT"

# 运行单元测试
mvn test -Dtest="*Test"

# 运行特定模块测试
mvn test -pl rose-service/rose-billing-service

# 运行特定测试类
mvn test -Dtest="TodoControllerTest"

# 运行特定测试方法
mvn test -Dtest="TodoControllerTest#testCreateTodo"
```

#### 2.2 测试覆盖率检查
```bash
# 生成覆盖率报告
mvn clean test jacoco:report

# 查看覆盖率报告
open target/site/jacoco/index.html

# 检查覆盖率阈值
mvn jacoco:check
```

#### 2.3 并行测试执行
```bash
# 并行运行测试（提高执行速度）
mvn test -T 4

# 使用Surefire并行执行
mvn test -Dparallel=methods -DthreadCount=4
```

### 3. 测试结果分析

#### 3.1 测试报告查看
```bash
# 查看Surefire测试报告
open target/surefire-reports/index.html

# 查看JaCoCo覆盖率报告
open target/site/jacoco/index.html

# 查看SonarQube报告（如果配置）
mvn sonar:sonar
```

#### 3.2 失败测试分类
- **编译错误**: 语法错误、依赖缺失
- **配置错误**: 配置文件问题、环境变量缺失
- **逻辑错误**: 业务逻辑错误、边界条件处理
- **集成错误**: 服务依赖问题、数据库连接问题
- **性能问题**: 超时、内存泄漏、资源竞争
- **不稳定测试**: 随机失败、时序依赖

### 4. 问题修复策略

#### 4.1 按优先级修复
1. **P0 - 编译错误**: 立即修复，阻塞构建
2. **P1 - 配置错误**: 高优先级，影响功能
3. **P2 - 逻辑错误**: 中优先级，影响业务
4. **P3 - 集成错误**: 低优先级，环境问题
5. **P4 - 性能问题**: 优化优先级，影响体验

#### 4.2 修复步骤
1. **定位问题**: 分析错误日志和堆栈跟踪
2. **理解原因**: 确定根本原因和影响范围
3. **制定方案**: 设计修复方案和测试策略
4. **实施修复**: 编写代码修复问题
5. **验证修复**: 运行相关测试验证修复效果
6. **回归测试**: 运行完整测试套件确保无副作用

## 常见问题与解决方案

### 1. 编译错误

#### 1.1 依赖问题
```bash
# 清理并重新下载依赖
mvn clean dependency:purge-local-repository
mvn dependency:resolve

# 检查依赖冲突
mvn dependency:tree -Dverbose

# 解决依赖冲突
mvn dependency:analyze
```

#### 1.2 版本冲突
```bash
# 检查版本冲突
mvn versions:display-dependency-updates

# 解决版本冲突
mvn versions:use-latest-versions
```

### 2. 配置错误

#### 2.1 数据库连接问题
```yaml
# application-test.yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/test_db
    username: test
    password: test
    driver-class-name: com.mysql.cj.jdbc.Driver
```

#### 2.2 环境变量问题
```bash
# 设置测试环境变量
export SPRING_PROFILES_ACTIVE=test
export MYSQL_DATABASE=test_db
export REDIS_HOST=localhost
```

### 3. 逻辑错误

#### 3.1 业务逻辑错误
- 检查边界条件处理
- 验证异常情况处理
- 确认数据验证逻辑

#### 3.2 测试数据问题
```sql
-- 清理测试数据
DELETE FROM todo WHERE id > 0;

-- 插入测试数据
INSERT INTO todo (title, description, completed) VALUES 
('Test Todo', 'Test Description', false);
```

### 4. 集成错误

#### 4.1 Testcontainers问题
```java
// 确保Testcontainers正确配置
@Testcontainers
class BaseIT {
    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.4")
            .withDatabaseName("test_db")
            .withUsername("test")
            .withPassword("test");
}
```

#### 4.2 服务依赖问题
```java
// 使用@MockBean模拟外部服务
@MockBean
private ExternalService externalService;

@Test
void testWithMockedService() {
    when(externalService.call()).thenReturn("mocked response");
    // 测试逻辑
}
```

### 5. 性能问题

#### 5.1 测试超时
```java
// 设置测试超时
@Test
@Timeout(value = 30, unit = TimeUnit.SECONDS)
void testWithTimeout() {
    // 测试逻辑
}
```

#### 5.2 内存泄漏
```bash
# 使用JVM参数监控内存
mvn test -Dtest="*Test" -Xmx2g -XX:+HeapDumpOnOutOfMemoryError
```

## 测试最佳实践

### 1. 测试编写规范

#### 1.1 命名规范
```java
// 测试类命名：被测试类名 + Test
public class TodoServiceTest {
    
    // 测试方法命名：test + 方法名 + 场景
    @Test
    void testCreateTodo_WhenValidInput_ShouldReturnTodo() {
        // 测试逻辑
    }
    
    @Test
    void testCreateTodo_WhenInvalidInput_ShouldThrowException() {
        // 测试逻辑
    }
}
```

#### 1.2 测试结构
```java
@Test
void testMethod() {
    // Given - 准备测试数据
    Todo todo = new Todo();
    todo.setTitle("Test Todo");
    
    // When - 执行被测试方法
    Todo result = todoService.createTodo(todo);
    
    // Then - 验证结果
    assertThat(result).isNotNull();
    assertThat(result.getTitle()).isEqualTo("Test Todo");
}
```

### 2. 测试数据管理

#### 2.1 测试数据准备
```java
// 使用@Sql注解准备测试数据
@Sql("/data/test-data.sql")
@Test
void testWithTestData() {
    // 测试逻辑
}

// 使用@Transactional回滚测试数据
@Transactional
@Rollback
@Test
void testWithTransactionalData() {
    // 测试逻辑
}
```

#### 2.2 测试数据清理
```java
// 使用@DirtiesContext清理上下文
@DirtiesContext
@Test
void testWithDirtyContext() {
    // 测试逻辑
}
```

### 3. 测试隔离

#### 3.1 单元测试隔离
```java
// 使用@MockBean隔离依赖
@MockBean
private TodoMapper todoMapper;

@Test
void testIsolated() {
    when(todoMapper.insert(any())).thenReturn(1);
    // 测试逻辑
}
```

#### 3.2 集成测试隔离
```java
// 使用Testcontainers隔离环境
@Testcontainers
class IntegrationTest {
    @Container
    static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.4");
    
    @Test
    void testIntegration() {
        // 集成测试逻辑
    }
}
```

## 自动化测试流程

### 1. CI/CD集成

#### 1.1 GitHub Actions配置
```yaml
name: Test
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          java-version: '21'
          distribution: 'temurin'
      - name: Run tests
        run: mvn clean test
      - name: Generate coverage report
        run: mvn jacoco:report
      - name: Upload coverage to Codecov
        uses: codecov/codecov-action@v3
```

#### 1.2 质量门禁
```bash
# 质量门禁检查
mvn clean verify 

# 检查测试覆盖率
mvn jacoco:check

# 检查代码质量
mvn sonar:sonar
```

### 2. 测试报告

#### 2.1 测试结果报告
```bash
# 生成测试报告
mvn surefire-report:report

# 生成覆盖率报告
mvn jacoco:report

# 生成聚合报告
mvn site
```

#### 2.2 测试趋势分析
```bash
# 查看测试历史
mvn test -Dtest="*Test" -DfailIfNoTests=false

# 分析测试性能
mvn test -Dtest="*Test" -Dmaven.test.failure.ignore=true
```

## 故障排除

### 1. 常见错误

#### 1.1 测试失败
```bash
# 查看详细错误信息
mvn test -X

# 查看特定测试的详细输出
mvn test -Dtest="TodoControllerTest" -X
```

#### 1.2 依赖问题
```bash
# 清理本地仓库
mvn dependency:purge-local-repository

# 重新下载依赖
mvn dependency:resolve
```

### 2. 调试技巧

#### 2.1 远程调试
```bash
# 启动远程调试
mvn test -Dmaven.surefire.debug

# 使用IDE连接调试端口
# 默认端口：5005
```

#### 2.2 日志调试
```yaml
# application-test.yaml
logging:
  level:
    com.company.todo: DEBUG
    org.springframework.test: DEBUG
    org.testcontainers: DEBUG
```

## 测试清单

### 执行前检查
- [ ] 依赖服务已启动
- [ ] 测试环境已配置
- [ ] 测试数据已准备
- [ ] 代码已提交到版本控制

### 执行中监控
- [ ] 测试执行进度
- [ ] 失败测试数量
- [ ] 测试执行时间
- [ ] 内存使用情况

### 执行后验证
- [ ] 所有测试通过
- [ ] 覆盖率达标
- [ ] 性能指标正常
- [ ] 无内存泄漏

### 修复后验证
- [ ] 修复的测试通过
- [ ] 相关测试通过
- [ ] 回归测试通过
- [ ] 代码质量检查通过

---

**提示**: 使用此文档作为测试执行和问题修复的标准流程，确保测试质量和代码稳定性。定期运行完整测试套件，及时发现和修复问题。