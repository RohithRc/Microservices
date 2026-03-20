package com.microDemo.Accounts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI accountsOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Accounts API")
						.version("v1")
						.description("OpenAPI documentation for the Accounts microservice.")
						.license(new License().name("Apache 2.0")));
	}
}

