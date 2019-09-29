package br.com.solucaocriativa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import br.com.solucaocriativa.entity.Country;
import br.com.solucaocriativa.repository.iface.CountryRepository;
import br.com.solucaocriativa.service.iface.CountryService;


@Service
public class CountryServiceImpl implements CountryService {
	
	private CountryRepository countryRepository;
	
	private Environment environment;
	
	@Autowired
	public CountryServiceImpl(CountryRepository countryRepository, Environment environment) {
		this.countryRepository = countryRepository;
		this.environment = environment;
	}
	
	public Country findById(String id) {
		return countryRepository.findById(id);
	}
	
	public int getPort() {
		int port = Integer.parseInt(environment.getProperty("local.server.port"));
		return port;
	}
}
