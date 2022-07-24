package com.swagger.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration//托管spring
@EnableSwagger2//开启swagger功能
public class SwaggerConfig {


    @Bean
    public Docket createA(){
        //版本类型是swagger2
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket createB(){
        //版本类型是swagger2
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket createC(){
        //版本类型是swagger2
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }


    @Bean
    public Docket createRestApi(){
        //版本类型是swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                //通过调用自定义方法apiInfo，获得文档的主要信息
                .apiInfo(apiInfo())
                .groupName("赵东阳")
                .select()
                //配置要扫描接口的方式
                .apis(RequestHandlerSelectors.basePackage("com.swagger.swagger.controller"))
                //过滤路径
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {

        //作者信息
        Contact contact = new Contact("赵东阳", "https://cn.bing.com/?FORM=BEHPTB", "z15234796855@163.com");

        return new ApiInfo(
                "Api Documentation",
                "Api Documentation",
                "1.0",
                "https://mp.weixin.qq.com/s/0-c0MAgtyOeKx6qzmdUG0w",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
