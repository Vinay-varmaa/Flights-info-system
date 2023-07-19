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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import flights.info.system.entities.City;
import flights.info.system.entities.Flight;
import flights.info.system.entities.FlightHistory;
import flights.info.system.entities.FlightKey;
import flights.info.system.entities.ScheduledFlight;
import flights.info.system.rest.FlightHistoryRepo;
import flights.info.system.rest.FlightRepo;

@RestController
public class FlightHistoryController {

	@Autowired
	private FlightHistoryRepo flighthistoryRepo;

	@Autowired
	private FlightRepo flightrep;

//4
	@GetMapping("/FlightHistory/{num}")
	public List<FlightHistory> getFlightHistory(@PathVariable("num") String num) {
		return flightrep.findById(num).get().getFlightno_fh();
	}

	@GetMapping("/delayedFlightHistory")
	public List<FlightHistory> delayedFlights(@RequestParam("min") int min) {
		return flighthistoryRepo.getDelayedFlights(min);
	}

//additional
	@PostMapping("/addHistory")
	public FlightHistory addNewFlighthistory(@RequestBody FlightHistory fh) {
		flighthistoryRepo.save(fh);
		return fh;
	}

	@PutMapping("/FlightHistory/{no}/{ddate}/{remark}")
	public FlightHistory updateFlightHistory(@PathVariable("no") String no, @PathVariable("ddate") String ddate,
			@PathVariable("remark") String remark) {
		if (no.length() == 0)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid no");

		FlightHistory fhistory = flighthistoryRepo.findByKeyfh_FlightnoAndKeyfh_Depdate(no, ddate);

		if (fhistory == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "code Not Found");

		} else {
			fhistory.setRemarks_fh(remark);

			flighthistoryRepo.save(fhistory);
			return fhistory;
		}
	}

	@DeleteMapping("/flight/{no}/{ddate}")
	public int deleteFlightHistory(@PathVariable("no") String no, @PathVariable("ddate") String ddate) {
		return flighthistoryRepo.deleteByKeyfh_FlightnoAndKeyfh_Depdate(no, ddate);

	}

}
