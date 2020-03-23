package com.mxdl.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.ArrayList;
import java.util.List;


/**
 * Description: <><br>
 * Author:    mxdl<br>
 * Date:      2020/3/18<br>
 * Version:    V1.0.0<br>
 * Update:     <br>
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
                .description("Authorization Bearer token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build());
        return params;
    }


    @Bean
    public Docket sysApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mxdl"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(parameter());
                //.securitySchemes(newArrayList(oauth()))
               // .securityContexts(newArrayList(securityContext()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("flytour api ")
                .description("flytour 微服务")
                .termsOfServiceUrl("")
                .contact("mxdl")
                .version("1.0")
                .build();
    }

}
