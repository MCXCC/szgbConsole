package org.example.clztoolsconsole.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
@EnableOpenApi
public class Swagger3Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30).select().apis(RequestHandlerSelectors.basePackage("org.example.clztoolsconsole")).paths(PathSelectors.any()).build().apiInfo(apiInfo()).enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("接口文档", "", "alpha", "", null, "tools", "", Collections.emptyList());
    }
}
