package com.training.wipro.task.entities;

import java.util.Date;

public class Flight {
    private String flightName;
    private Date arrivalTime;
    private Date departureTime;
    private String startLocation;
    private String endLocation;
    private double flightFare;
    private int flightId;
    public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public Flight() {
		super();
	}

	public Flight(String flightName, Date arrivalTime, Date departureTime, String startLocation, String endLocation, double flightFare) {
        this.flightName = flightName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.flightFare = flightFare;
    }

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public double getFlightFare() {
		return flightFare;
	}

	public void setFlightFare(double flightFare) {
		this.flightFare = flightFare;
	}

	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ ", startLocation=" + startLocation + ", endLocation=" + endLocation + ", flightFare=" + flightFare
				+ "]";
	}

    
}

