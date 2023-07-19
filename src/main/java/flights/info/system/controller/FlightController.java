package flights.info.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import flights.info.system.entities.Flight;
import flights.info.system.rest.FlightRepo;

@RestController
public class FlightController {

	@Autowired
	private FlightRepo fRepo;

// 2
	@GetMapping("/Flightpage/{num}")
	public List<Flight> getFlightPage(@PathVariable("num") int num) {
		var result = fRepo.findAll(PageRequest.of(num, 4));
		return result.getContent();
	}

//3
	@GetMapping("/Flightfromcity/{from}/{to}")
	public List<Flight> getFlight(@PathVariable("from") String from, @PathVariable("to") String to) {
		return fRepo.getFlights(from, to);
	}

//6
	@PostMapping("/addNewFlight")
	public Flight addNewFlight(@RequestBody Flight f) {
		fRepo.save(f);
		return f;
	}

}
