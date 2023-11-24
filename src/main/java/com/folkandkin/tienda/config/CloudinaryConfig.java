package com.folkandkin.tienda.config;

import com.cloudinary.Cloudinary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase de configuración de Cloudinary.
 *
 * @version v1 19 Nov 2023
 * @author Leandro Deferrari
 */

@Configuration
public class CloudinaryConfig {
    @Value("${app.cloudinary.api.key}")
    private String key;

    @Value("${app.cloudinary.api.secret}")
    private String secret;

    @Value("${app.cloudinary.name}")
    private String name;

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", this.name);
        config.put("api_key", this.key);
        config.put("api_secret", this.secret);

        return new Cloudinary(config);
    }
}
