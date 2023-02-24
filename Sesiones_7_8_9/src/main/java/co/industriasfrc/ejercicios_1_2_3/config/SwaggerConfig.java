package co.industriasfrc.ejercicios_1_2_3.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 *
 * HTML: http://localhost:8080/swagger-ui/
 * JSON: http://localhost:8080/v2/api-docs
 */
@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("SpringShopLaptops API")
                .description("Spring shop Laptops sample application")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                .description("SpringShop Laptops Wiki Documentation")
                .url("https://springshop.wiki.github.org/docs"));
    }
         
}
