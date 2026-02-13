package br.com.sminato.cliente_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-version}") String appVersion) {
        return new OpenAPI()
                .info(new Info()
                        .title("Serviço de clientes")
                        .version(appVersion)
                        .description("Serviço para gerenciamento de clientes")
                        .contact(new Contact()
                                .name("Minato Sahashi")
                                .email("minato@minato.com")));
    }
}
