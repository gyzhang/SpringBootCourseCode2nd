package com.example.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/member/getMemberName")
    public String getMemberName(String memberId){
        System.out.println("假装很努力的在后台查询用户信息:)");
        return "会员张三" + memberId;
    }
}
