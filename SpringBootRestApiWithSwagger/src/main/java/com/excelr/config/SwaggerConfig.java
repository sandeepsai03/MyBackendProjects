package com.excelr.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("My API")
                .version("1.0")
                .description("API documentation with Swagger and Springdoc"));
    }

    @Bean
    public GroupedOpenApi publicAPI() {
        return GroupedOpenApi.builder()
            .group("public")
            .pathsToMatch("/**")
            .build();
    }
}

