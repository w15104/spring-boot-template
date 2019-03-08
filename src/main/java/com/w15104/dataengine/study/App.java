package com.w15104.dataengine.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.w15104.dataengine.study.mapper"})
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(new Class[]{App.class});
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
