package com.w15104.dataengine.study;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;

@Configuration
@EnableSwagger2
public class Swagger2 {

	/**
	 * 创建restapi描述
	 * @return
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.w15104.dataengine.study.controller")) // 需要生成api的包路径
				.paths(PathSelectors.any())
				.build();
	}
	
	/**
	 * 接口描述
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("标题")
				.description("描述")
				// .termsOfServiceUrl("test") 服务条款
				// .contact("test") 联系信息
				.version("1.1") 
				.build();
	}
}
