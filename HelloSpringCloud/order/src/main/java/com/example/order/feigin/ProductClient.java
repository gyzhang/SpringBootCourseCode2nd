package com.example.order.feigin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-gateway", fallback = ProductClientHystrix.class)
public interface ProductClient {
    @GetMapping("/product/getProductName")
    public String getProductName(@RequestParam(value = "productId") String productId);
}
