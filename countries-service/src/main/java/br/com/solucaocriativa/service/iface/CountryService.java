package br.com.solucaocriativa.service.iface;

import br.com.solucaocriativa.entity.Country;

public interface CountryService {
	
	Country findById(String id);
	int getPort();
}
