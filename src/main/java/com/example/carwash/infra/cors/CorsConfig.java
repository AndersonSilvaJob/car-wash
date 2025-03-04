package com.example.carwash.infra.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Porta do frontend Angular
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS") // Inclua OPTIONS
                .allowedHeaders("Authorization", "Content-Type") // Permita headers necessários
                .allowCredentials(true); // Permite envio de cookies/token
    }
}
