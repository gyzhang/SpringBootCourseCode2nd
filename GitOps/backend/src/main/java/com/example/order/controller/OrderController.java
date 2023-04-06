package com.example.order.controller;

import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order/doOrder")
    public String doOrder(@RequestBody OrderDTO orderDTO){
        String memberId = orderDTO.getMemberId();
        String productId = orderDTO.getProductId();
        int amount = orderDTO.getAmount();
        String orderCode = orderService.doOrder(memberId,productId,amount);
        return orderCode;
    }

}
