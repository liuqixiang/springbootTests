package com.biandan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).groupName("用户组")
				.apiInfo(new ApiInfoBuilder().contact(new Contact("liuqixiang", "", "ssss@163.com")).build()).select()
				.paths(PathSelectors.regex("/user.*")).build();

		return docket;
	}
}
