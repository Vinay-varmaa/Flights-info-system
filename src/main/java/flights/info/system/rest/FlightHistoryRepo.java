package flights.info.system.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flights.info.system.entities.FlightHistory;
import flights.info.system.entities.FlightKey;
import jakarta.transaction.Transactional;

@Transactional
public interface FlightHistoryRepo extends JpaRepository<FlightHistory, FlightKey> {

	@Query(value = "SELECT fh.* from flights f join flight_history fh on f.flightno=fh.flightno where DATEDIFF(MINUTE,f.arrival_time,fh.arrival_time)>=:min", nativeQuery = true)
	List<FlightHistory> getDelayedFlights(@Param("min") int min);

	FlightHistory findByKeyfh_FlightnoAndKeyfh_Depdate(String no,String ddate);

	int deleteByKeyfh_FlightnoAndKeyfh_Depdate(String no,String ddate);
}
