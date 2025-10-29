package com.eventosdiversos.apiEventos;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiEventosApplication {

	public static void main(String[] args) {

        // Carrega as variáveis de ambiente para a aplicação
        Dotenv dotenv = Dotenv.load();
        System.setProperty("CLOUDINARY_CLOUD_NAME", dotenv.get("CLOUDINARY_CLOUD_NAME"));
        System.setProperty("CLOUDINARY_API_KEY", dotenv.get("CLOUDINARY_API_KEY"));
        System.setProperty("CLOUDINARY_API_SECRET", dotenv.get("CLOUDINARY_API_SECRET"));

        SpringApplication.run(ApiEventosApplication.class, args);

	}

}
