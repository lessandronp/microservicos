package br.com.solucaocriativa.repository.iface;

import org.springframework.data.repository.Repository;

import br.com.solucaocriativa.entity.Country;

public interface CountryRepository extends Repository<Country,String> {

	Country findById(String id);

}