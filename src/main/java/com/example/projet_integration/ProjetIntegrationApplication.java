package com.example.projet_integration;

import com.example.projet_integration.repository.UserRepository;
import com.example.projet_integration.security.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ProjetIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetIntegrationApplication.class, args);
    }

}
