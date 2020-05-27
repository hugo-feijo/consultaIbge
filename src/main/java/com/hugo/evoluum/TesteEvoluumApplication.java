package com.hugo.evoluum;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteEvoluumApplication {

	private static Logger LOG = Logger.getLogger(TesteEvoluumApplication.class.getName());
	
	public static void main(String[] args) {
		LOG.info("Iniciando API");
		SpringApplication.run(TesteEvoluumApplication.class, args);
		LOG.info("API iniciada e pronta para receber requisiçoes");
	}

}
