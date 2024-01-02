package com.example.notes.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/notes")
                .allowedOrigins("https://toddo.co")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);

        registry.addMapping("/api/users/login")
                .allowedOrigins("https://toddo.co")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);

                registry.addMapping("/api/users/register")
                .allowedOrigins("https://toddo.co")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);

        registry.addMapping("/api/users/paw/{userId}")
                .allowedOrigins("https://toddo.co")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true);
    }
}
