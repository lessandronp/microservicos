package br.com.solucaocriativa.resource;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.solucaocriativa.entity.Capital;
import br.com.solucaocriativa.proxy.CapitalServiceProxy;
import br.com.solucaocriativa.proxy.CapitalServiceProxySimple;

@RestController
public class CapitalResource {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CapitalServiceProxy proxy;
	
	@Autowired
	private CapitalServiceProxySimple simpleProxy;
	
	HashMap<Integer, Integer> htPuerto=new HashMap<>();	
	
	@GetMapping("/{country}")
	public Capital getCountry(@PathVariable String country) {
		Capital response = proxy.getCountry(country);
		htPuerto.put(response.getPort(), htPuerto.getOrDefault(response.getPort(),0)+1);
		logger.info("CapitalesService -> {} ",response);
		return response;
	}
	
	@GetMapping("/puertos")
	public String getCountryUsingFeign() {
		StringBuffer response=new StringBuffer();
		htPuerto.forEach((k,v) -> response.append(" Puerto: "+k+" Valor: "+v));
		return response.toString();
	}
	
	@GetMapping("/template/{country}")
	public Capital getCountryUsingRestTemplate(@PathVariable String country) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("country", country);		
		
		ResponseEntity<Capital> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/{country}", 
				Capital.class, 
				uriVariables );
		
		Capital response = responseEntity.getBody();
		
		return response;
	}
	
	@GetMapping("/feign/{country}")
	public Capital getCountryUsingFeign(@PathVariable String country) {
		Capital response = simpleProxy.getCountry(country);		
		return response;
	}

}
