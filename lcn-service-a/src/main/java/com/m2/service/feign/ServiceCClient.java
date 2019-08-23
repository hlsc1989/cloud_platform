package com.m2.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service3")
public interface ServiceCClient {
    @RequestMapping("/saveTeacher")
    public String saveTeacher();
}
