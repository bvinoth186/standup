package com.standup.swagger;


import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Provides metadata about the API. The metadata may be used by the clients if needed, and may be presented in
 * editing or documentation generation tools for convenience.
 * 
 * @author balaramv
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    @Bean
    public Docket api()
    {

        return new Docket(DocumentationType.SWAGGER_2).select()

                .apis(RequestHandlerSelectors.basePackage("com.standup.controller"))
                .paths(PathSelectors.any()).build().apiInfo(apiInfo())
                .enable(true);
    }

    private ApiInfo apiInfo()
    {

        return new ApiInfo("Standup  API", "Manages daily standup updates", "1.0.0", "",
                new Contact("Vinoth", "", "vinoth186@gmail.com"), "Apache License", "",
                new ArrayList<VendorExtension>());
    }

}