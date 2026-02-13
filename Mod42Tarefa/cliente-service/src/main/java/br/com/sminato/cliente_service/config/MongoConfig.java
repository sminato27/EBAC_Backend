package br.com.sminato.cliente_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.sminato.cliente_service.repository")
public class MongoConfig {
}
