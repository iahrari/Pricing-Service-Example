package com.github.iahrari.pricingservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SpringFoxConfig {
    @Bean
    public Docket api() {

        var contact = new Contact("Snapp","snapp-box.com", "info@snapp-box.com");
        var apiInfo = new ApiInfo(
                "Pricing Service",
                "API documentaion",
                "0.0.1",
                null,
                contact,
                "APACHE LICENSE, VERSION 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                Collections.emptyList()
        );

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.github.iahrari.pricingservice"))
                .paths(PathSelectors.any())
                .build();
    }
}