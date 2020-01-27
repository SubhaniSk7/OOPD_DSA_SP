package OOPD.Assignment3;

import java.util.ArrayList;

public class Company extends Address {

	private int companyId;
	private String companyName;
	private String companyEmail;
	private int companyServiceTypeId;
	// private int companyServiceCount;

	private Flight ownedFlights;
	private Train ownedTrains;
	private int bookingCharges;
	private int offerCost;

	private ArrayList<Service> companyServiceList;
	private ArrayList<Bus> ownedBusList;
	private ArrayList<Flight> ownedFlightList;
	private ArrayList<Train> ownedTrainList;

	public Company() {
		this.companyId = 0;
		this.companyName = "";
		this.companyEmail = "";
		this.companyServiceTypeId = 0;

		this.ownedFlights = new Flight();
		this.ownedTrains = new Train();
		this.bookingCharges = 0;
		this.offerCost = 0;

		this.companyServiceList = new ArrayList<>();
		this.ownedBusList = new ArrayList<>();
		this.ownedFlightList = new ArrayList<>();
		this.ownedTrainList = new ArrayList<>();
	}

	public Company(int companyId, String companyName, String companyEmail, int companyServiceTypeId,
			Flight ownedFlights, Train ownedTrains, int bookingCharges, int offerCost,
			ArrayList<Service> companyServiceList, ArrayList<Bus> ownedBusList, ArrayList<Flight> ownedFlightList,
			ArrayList<Train> ownedTrainList) {

		this.companyId = companyId;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.companyServiceTypeId = companyServiceTypeId;

		this.ownedFlights = ownedFlights;
		this.ownedTrains = ownedTrains;
		this.bookingCharges = bookingCharges;
		this.offerCost = offerCost;

		this.companyServiceList = companyServiceList;
		this.ownedBusList = ownedBusList;
		this.ownedFlightList = ownedFlightList;
		this.ownedTrainList = ownedTrainList;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public int getOfferCost() {
		return offerCost;
	}

	public void setOfferCost(int offerCost) {
		this.offerCost = offerCost;
	}

	public ArrayList<Service> getCompanyServiceList() {
		return companyServiceList;
	}

	public void setCompanyServiceList(ArrayList<Service> companyServiceList) {
		this.companyServiceList = companyServiceList;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getBookingCharges() {
		return bookingCharges;
	}

	public void setBookingCharges(int bookingCharges) {
		this.bookingCharges = bookingCharges;
	}

	public int getCompanyServiceTypeId() {
		return companyServiceTypeId;
	}

	public void setCompanyServiceTypeId(int companyServiceTypeId) {
		this.companyServiceTypeId = companyServiceTypeId;
	}

	public Flight getOwnedFlights() {
		return ownedFlights;
	}

	public void setOwnedFlights(Flight ownedFlights) {
		this.ownedFlights = ownedFlights;
	}

	public Train getOwnedTrains() {
		return ownedTrains;
	}

	public void setOwnedTrains(Train ownedTrains) {
		this.ownedTrains = ownedTrains;
	}

	public ArrayList<Bus> getOwnedBusList() {
		return ownedBusList;
	}

	public void setOwnedBusList(ArrayList<Bus> ownedBusList) {
		this.ownedBusList = ownedBusList;
	}

	public ArrayList<Flight> getOwnedFlightList() {
		return ownedFlightList;
	}

	public void setOwnedFlightList(ArrayList<Flight> ownedFlightList) {
		this.ownedFlightList = ownedFlightList;
	}

	public ArrayList<Train> getOwnedTrainList() {
		return ownedTrainList;
	}

	public void setOwnedTrainList(ArrayList<Train> ownedTrainList) {
		this.ownedTrainList = ownedTrainList;
	}

}
