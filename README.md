# Spring Boot components integration

## 简单介绍

此项目存在的目的是用于展示 Spring Boot 多模块开发中整合各类常用组件。

与此同时，本文将以及其简要的文字说明组装的步骤，已完成代码和说明的将会在列表上打勾。

## 计划列表

基础组件

 - [x] JUnit
   - 此组件在包 `spring-boot-starter-test` 中包含了，无需再单独添加。
 - [x] MyBatis
   - 此组件在 `MyBatis Plus` 组件中已存在。
 - [x] MyBatis Plus
   - 整合的方式较为简单：引入包 --> 增加配置类。
   - 详细信息可在模块 `web-system` 中找到。
 - [ ] Spring Data JPA 「计划延后」
 - [ ] MongoDB
 - [x] Druid
   - 引入包后添加配置即可
 - [x] MySQL
   - 加入驱动和配置即可。
 - [x] Swagger
   - 使用 SpringDoc OpenAPI 的方式整合了 Swagger 3 ，在测试模块中包含了使用案例。

缓存

 - [x] Redis
   - 加入驱动和配置即可。
   - 记得写 CacheConfig 和 RedisConfig
 - [ ] Spring Cache
   - 它的核心代码位于 `spring-context` 包下，当引入 Spring Framework 的最基础依赖时，Spring Cache 的依赖也就一并引入了，由于自动装配的原因，Spring Cache 相关的组件没有被注册到 IOC 容器。引入 Spring Cache 的方式是在 IOC 容器中导入 `spring-boot-starter-cache` 依赖。
   - 在操作 Redis 时已经有涉及到相关的操作了。
 - [ ] j2cache

权限 & 加密

 - [ ] Spring Security
 - [ ] JWT
 - [ ] AES 工具类

消息队列

 - [ ] Rabbit MQ
 - [ ] Rocket MQ

定时任务

- [ ] Quartz
- [ ] Xxl-job

监控

- [ ] Actuator
- [ ] Spring Boot Admin
- [x] Arthas
  - 在启动模块的配置文件中标注即可。

Spring 应用

- [ ] 自定义注解
- [ ] AOP 应用