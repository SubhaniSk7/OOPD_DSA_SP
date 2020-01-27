package OOPD.Assignment3;

public class Bus extends Vehicle {

	private String busName;
	private String busType;

	public Bus() {

		this.busName = "";
		this.busType = "";
	}

	public Bus(String busName, String busType) {

		this.busName = busName;
		this.busType = busType;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

}
