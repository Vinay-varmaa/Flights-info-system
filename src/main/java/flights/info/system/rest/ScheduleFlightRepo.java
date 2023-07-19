package flights.info.system.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flights.info.system.entities.FlightKey;
import flights.info.system.entities.ScheduledFlight;
import jakarta.transaction.Transactional;

@Transactional
public interface ScheduleFlightRepo extends JpaRepository<ScheduledFlight, FlightKey> {

//10	
	@Query("Select sf.flightno_sf.No from ScheduledFlight sf where sf.keysf.depdate = :date and sf.fromcity_sf.code= :city")
	List<String> getScheduleFlight(@Param("date") String date, @Param("city") String city);

//7
	@Modifying
	@Query(" delete from ScheduledFlight sf where sf.keysf.depdate Between :ddate and :sdate")
	int deleteByDate(@Param("ddate") String ddate, @Param("sdate") String sdate);

}
