package flights.info.system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "flight_history")
public class FlightHistory {

	@EmbeddedId
	private FlightKey keyfh;

	@Column(name = "departure_time")
	private String deptime_fh;

	@Column(name = "arrival_date")
	private String arrdate_fh;

	@Column(name = "arrival_time")
	private String arrtime_fh;

	@Column(name = "duration_in_minutes")
	private int mins_fh;

	@Column(name = "aircraft")
	private String aircraft_fh;

	@Column(name = "remarks")
	private String remarks_fh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "from_city")
	private City fromcity_fh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "flightno", insertable = false, updatable = false)
	private Flight flightno_fh;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "to_city")
	private City tocity_fh;

	public FlightKey getKeyfh() {
		return keyfh;
	}

	public void setKeyfh(FlightKey keyfh) {
		this.keyfh = keyfh;
	}

	public String getDeptime_fh() {
		return deptime_fh;
	}

	public void setDeptime_fh(String deptime_fh) {
		this.deptime_fh = deptime_fh;
	}

	public String getArrdate_fh() {
		return arrdate_fh;
	}

	public void setArrdate_fh(String arrdate_fh) {
		this.arrdate_fh = arrdate_fh;
	}

	public String getArrtime_fh() {
		return arrtime_fh;
	}

	public void setArrtime_fh(String arrtime_fh) {
		this.arrtime_fh = arrtime_fh;
	}

	public int getMins_fh() {
		return mins_fh;
	}

	public void setMins_fh(int mins_fh) {
		this.mins_fh = mins_fh;
	}

	public String getAircraft_fh() {
		return aircraft_fh;
	}

	public void setAircraft_fh(String aircraft_fh) {
		this.aircraft_fh = aircraft_fh;
	}

	public String getRemarks_fh() {
		return remarks_fh;
	}

	public void setRemarks_fh(String remarks_fh) {
		this.remarks_fh = remarks_fh;
	}

	public City getFromcity_fh() {
		return fromcity_fh;
	}

	public void setFromcity_fh(City fromcity_fh) {
		this.fromcity_fh = fromcity_fh;
	}

	public Flight getFlightno_fh() {
		return flightno_fh;
	}

	public void setFlightno_fh(Flight flightno_fh) {
		this.flightno_fh = flightno_fh;
	}

	public City getTocity_fh() {
		return tocity_fh;
	}

	public void setTocity_fh(City tocity_fh) {
		this.tocity_fh = tocity_fh;
	}

}