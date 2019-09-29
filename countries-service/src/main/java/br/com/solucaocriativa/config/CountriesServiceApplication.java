package br.com.solucaocriativa.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan (basePackages = {"br.com.solucaocriativa.config, br.com.solucaocriativa.resource, br.com.solucaocriativa.service"})
@EntityScan("br.com.solucaocriativa.entity")
@EnableJpaRepositories("br.com.solucaocriativa.repository")
public class CountriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesServiceApplication.class, args);
	}

}
