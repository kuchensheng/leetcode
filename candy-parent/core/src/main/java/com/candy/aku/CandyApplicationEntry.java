package com.candy.aku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @version 1.0
 * @Desription:启动函数
 * @Author:Hui
 * @CreateDate:2018/3/27 23:05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = {"com.candy.aku"})
public class CandyApplicationEntry {
    public static void main(String[] args) {
        SpringApplication.run(CandyApplicationEntry.class,args);
    }
}
