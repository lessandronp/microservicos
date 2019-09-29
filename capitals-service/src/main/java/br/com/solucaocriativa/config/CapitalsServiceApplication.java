package br.com.solucaocriativa.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = {"br.com.solucaocriativa.config, br.com.solucaocriativa.resource"})
@EnableFeignClients(basePackages = {"br.com.solucaocriativa.proxy"})
@RibbonClient(name="countries-service", configuration = RibbonConfiguration.class)
public class CapitalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapitalsServiceApplication.class, args);
	}

}
