package com.ssc.candy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.ssc.candy.mapper")
public class CandyParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyParentApplication.class, args);
	}
}
