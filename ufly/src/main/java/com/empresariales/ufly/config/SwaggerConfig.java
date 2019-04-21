package com.empresariales.ufly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig
{
	//localhost:8080/swagger-ui.html
	@Bean
	public Docket productApi()
	{
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.empresariales.ufly.controllers"))
				.paths(regex("/rest.*")).build().apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() 
	{
		ApiInfo apiInfo = new ApiInfo(
				"Documentación UFly", 
				"UFly, hacemos lo que se puede", 
				"1.0", 
				"Terms of Service", 
				new Contact("No me acuerdo", "", ""),
				"Apache License Version 2.0",
				"https://apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}


}
