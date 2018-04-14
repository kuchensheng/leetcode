package com.candy.aku;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @version 1.0
 * @Desription:
 * @ClassName:${TYPE_NAME}
 * @Author:Hui
 * @CreateDate:2018/3/5 22:11
 */
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class Swagger2 {

    @Bean
    public Docket createRestApi(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ssc"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Spring Boot 中使用Swagger2构建RESTful APIs")
                .description("更多spring Boot相关文章请关注：http://blog.dids.html")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .version("1.0")
                .build();
    }

}
