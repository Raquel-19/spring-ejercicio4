package com.example.springejercicio4.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

public class SwaggerConfig {

    @Bean
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springejercicio4"))
                .build().apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo("AWESOME API",
                "description",
                "1.0",
                "",
                new Contact("Raquel", "", ""),
                "",
                "",
                Collections.emptyList());
    }
}
