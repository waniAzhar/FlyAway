package com.flyaway.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_flightdata")
public class FlightData {

	
	@Id
	@GeneratedValue
	private int flightId;
	
	private String flightFrom;
	private String destination;
	private String date;
	private double price;
	
	
	
	public FlightData() {
		super();
	}



	public FlightData(String flightFrom, String destination, String date, double price) {
		super();
		this.flightFrom = flightFrom;
		this.destination = destination;
		this.date = date;
		this.price = price;
	}
	
	
	
	public String getFrom() {
		return flightFrom;
	}
	public void setFrom(String from) {
		this.flightFrom = from;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getFlightId() {
		return flightId;
	}
	
	
	
	
}
