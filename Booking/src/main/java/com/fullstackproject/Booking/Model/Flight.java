package com.fullstackproject.Booking.Model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "Flight")
public class Flight {


	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	@Id
	private String flightId;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String flightName;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String sourceAirport;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String dstnAirport;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String date;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String sourceTime;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String dstnTime;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String price;

	public Flight() {
		
	}

	public Flight(@NotBlank @Size(max = 100) String flightId, @NotBlank @Size(max = 100) String flightName, @NotBlank @Size(max = 100) String sourceAirport, @NotBlank @Size(max = 100) String dstnAirport, @NotBlank @Size(max = 100) String date, @NotBlank @Size(max = 100) String sourceTime, @NotBlank @Size(max = 100) String dstnTime, @NotBlank @Size(max = 100) String price) {
		this.flightId = flightId;
		this.flightName = flightName;
		this.sourceAirport = sourceAirport;
		this.dstnAirport = dstnAirport;
		this.date = date;
		this.sourceTime = sourceTime;
		this.dstnTime = dstnTime;
		this.price = price;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getSourceAirport() {
		return sourceAirport;
	}

	public void setSourceAirport(String sourceAirport) {
		this.sourceAirport = sourceAirport;
	}

	public String getDstnAirport() {
		return dstnAirport;
	}

	public void setDstnAirport(String dstnAirport) {
		this.dstnAirport = dstnAirport;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSourceTime() {
		return sourceTime;
	}

	public void setSourceTime(String sourceTime) {
		this.sourceTime = sourceTime;
	}

	public String getDstnTime() {
		return dstnTime;
	}

	public void setDstnTime(String dstnTime) {
		this.dstnTime = dstnTime;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight{" +
				"flightId='" + flightId + '\'' +
				", flightName='" + flightName + '\'' +
				", sourceAirport='" + sourceAirport + '\'' +
				", dstnAirport='" + dstnAirport + '\'' +
				", date='" + date + '\'' +
				", sourceTime='" + sourceTime + '\'' +
				", dstnTime='" + dstnTime + '\'' +
				", price='" + price + '\'' +
				'}';
	}
}
