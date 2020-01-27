package OOPD.Assignment3;

public class Flight extends Vehicle {

	String flightName;
	String flightType;

	public Flight() {

		this.flightName = "";
		this.flightType = "";
	}

	public Flight(String flightName, String flightType) {

		this.flightName = flightName;
		this.flightType = flightType;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

}
