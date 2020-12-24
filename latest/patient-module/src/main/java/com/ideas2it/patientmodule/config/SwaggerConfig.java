package com.ideas2it.patientmodule.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("patient-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
	}

	private com.google.common.base.Predicate<String> postPaths() {
		return or(regex("/patient.*"), regex("/patient.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Patient API")
				.description("Patient Informatiom")
				.termsOfServiceUrl("http://ideas2it.com")
				.contact("ideas2it@gmail.com").license("ideas2it License")
				.licenseUrl("ideas2it@gmail.com").version("1.0").build();
	}

}