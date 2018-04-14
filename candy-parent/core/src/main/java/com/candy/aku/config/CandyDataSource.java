package com.candy.aku.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @Desription:
 * @Author:Hui
 * @CreateDate:2018/3/31 1:21
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class CandyDataSource extends DruidDataSource {

}
