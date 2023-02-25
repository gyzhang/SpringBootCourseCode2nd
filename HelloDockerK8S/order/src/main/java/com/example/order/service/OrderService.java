package com.example.order.service;

import com.example.order.entity.Member;
import com.example.order.entity.OrderInfo;
import com.example.order.entity.Product;
import com.example.order.mapper.MemberMapper;
import com.example.order.mapper.OrderInfoMapper;
import com.example.order.mapper.ProductMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    AmqpTemplate amqpTemplate;


    public String doOrder(String memberId, String productId, int amount) {
        String orderId = UUID.randomUUID().toString();
        Member member = memberMapper.selectByPrimaryKey(memberId);
        Product product = productMapper.selectByPrimaryKey(productId);

        OrderInfo orderInfo = new OrderInfo();

        orderInfo.setId(orderId);
        orderInfo.setOrderCode("ORDER-" + orderId);
        orderInfo.setMemberId(member.getId());
        orderInfo.setMemberName(member.getMemberName());
        orderInfo.setProductId(product.getId());
        orderInfo.setProductName(product.getProductName());
        orderInfo.setOrderAmount(amount);

        orderInfoMapper.insert(orderInfo);

        //访问 Redis，扣减库存
        String stockCount = redisTemplate.opsForValue().get("product_count");
        if (stockCount == null) {
            stockCount = "99999";//出于技术演示目的，Redis中没有库存数量时，置为99999，没有任何业务含义
        }
        redisTemplate.opsForValue().set("product_count", String.valueOf((Integer.valueOf(stockCount) - amount)));

        //向 RabbitMQ发送消息
        amqpTemplate.convertAndSend("kevin", "订单已生成：" + orderInfo.getOrderCode());

        return orderInfo.getOrderCode();
    }
}
