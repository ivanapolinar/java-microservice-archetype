package com.miempresa.servicio.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI microserviceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Servicio Arquetipo API")
                        .description("API base para nuevos microservicios")
                        .version("v1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación adicional")
                        .url("https://miempresa.com/docs"));
    }
}
