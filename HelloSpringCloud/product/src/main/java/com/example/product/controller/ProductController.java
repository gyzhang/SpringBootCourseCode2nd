package com.example.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/product/getProductName")
    public String getProductName(String productId){
        System.out.println("假装很努力的在后台查询商品信息:)");
        return "黄金万两" + productId;
    }
}
