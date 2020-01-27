package OOPD.Assignment3;

import java.util.ArrayList;

public class User extends Address {

	private int userId;
	private String userName;
	private int userTripCost;
	private String userEmail;
	private int userBookedTicketsCount;
	private Trip trip;

	// private Trip tripHistory;
	private ArrayList<Trip> tripHistory;
	// private ArrayList<MenuItem> cart;
	private ArrayList<Trip> currentTrips;

	public User() {

		this.userId = 0;
		this.userName = "";
		this.userTripCost = 0;
		this.userEmail = "";
		this.userBookedTicketsCount = 0;
		this.trip = new Trip();
		this.tripHistory = new ArrayList<>();
		this.currentTrips = new ArrayList<>();
	}

	public User(int userId, String userName, int userTripCost, String userEmail, int userBookedTicketsCount, Trip trip,
			ArrayList<Trip> tripHistory, ArrayList<Trip> currentTrips) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userTripCost = userTripCost;
		this.userEmail = userEmail;
		this.userBookedTicketsCount = userBookedTicketsCount;
		this.trip = trip;
		this.tripHistory = tripHistory;
		this.currentTrips = currentTrips;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserTripCost() {
		return userTripCost;
	}

	public void setUserTripCost(int userTripCost) {
		this.userTripCost = userTripCost;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserBookedTicketsCount() {
		return userBookedTicketsCount;
	}

	public void setUserBookedTicketsCount(int userBookedTicketsCount) {
		this.userBookedTicketsCount = userBookedTicketsCount;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public ArrayList<Trip> getTripHistory() {
		return tripHistory;
	}

	public void setTripHistory(ArrayList<Trip> tripHistory) {
		this.tripHistory = tripHistory;
	}

	public ArrayList<Trip> getCurrentTrips() {
		return currentTrips;
	}

	public void setCurrentTrips(ArrayList<Trip> currentTrips) {
		this.currentTrips = currentTrips;
	}

}
