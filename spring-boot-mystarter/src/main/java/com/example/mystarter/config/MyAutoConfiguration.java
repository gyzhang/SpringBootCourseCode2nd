package com.example.mystarter.config;

import com.example.mystarter.service.MyService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(MyService.class)
public class MyAutoConfiguration {
    @Bean
    public MyService createMyService(){
        return new MyService();
    }

}
