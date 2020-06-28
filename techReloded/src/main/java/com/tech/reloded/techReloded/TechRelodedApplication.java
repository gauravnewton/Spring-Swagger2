package com.tech.reloded.techReloded;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class TechRelodedApplication.
 */
@SpringBootApplication
@EnableSwagger2
public class TechRelodedApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(TechRelodedApplication.class, args);
	}
	
	/**
	 * Swagger configuration.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket( DocumentationType.SWAGGER_2 )
				.select()
				.paths( PathSelectors.ant( ApplicationConfig.PATH_FILTER ))
				.apis(RequestHandlerSelectors.basePackage( ApplicationConfig.BASE_PACKAGE ))
				.build()
				.apiInfo( apiInfo() );
	}
	
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		
		return new ApiInfo(
				ApplicationConfig.API_INTRO,
				ApplicationConfig.API_DESC,
				ApplicationConfig.API_VERSION,
				ApplicationConfig.LICENCE_TYPE,
				new springfox.documentation.service.Contact( 
							ApplicationConfig.AUTHOR,
							ApplicationConfig.WEBSITE_ADDR,
							ApplicationConfig.CONTACT_MAIL 
						),
				ApplicationConfig.LICENCE_TITLE,
				ApplicationConfig.LICENCE_URL,
				Collections.emptyList());
		
	}

}
