# Quick Start

## 1. 先决条件

本示例在 Windows 版的 Docker Desktop 4.17.1 (101757) 上构建并测试通过，原则上在 Linux/MacOS 上应该也能使用。

提供的 K8S 部署脚本在 Docker Desktop 中启用的 Kubernetes v1.25.4 上测试通过。

## 2. 用 Compose 部署应用

在 `quickstart` 目录下双击 `compose-deploy.bat` 运行 Docker Compose 部署应用。

### 2.1 访问前端应用

打开 Chrome 访问 [http://localhost:30080/](http://localhost:30080/)，点击提交按钮，观察返回数据。

### 2.2 检查数据库数据

在 Docker Desktop 中，访问 test-mysql 容器的终端，使用 mysql 登录命令行，检查“订单表”中的数据。

```sql
select * from hellodockerk8s.order_info;
```

### 2.3 检查消息接收情况

在 Docker Desktop 中，访问 test-express 容器的日志，查看是否能正确接收到 RabbitMQ 的消息。

```
2023-02-25 16:17:08 2023-02-25T08:17:08.996Z  INFO 1 --- [ntContainer#0-4] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#438bad7c:7/SimpleConnection@244b0ea5 [delegate=amqp://guest@172.29.0.2:5672/, localPort=56350]
2023-02-25 16:18:15 第三方快递发货，通过RabbitMQ获取到的订单信息：订单已生成：ORDER-29d73146-fec7-47c1-b048-a88773dbf0af
```

### 2.4 检查 Redis 数据

在 Docker Desktop 中，访问 test-redis 容器的终端，使用 redis-cli 登录命令行，输入命令 `get product_count` 检查 Redis 中的数据值。

### 2.5 用 Compose 删除部署的应用

在 `quickstart` 目录下双击 `compose-undeploy.bat` 删除 Docker Compose 部署的应用。

## 3. 用 K8S 部署应用 

在 `quickstart` 目录下双击 `k8s-deploy.bat` 将应用部署到 K8S 上。

### 3.1 访问前端应用

打开 Chrome 访问 [http://localhost:30080/](http://localhost:30080/)，点击提交按钮，观察返回数据。

### 3.2 从 K8S 上删除应用

在 `quickstart` 目录下双击 `k8s-undeploy.bat` 删除部署在 K8S 上的应用。
