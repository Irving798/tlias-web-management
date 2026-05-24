
# tlias-web-management

黑马程序员JavaWeb课程 - 学员管理系统后端项目

## 项目简介

这是一个基于Spring Boot 3的学员管理系统后端项目，实现了班级管理、学生管理、登录认证、操作日志等功能。

## 技术栈

| 技术 | 版本 |
|------|------|
| Spring Boot | 3.2.10 |
| MyBatis | 3.0.3 |
| MySQL | - |
| JWT | 0.9.1 |
| PageHelper | 1.4.7 |
| Lombok | - |
| 阿里云OSS | 3.17.4 |

## 功能模块

- **班级管理**：班级的增删改查、分页查询
- **学生管理**：学生的增删改查、条件分页查询、违纪处理
- **登录认证**：基于JWT的登录认证
- **操作日志**：AOP切面记录操作日志
- **拦截器/过滤器**：Token验证

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+

### 数据库配置

1. 创建数据库 `tlias`
2. 执行数据库脚本（需自行准备）

### 修改配置

编辑 `src/main/resources/application.yml`，修改数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tlias
    username: root
    password: your_password
```

### 运行项目

```bash
mvn spring-boot:run
```

## API接口

### 班级管理

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/clazzs` | 新增班级 |
| GET | `/clazzs` | 条件分页查询班级 |
| GET | `/clazzs/{id}` | 根据ID查询班级详情 |
| PUT | `/clazzs` | 更新班级信息 |
| DELETE | `/clazzs/{id}` | 删除班级 |
| GET | `/clazzs/list` | 查询全部班级 |

### 学生管理

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/students` | 添加学生 |
| GET | `/students` | 条件分页查询 |
| GET | `/students/{id}` | 根据ID查询学生信息 |
| PUT | `/students` | 修改学生信息 |
| DELETE | `/students/{ids}` | 删除学生（支持批量） |
| PUT | `/students/violation/{id}/{score}` | 违纪处理 |

### 登录

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/login` | 登录 |

## 项目结构

```
src/main/java/com/fly/
├── anno/              # 自定义注解
├── aop/               # AOP切面
├── config/            # 配置类
├── controller/        # 控制器
├── exception/         # 异常处理
├── filter/            # 过滤器
├── interceptor/       # 拦截器
├── mapper/            # MyBatis Mapper
├── pojo/              # 实体类
├── service/           # 业务层
│   └── impl/          # 业务实现类
└── utils/             # 工具类
```

## 学习说明

本项目跟随黑马程序员JavaWeb课程开发，适合学习Spring Boot、MyBatis、JWT、AOP等技术。

## 许可证

仅供学习使用

