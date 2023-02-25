package com.example.express.mq;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("kevin"))
public class RabbitMQConsumer {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("第三方快递发货，通过RabbitMQ获取到的订单信息：" + msg);
    }

}
