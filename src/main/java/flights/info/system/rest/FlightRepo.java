package flights.info.system.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flights.info.system.entities.Flight;

public interface FlightRepo extends JpaRepository<Flight, String> {
//3

	@Query(value = "SELECT  * from flights  where from_city = :fcode and to_city = :tcode", nativeQuery = true)
	List<Flight> getFlights(@Param("fcode") String fcode, @Param("tcode") String tcode);
//
//	@Query("SELECT  f.No from Flight f  where f.fromcity_flight.code= :fromcode and f.tocity_flight.code= :tocode")
//	List<String> getFlight(@Param("fromcode") String fromcode, @Param("tocode") String tocode);

}
