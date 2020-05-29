package com.hugo.evoluum;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class TesteEvoluumApplication {

	private static Logger LOG = Logger.getLogger(TesteEvoluumApplication.class.getName());
	
	public static void main(String[] args) {
		LOG.info("... Iniciando API");
		SpringApplication.run(TesteEvoluumApplication.class, args);
		LOG.info("... API iniciada e pronta para receber requisiçoes");
	}

	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.any())
          .paths(PathSelectors.any())
          .build()
          .apiInfo(apiInfo());
    }

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Spring Boot REST API - Evoluum")
	            .description("API Spring Boot criada para o teste seletivo da empresa Evoluum")
	            .version("1.0.0")
	            .contact(new Contact("Hugo Feijó", "https://linkedin.com/in/hugo-feijo/", "hugo.ofeijo@gmail.com"))
	            .build();
	}

}
