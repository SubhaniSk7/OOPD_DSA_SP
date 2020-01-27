package OOPD.Assignment3;

import java.util.Date;

public class Vehicle {

	int vehicleId;
	int seatsCount;
	int seatCost;
	int offerCost;
	int seatsFilled;
	int seatsAvailable;
	int vehicleServiceTypeId;
	int bookingCharges;

	String sourceStation;
	String destinationStation;
	Date travellingDate;

	int ownedByCompanyId;

	public Vehicle() {

		this.vehicleId = 0;
		this.seatsCount = 0;
		this.seatCost = 0;
		this.offerCost = 0;
		this.seatsFilled = 0;
		this.seatsAvailable = 0;
		this.vehicleServiceTypeId = 0;
		this.bookingCharges = 0;
		this.sourceStation = "";
		this.destinationStation = "";
		this.travellingDate = new Date();
		this.ownedByCompanyId = 0;
	}

	public Vehicle(int vehicleId, int seatsCount, int seatCost, int offerCost, int seatsFilled, int seatsAvailable,
			int vehicleServiceTypeId, int bookingCharges, String sourceStation, String destinationStation,
			Date travellingDate, int ownedByCompanyId) {

		this.vehicleId = vehicleId;
		this.seatsCount = seatsCount;
		this.seatCost = seatCost;
		this.offerCost = offerCost;
		this.seatsFilled = seatsFilled;
		this.seatsAvailable = seatsAvailable;
		this.vehicleServiceTypeId = vehicleServiceTypeId;
		this.bookingCharges = bookingCharges;
		this.sourceStation = sourceStation;
		this.destinationStation = destinationStation;
		this.travellingDate = travellingDate;
		this.ownedByCompanyId = ownedByCompanyId;
	}

	public String getSourceStation() {
		return sourceStation;
	}

	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}

	public Date getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(Date travellingDate) {
		this.travellingDate = travellingDate;
	}

	public int getBookingCharges() {
		return bookingCharges;
	}

	public void setBookingCharges(int bookingCharges) {
		this.bookingCharges = bookingCharges;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getSeatsCount() {
		return seatsCount;
	}

	public void setSeatsCount(int seatsCount) {
		this.seatsCount = seatsCount;
	}

	public int getSeatCost() {
		return seatCost;
	}

	public void setSeatCost(int seatCost) {
		this.seatCost = seatCost;
	}

	public int getOfferCost() {
		return offerCost;
	}

	public void setOfferCost(int offerCost) {
		this.offerCost = offerCost;
	}

	public int getSeatsFilled() {
		return seatsFilled;
	}

	public void setSeatsFilled(int seatsFilled) {
		this.seatsFilled = seatsFilled;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public int getVehicleServiceTypeId() {
		return vehicleServiceTypeId;
	}

	public void setVehicleServiceTypeId(int vehicleService) {
		this.vehicleServiceTypeId = vehicleService;
	}

	// public Company getOwnedByCompany() {
	// return ownedByCompany;
	// }
	//
	// public void setOwnedByCompany(Company ownedByCompany) {
	// this.ownedByCompany = ownedByCompany;
	// }

	public int getOwnedByCompanyId() {
		return ownedByCompanyId;
	}

	public void setOwnedByCompanyId(int ownedByCompanyId) {
		this.ownedByCompanyId = ownedByCompanyId;
	}

}
