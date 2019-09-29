package br.com.solucaocriativa.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.solucaocriativa.entity.Capital;

@FeignClient(name = "countries-service")
public interface CapitalServiceProxy {
	
	@GetMapping("/{country}")
	public Capital getCountry(@PathVariable("country") String country);
}
