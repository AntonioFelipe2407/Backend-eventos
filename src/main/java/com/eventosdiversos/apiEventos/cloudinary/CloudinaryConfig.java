package com.eventosdiversos.apiEventos.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CloudinaryConfig {


    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", System.getProperty("CLOUDINARY_CLOUD_NAME"),
                "api_key", System.getProperty("CLOUDINARY_API_KEY"),
                "api_secret", System.getProperty("CLOUDINARY_API_SECRET")));
    }
}
