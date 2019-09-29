package br.com.solucaocriativa.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.solucaocriativa.entity.Country;
import br.com.solucaocriativa.repository.iface.CountryRepository;

@Repository
public class CountryRepositoryImpl implements CountryRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Country findById(String id) {
		return em.find(Country.class, id);
	}

}
