package br.com.sminato.produto_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.sminato.produto_service.repository")
public class MongoConfig {
}
