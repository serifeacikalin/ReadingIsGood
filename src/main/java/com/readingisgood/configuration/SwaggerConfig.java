package com.readingisgood.configuration;

import com.readingisgood.constant.ApiDoc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket booksApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(ApiDoc.BOOKS_API_NAME)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.readingisgood"))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(getBooksApiInfo())
                .ignoredParameterTypes(RequestHandler.class);
    }

    private ApiInfo getBooksApiInfo() {
       return new ApiInfoBuilder()
               .title(ApiDoc.BOOKS_API_NAME)
               .version("1.0.0")
               .description(ApiDoc.BOOKS_API_NAME)
               .contact(new Contact("ReadIsGood Projesi", "help.readIsGood.com","iletisim@books.com.tr"))
               .license("ReadIsGood Licence")
               .build();
    }
}
