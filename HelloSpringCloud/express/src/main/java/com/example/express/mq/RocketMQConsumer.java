package com.example.express.mq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "my-consumer_test-topic", topic = "test-topic")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("订单商品已发货，请注意查收：" + message);
    }

}
