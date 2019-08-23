package com.m2.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service2")
public interface ServiceBClient {
    @RequestMapping("/saveStudentClass")
    public String saveStudentClass();
}
