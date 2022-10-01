package com.readingisgood.configuration;

import com.readingisgood.constant.ApiDoc;
import com.readingisgood.infra.InboundService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;
import springfox.documentation.builders.ApiInfoBuilder;
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
                .apis(RequestHandlerSelectors.withMethodAnnotation(InboundService.class))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(getBooksApiInfo())
                .ignoredParameterTypes(RequestHeader.class);
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
