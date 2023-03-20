package com.pmu.coursesmanager.common;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    private final String apiVersion="V1.0.0";
    private final String apiTitle="Courses Manager API";
    private final String apiDescription="API for courses management";
    private final String apiTermsOfService="";
    private final String apiLicense="";
    private final String apiLicenseUrl="";
    private final String apiExternalDocDesc="";
    private final String apiExternalDocUrl="";
    private final String apiContactName="";
    private final String apiContactUrl="";
    private final String apiContactEmail="";


    @Bean
    public OpenAPI getOpenApiDocumentation() {
        return new OpenAPI()
                .info(new Info().title(apiTitle)
                        .description(apiDescription)
                        .version(apiVersion)
                        .contact(new Contact()
                                .name(apiContactName)
                                .url(apiContactUrl)
                                .email(apiContactEmail))
                        .termsOfService(apiTermsOfService)
                        .license(new License()
                                .name(apiLicense)
                                .url(apiLicenseUrl)))
                .externalDocs(new ExternalDocumentation()
                        .description(apiExternalDocDesc)
                        .url(apiExternalDocUrl));
    }
}