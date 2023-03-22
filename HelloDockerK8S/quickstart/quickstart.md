# Quick Start

## 先决条件

本示例依托 Docker Desktop 在 Windows 10 上构建并测试通过，原则上在 Linux/MacOS 上应该也能使用。

## 运行 Docker Compose

在 `quickstart` 目录下 运行 Docker Compose：

```powershell
PS C:\...\quickstart> docker compose up -d
[+] Running 7/7
 - Network quickstart_default  Created        0.0s
 - Container test-redis        Started        1.1s
 - Container test-rabbitmq     Started        0.9s
 - Container test-mysql        Healthy        41.7s
 - Container test-express      Started        1.5s
 - Container test-order        Started        42.1s
 - Container test-console      Started        42.7s
```

## 访问前端应用

打开 Chrome 访问 [http://localhost:30080/](http://localhost:30080/)，点击提交按钮，观察返回数据。

## 检查数据库数据

在 Docker Desktop 中，访问 test-mysql 容器的终端，使用 mysql 登录命令行，检查“订单表”中的数据。

```sql
select * from hellodockerk8s.order_info;
```

## 检查消息接收情况

在 Docker Desktop 中，访问 test-express 容器的日志，查看是否能正确接收到 RabbitMQ 的消息。

```
2023-02-25 16:17:08 2023-02-25T08:17:08.996Z  INFO 1 --- [ntContainer#0-4] o.s.a.r.c.CachingConnectionFactory       : Created new connection: rabbitConnectionFactory#438bad7c:7/SimpleConnection@244b0ea5 [delegate=amqp://guest@172.29.0.2:5672/, localPort=56350]
2023-02-25 16:18:15 第三方快递发货，通过RabbitMQ获取到的订单信息：订单已生成：ORDER-29d73146-fec7-47c1-b048-a88773dbf0af
```

## 检查 Redis 数据

在 Docker Desktop 中，访问 test-redis 容器的终端，使用 redis-cli 登录命令行，输入命令 `get product_count` 检查 Redis 中的数据值。
