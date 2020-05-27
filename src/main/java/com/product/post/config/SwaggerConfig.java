/**
 * 
 */
package com.product.post.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger Document Configuration.
 * 
 * @author yuvaraj
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket categoryApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Category").select()
				.apis(RequestHandlerSelectors.basePackage("com.product.post.controller")).paths(regex("/category.*"))
				.build().apiInfo(metaData());
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Product").select()
				.apis(RequestHandlerSelectors.basePackage("com.product.post.controller")).paths(regex("/product.*"))
				.build().apiInfo(metaData());
	}

	/*
	 * About author and details.
	 */
	private ApiInfo metaData() {
		return new ApiInfo("Spring Boot REST API MicroServices", "Product Service - MicroService", "1.0",
				"Terms of service", new Contact("Yuvaraj V", "https://github.com/yuvarajv10/", "yuvarajv10@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");

	}
}
