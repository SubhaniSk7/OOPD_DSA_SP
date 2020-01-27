package OOPD.Assignment3;

import java.util.Date;

public class Trip {

	private int tripId;
	private String source;
	private String destination;
	private Date journeyDate;
	private Date bookedDate;
	private int ticketsCount;
	private int tripCost;
	private int vehicleId;
	private int companyId;

	private int vehicleServiceType;

	public Trip() {

		this.tripId = 0;
		this.source = "";
		this.destination = "";
		this.journeyDate = new Date();
		this.bookedDate = new Date();
		this.ticketsCount = 0;
		this.tripCost = 0;
		this.vehicleServiceType = 0;
		this.vehicleId = 0;
		this.companyId = 0;
	}

	public Trip(int tripId, String source, String destination, Date journeyDate, Date bookedDate, int ticketsCount,
			int tripCost, int vehicleServiceType, int vehicleId, int companyId) {

		this.tripId = tripId;
		this.source = source;
		this.destination = destination;
		this.journeyDate = journeyDate;
		this.bookedDate = bookedDate;
		this.ticketsCount = ticketsCount;
		this.tripCost = tripCost;
		this.vehicleServiceType = vehicleServiceType;
		this.vehicleId = vehicleId;
		this.companyId = companyId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Date getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}

	public int getTicketsCount() {
		return ticketsCount;
	}

	public void setTicketsCount(int ticketsCount) {
		this.ticketsCount = ticketsCount;
	}

	public int getTripCost() {
		return tripCost;
	}

	public void setTripCost(int tripCost) {
		this.tripCost = tripCost;
	}

	public int getVehicleServiceType() {
		return vehicleServiceType;
	}

	public void setVehicleServiceType(int vehicleServiceType) {
		this.vehicleServiceType = vehicleServiceType;
	}

}
