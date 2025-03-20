package com.someli.someli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SomeliApplication {
	public static void main(String[] args) {
		// Define o perfil 'dev' por padrão caso nenhum seja informado
		if (System.getenv("SPRING_PROFILES_ACTIVE") == null) {
			System.setProperty("spring.profiles.active", "dev");
		}
		SpringApplication.run(SomeliApplication.class, args);
	}

}
