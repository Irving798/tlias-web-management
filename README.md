# Tlias Web Management - 学员管理系统

一个基于 Spring Boot 3 + Vue 3 的前后端分离学员管理系统，实现了班级管理、学生管理、员工管理、数据统计等功能。

## 项目简介

本项目是一个完整的企业级学员管理系统，包含前端、后端和数据库初始化脚本。采用前后端分离架构，后端使用 Spring Boot 3 + MyBatis，前端使用 Vue 3 + Element Plus，实现了完整的 CRUD 操作、登录认证、权限控制、数据统计等功能。

## 技术栈

### 后端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 3.2.10 | 后端框架 |
| MyBatis | 3.0.3 | ORM框架 |
| MySQL | 8.0+ | 数据库 |
| JWT | 0.9.1 | 令牌认证 |
| PageHelper | 1.4.7 | 分页插件 |
| Lombok | - | 简化代码 |
| 阿里云OSS | 3.17.4 | 文件存储 |
| AOP | - | 切面编程 |

### 前端技术栈

| 技术 | 版本 | 说明 |
|------|------|------|
| Vue | 3.2.38 | 前端框架 |
| Vue Router | 4.1.5 | 路由管理 |
| Pinia | 2.0.21 | 状态管理 |
| Element Plus | 2.4.4 | UI组件库 |
| Axios | 1.7.2 | HTTP客户端 |
| ECharts | 5.5.1 | 图表库 |
| Vite | 3.0.9 | 构建工具 |

## 功能模块

### 1. 登录认证
- 基于JWT的登录认证
- Token拦截器验证
- 密码加密存储

### 2. 部门管理
- 部门的增删改查
- 部门列表展示

### 3. 员工管理
- 员工信息的增删改查
- 条件分页查询
- 员工照片上传（阿里云OSS）
- 员工工作经历管理

### 4. 班级管理
- 班级信息的增删改查
- 条件分页查询
- 班主任关联

### 5. 学生管理
- 学生信息的增删改查
- 条件分页查询
- 违纪扣分处理
- 批量删除

### 6. 数据统计
- 员工职位统计（饼图）
- 班级人数统计（柱状图）

### 7. 操作日志
- AOP切面自动记录操作日志
- 日志查询功能

## 项目结构

```
tlias-web-management/
├── tlias-backend-springboot3/    # 后端项目
│   ├── src/main/java/com/fly/
│   │   ├── anno/              # 自定义注解
│   │   ├── aop/               # AOP切面（操作日志）
│   │   ├── config/            # 配置类
│   │   ├── controller/        # 控制器
│   │   ├── exception/         # 全局异常处理
│   │   ├── filter/            # 过滤器
│   │   ├── interceptor/       # 拦截器
│   │   ├── mapper/            # MyBatis Mapper
│   │   ├── pojo/              # 实体类
│   │   ├── service/           # 业务层
│   │   └── utils/             # 工具类
│   └── src/main/resources/
│       ├── application.yml    # 配置文件
│       └── com/fly/mapper/    # MyBatis XML映射文件
│
├── vue-tlias-management/          # 前端项目
│   ├── src/
│   │   ├── api/               # API接口
│   │   ├── assets/            # 静态资源
│   │   ├── router/            # 路由配置
│   │   ├── stores/            # Pinia状态管理
│   │   ├── utils/             # 工具函数
│   │   ├── views/             # 页面组件
│   │   ├── App.vue            # 根组件
│   │   └── main.js            # 入口文件
│   └── package.json
│
└── database-initial/              # 数据库初始化
    └── tlias.sql             # 数据库脚本
```

## 快速开始

### 环境要求

- JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Node.js 16+

### 1. 数据库初始化

```bash
# 创建数据库并导入数据
mysql -u root -p < database-initial/tlias.sql
```

或者在MySQL客户端中执行：

```sql
source /path/to/database-initial/tlias.sql
```

默认管理员账号：
- 用户名：`jinyong`
- 密码：`123456`

### 2. 后端启动

1. 修改数据库配置，编辑 `tlias-backend-springboot3/src/main/resources/application.yml`：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/tlias
    username: root
    password: your_password  # 修改为你的密码
```

2. （可选）配置阿里云OSS（用于文件上传）：

```yaml
aliyun:
  oss:
    endpoint: your-endpoint
    bucketName: your-bucket-name
    region: your-region
```

3. 启动后端服务：

```bash
cd tlias-backend-springboot3
mvn spring-boot:run
```

后端服务默认运行在 `http://localhost:8080`

### 3. 前端启动

```bash
cd vue-tlias-management
npm install
npm run dev
```

前端服务默认运行在 `http://localhost:5173`

## API 接口文档

### 登录接口

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/login` | 登录 |

### 部门管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/depts` | 查询全部部门 |
| GET | `/depts/{id}` | 根据ID查询部门 |
| POST | `/depts` | 新增部门 |
| PUT | `/depts` | 修改部门 |
| DELETE | `/depts/{id}` | 删除部门 |

### 员工管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/emps` | 条件分页查询员工 |
| GET | `/emps/{id}` | 根据ID查询员工详情 |
| POST | `/emps` | 新增员工 |
| PUT | `/emps` | 修改员工 |
| DELETE | `/emps/{ids}` | 删除员工（支持批量） |

### 班级管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/clazzs` | 条件分页查询班级 |
| GET | `/clazzs/{id}` | 根据ID查询班级详情 |
| GET | `/clazzs/list` | 查询全部班级 |
| POST | `/clazzs` | 新增班级 |
| PUT | `/clazzs` | 修改班级 |
| DELETE | `/clazzs/{id}` | 删除班级 |

### 学生管理

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/students` | 条件分页查询学生 |
| GET | `/students/{id}` | 根据ID查询学生详情 |
| POST | `/students` | 新增学生 |
| PUT | `/students` | 修改学生 |
| DELETE | `/students/{ids}` | 删除学生（支持批量） |
| PUT | `/students/violation/{id}/{score}` | 违纪扣分 |

### 数据统计

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/report/empJobData` | 员工职位统计 |
| GET | `/report/clazzCountData` | 班级人数统计 |

### 操作日志

| 方法 | 路径 | 描述 |
|------|------|------|
| GET | `/logs` | 分页查询操作日志 |

### 文件上传

| 方法 | 路径 | 描述 |
|------|------|------|
| POST | `/upload` | 上传文件到阿里云OSS |

## 数据库表结构

| 表名 | 说明 |
|------|------|
| dept | 部门表 |
| emp | 员工表 |
| emp_expr | 员工工作经历表 |
| emp_log | 员工操作日志表 |
| clazz | 班级表 |
| student | 学生表 |
| operate_log | 操作日志表 |

## 学习说明

本项目适合学习以下技术点：
- Spring Boot 3 开发
- MyBatis 持久层开发
- Vue 3 + Element Plus 前端开发
- JWT 认证
- AOP 切面编程
- 前后端分离架构
- 分页查询
- 文件上传

## 常见问题

### 1. 后端启动报错 "Access denied for user 'root'@'localhost'"
检查 application.yml 中的数据库用户名和密码是否正确。

### 2. 前端无法连接后端
检查后端是否正常启动，检查 vue-tlias-management/src/utils/request.js 中的 baseURL 是否正确。

### 3. 文件上传功能不可用
需要配置阿里云OSS的 endpoint、bucketName、region 等信息。

## 许可证

本项目仅供学习使用。

## 致谢

- 黑马程序员 JavaWeb 课程
