package com.example.order.feigin;

import org.springframework.stereotype.Component;

@Component
public class ProductClientHystrix implements ProductClient {
    @Override
    public String getProductName(String productId) {
        return "哦豁，商品服务.获取" + productId + "商品名称->出错了。";
    }
}
