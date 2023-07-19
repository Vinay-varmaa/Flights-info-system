package flights.info.system.rest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import flights.info.system.entities.City;

public interface CityRepo extends JpaRepository<City, String> {
//1
	@Query(" select c.name FROM City c")
	List<String> getCities();

}
