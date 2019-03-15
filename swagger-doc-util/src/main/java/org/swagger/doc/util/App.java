package org.swagger.doc.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(new Class[] { App.class });
	}

	/**
	 * 启动类入口main函数， 执行SpringApplication.run，
	 * 
	 * @param args
	 *            参数
	 */
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
