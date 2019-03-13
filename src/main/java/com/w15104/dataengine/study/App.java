package com.w15104.dataengine.study;

import com.w15104.dataengine.study.basic.util.ContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/*
 *
 * @Description Spring boot启动类
 *
 * @author w15104
 * @data: 2019-3-5
 *
 * @modified by:
 * @modified date:
 * @modified no:
 */
@SpringBootApplication
@ServletComponentScan
@MapperScan({"com.w15104.dataengine.study.mapper"})
public class App extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(new Class[]{App.class});
    }

    /**
     * 启动类入口main函数， 执行SpringApplication.run，并将ApplicationContext注入到ContextUtil中
     * @param args 参数
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(App.class, args);
        ContextUtil.setSpringContext(applicationContext);
    }
}
