package com.m2;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan("com.m2.dao")
@EnableDiscoveryClient
@EnableFeignClients
@EnableDistributedTransaction
public class LcnServiceAApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(LcnServiceAApplication.class, args);
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("===========>" + dataSource);
    }
}
