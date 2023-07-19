package flights.info.system.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "flights")
public class Flight {
	@Id
	@Column(name = "flightno")
	private String No;

	@Column(name = "duration_in_minutes")
	private int dur_min;

	@Column(name = "departure_time")
	private String dep_time;

	@Column(name = "arrival_time")
	private String arr_time;

	@Column(name = "aircraft")
	private String aircraft;

	@Column(name = "from_city")
	private String from_city;

	@Column(name = "to_city")
	private String to_city;

	@OneToMany(mappedBy = "flightno_sf")
	@JsonIgnore
	private List<ScheduledFlight> flight_sf;

	@OneToMany(mappedBy = "flightno_fh")
	@JsonIgnore
	private List<FlightHistory> flightno_fh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "from_city", updatable = false, insertable = false)
	private City fromcity_flight;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "to_city", updatable = false, insertable = false)
	private City tocity_flight;

	public List<ScheduledFlight> getFlight_sf() {
		return flight_sf;
	}

	public void setFlight_sf(List<ScheduledFlight> flight_sf) {
		this.flight_sf = flight_sf;
	}

	public String getFrom_city() {
		return from_city;
	}

	public void setFrom_city(String from_city) {
		this.from_city = from_city;
	}

	public String getTo_city() {
		return to_city;
	}

	public void setTo_city(String to_city) {
		this.to_city = to_city;
	}

	public List<FlightHistory> getFlightno_fh() {
		return flightno_fh;
	}

	public void setFlightno_fh(List<FlightHistory> flightno_fh) {
		this.flightno_fh = flightno_fh;
	}

	public String getNo() {
		return No;
	}

	public void setNo(String no) {
		this.No = no;
	}

	public int getDur_min() {
		return dur_min;
	}

	public void setDur_min(int dur_min) {
		this.dur_min = dur_min;
	}

	public String getDep_time() {
		return dep_time;
	}

	public void setDep_time(String dep_time) {
		this.dep_time = dep_time;
	}

	public String getArr_time() {
		return arr_time;
	}

	public void setArr_time(String arrivalTime) {
		this.arr_time = arrivalTime;
	}

	public String getAircraft() {
		return aircraft;
	}

	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}

	public City getFromcity_flight() {
		return fromcity_flight;
	}

	public void setFromcity_flight(City fromcity_flight) {
		this.fromcity_flight = fromcity_flight;
	}

	public City getTocity_flight() {
		return tocity_flight;
	}

	public void setTocity_flight(City tocity_flight) {
		this.tocity_flight = tocity_flight;
	}

	@Override
	public String toString() {
		return "Flight [No=" + No + ", dur_min=" + dur_min + ", dep_time=" + dep_time + ", arr_time=" + arr_time
				+ ", aircraft=" + aircraft + ", from_city=" + from_city + ", to_city=" + to_city + ", flight_sf="
				+ flight_sf + ", flightno_fh=" + flightno_fh + ", fromcity_flight=" + fromcity_flight
				+ ", tocity_flight=" + tocity_flight + "]";
	}

}
