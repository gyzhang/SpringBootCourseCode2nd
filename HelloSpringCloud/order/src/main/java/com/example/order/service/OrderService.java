package com.example.order.service;

import com.example.order.feigin.MemberClient;
import com.example.order.feigin.ProductClient;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private RocketMQTemplate mqTemplate;
    @Qualifier("com.example.order.feigin.MemberClient")
    @Autowired
    private MemberClient memberClient;
    @Qualifier("com.example.order.feigin.ProductClient")
    @Autowired
    private ProductClient productClient;

    public String doOrder(String memberId, String productId, int count) {
        String orderId = UUID.randomUUID().toString();
        String memberName = memberClient.getMemberName(memberId);//Feign 访问会员服务，获取会员名称
        String productName = productClient.getProductName(productId);//Feign 访问商品服务，获取商品名称
        //访问 Redis，扣减库存
        String stockCount = redisTemplate.opsForValue().get("product_count");
        if (stockCount == null) {
            stockCount = "99999";//出于技术演示目的，Redis中没有库存数量时，置为99999，没有任何业务含义
        }
        redisTemplate.opsForValue().set("product_count", String.valueOf((Integer.valueOf(stockCount) - count)));
        //生成订单，并向 RocketMQ 发送订单消息
        mqTemplate.convertAndSend("test-topic", "订单信息：会员=" + memberName + ",商品" + productName + ",数量" + count);
        return "订单已生成，订单号=" + orderId;
    }
}
