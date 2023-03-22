package com.example.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 供 K8S 进行容器健康检查
 */
@RestController
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "I'AM FINE.";
    }

}
