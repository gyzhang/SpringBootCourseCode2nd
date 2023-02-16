package com.example.order.feigin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-gateway", fallback = MemberClientHystrix.class)
public interface MemberClient {
    @GetMapping("/member/getMemberName")
    public String getMemberName(@RequestParam(value = "memberId") String memberId);
}
