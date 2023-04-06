package com.example.order.service;

import com.example.order.entity.Member;
import com.example.order.entity.OrderInfo;
import com.example.order.entity.Product;
import com.example.order.mapper.MemberMapper;
import com.example.order.mapper.OrderInfoMapper;
import com.example.order.mapper.ProductMapper;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderInfoMapper orderInfoMapper;

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

        return orderInfo.getOrderCode();
    }
}
