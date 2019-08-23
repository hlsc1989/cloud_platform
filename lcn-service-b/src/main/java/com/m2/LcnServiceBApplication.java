package com.m2;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.m2.dao")
@EnableDiscoveryClient
@EnableDistributedTransaction
public class LcnServiceBApplication {

    public static void main(String[] args) {
        SpringApplication.run(LcnServiceBApplication.class, args);
    }

}
