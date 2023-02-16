package com.example.order.feigin;

import org.springframework.stereotype.Component;

@Component
public class MemberClientHystrix implements MemberClient {
    @Override
    public String getMemberName(String memberId) {
        return "哦豁，会员服务.获取" + memberId + "会员名称->出错了。";
    }
}
