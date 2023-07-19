package flights.info.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import flights.info.system.entities.FlightKey;
import flights.info.system.entities.ScheduledFlight;
import flights.info.system.rest.FlightRepo;
import flights.info.system.rest.ScheduleFlightRepo;

@RestController
public class ScheduledFlightController {

	@Autowired
	private ScheduleFlightRepo scheduledRepo;

	@Autowired
	FlightRepo flightrepo;

//5	
	@PostMapping("/addScheduledFlight")
	public ScheduledFlight addScheduledFlight(@RequestParam("flightno") String flightno,
			@RequestParam("depdate") String depdate, @RequestParam("arrdate") String arrdate) {
		var flight = flightrepo.findById(flightno).get();
		FlightKey cp = new FlightKey();
		cp.setFlightno(flightno);
		cp.setDepdate(depdate);
		ScheduledFlight sf = new ScheduledFlight();
		sf.setArrdate_sf(arrdate);
		sf.setArrtime_sf(flight.getArr_time());
		sf.setDeptime_sf(flight.getDep_time());
		sf.setFromcity_sf(flight.getFromcity_flight());
		sf.setTocity_sf(flight.getTocity_flight());
		sf.setMins_sf(flight.getDur_min());
		sf.setKeysf(cp);
		scheduledRepo.save(sf);
		return sf;
	}

	@DeleteMapping("/deleteFlight")
	public int deleteFlightByDate(@RequestParam("ddate") String ddate, @RequestParam("sdate") String sdate) {
		return scheduledRepo.deleteByDate(ddate, sdate);
	}

	@GetMapping("/flightScheduled")
	public List<String> getScheduledFlight(@RequestParam("date") String date, @RequestParam("city") String city) {
		return scheduledRepo.getScheduleFlight(date, city);
	}

}
