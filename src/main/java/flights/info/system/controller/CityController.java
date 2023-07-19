package flights.info.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import flights.info.system.entities.City;
import flights.info.system.rest.CityRepo;

@RestController
public class CityController {

	@Autowired
	private CityRepo cRepo;

//1
	@GetMapping("/CityNames")
	public List<String> getcityNames() {
		return cRepo.getCities();
	}

	@GetMapping("/cities")
	public List<City> getCity() {
		return cRepo.findAll();
	}

//9 
	@PostMapping("/addCities")
	public City addCity(@RequestBody City cities) {
		try {
			cRepo.save(cities);
			return cities;
		} catch (Exception ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid data!");
		}
	}

	@DeleteMapping("/city/{code}")
	public void deleteCategoryByCode(@PathVariable("code") String code) {
		var city = cRepo.findById(code);
		if (city.isPresent())
			cRepo.deleteById(code);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Code Not Found");
	}

	@PutMapping("/city/{code}/{name}")
	public City updateCities(@PathVariable("code") String code, @PathVariable("name") String name) {
		if (name.length() == 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid name");

		var city = cRepo.findById(code);
		if (city.isPresent()) {
			var c = city.get();
			c.setName("visakha");
			cRepo.save(c);
			return c;
		} else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "code Not Found");
	}

}
