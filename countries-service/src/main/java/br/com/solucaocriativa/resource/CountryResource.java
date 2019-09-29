package br.com.solucaocriativa.resource;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.solucaocriativa.entity.Country;
import br.com.solucaocriativa.exception.NotFoundException;
import br.com.solucaocriativa.service.iface.CountryService;

@RestController
public class CountryResource {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CountryService countryService;

	HashMap<Integer, Integer> timePort = new HashMap<>();

	@GetMapping("/{country}")
	public Country getCountry(@PathVariable String country) {
		Country countryEntity = countryService.findById(country);
		if (countryEntity != null) {
			countryEntity.setPort(countryService.getPort());
			int time = timePort.getOrDefault(countryEntity.getPort(), 0);
			if (time >= 0) {
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					logger.error(e.getMessage());
				}
			}
			return countryEntity;
		}
		throw new NotFoundException("Country: " + country + " not found");
	}

	@GetMapping("/time/{time}")
	public int getTime(@PathVariable int time) {
		timePort.put(countryService.getPort(), time);
		return time;
	}

}
