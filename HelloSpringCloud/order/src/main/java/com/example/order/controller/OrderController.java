package com.example.order.controller;

import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/order/doOrder")
    public String doOrder(@RequestBody OrderDTO orderDTO) {
        String memberId = orderDTO.getMemberId();
        String productId = orderDTO.getProductId();
        int count = orderDTO.getCount();
        String orderId = orderService.doOrder(memberId, productId, count);
        return "用户下单：" + orderId;
    }
}
