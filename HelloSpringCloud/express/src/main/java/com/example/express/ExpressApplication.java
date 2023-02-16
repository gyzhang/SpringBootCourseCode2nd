package com.example.express;

import com.example.express.mq.RocketMQProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExpressApplication {

	@Autowired
	RocketMQProducer rocketMQProducer;
	public static void main(String[] args) {
		SpringApplication.run(ExpressApplication.class, args);
	}

	@GetMapping("/express/sayHello")
	public String sayHello(){
		String hello = "Say Hello: from EXPRESS.";
		rocketMQProducer.sendMessage(hello);
		return hello;
	}

}
