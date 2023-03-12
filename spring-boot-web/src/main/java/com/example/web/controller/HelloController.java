package com.example.web.controller;

import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HelloController {

    @GetMapping("/sayHello")
    @ResponseBody
    public String sayHello(String who) {
        //模拟调用Service方法（假装做了很复杂的业务逻辑计算，并访问了数据库），返回问候语sayHelloFromService
        String sayHelloFromService = "问候! Hello ";
        String sayHello = sayHelloFromService + who + ".";
        return sayHello;
    }

    @GetMapping("/")
    public String welcome(){
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(String name, MultipartFile file) throws IOException {
        System.out.println("上传的用户名为:" + name);
        System.out.println("文件的原始名称为:" + file.getOriginalFilename());
        System.out.println("上传文件的类型为:" + file.getContentType());

        String basePath = "D:/temp";
        File localPath = new File(basePath + "/upload/");
        if (!localPath.exists()) {
            localPath.mkdir();
        }
        File localFile = new File(localPath.getPath() + File.separator + file.getOriginalFilename());
        file.transferTo(localFile);

        return "GOOD JOB! 文件上传成功。";
    }

}
