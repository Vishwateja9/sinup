package com.fullstackproject.Flight.Model;

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
	private String sourceairport;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String dstnairport;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String date;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String sourcetime;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String dstntime;
	
	@NotBlank
    @Size(max=100)
    @Indexed(unique=true)
	private String price;

	public Flight() {
		
	}
	public Flight(String flightId, String flightName, String sourceairport, String dstnairport,String date, String sourcetime,
			String dstntime, String price) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.sourceairport = sourceairport;
		this.dstnairport = dstnairport;
		this.date=date;
		this.sourcetime = sourcetime;
		this.dstntime = dstntime;
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
	public String getSourceairport() {
		return sourceairport;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setSourceairport(String sourceairport) {
		this.sourceairport = sourceairport;
	}
	public String getDstnairport() {
		return dstnairport;
	}
	public void setDstnairport(String dstnairport) {
		this.dstnairport = dstnairport;
	}
	public String getSourcetime() {
		return sourcetime;
	}
	public void setSourcetime(String sourcetime) {
		this.sourcetime = sourcetime;
	}
	public String getDstntime() {
		return dstntime;
	}
	public void setDstntime(String dstntime) {
		this.dstntime = dstntime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightName=" + flightName + ", sourceairport=" + sourceairport
				+ ", dstnairport=" + dstnairport + ", date=" + date + ", sourcetime=" + sourcetime + ", dstntime="
				+ dstntime + ", price=" + price + "]";
	}
	
	
	
}
