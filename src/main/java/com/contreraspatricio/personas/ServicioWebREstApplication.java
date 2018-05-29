package com.contreraspatricio.personas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ServicioWebREstApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioWebREstApplication.class, args);
	}
}
