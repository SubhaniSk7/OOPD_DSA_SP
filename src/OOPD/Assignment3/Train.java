package OOPD.Assignment3;

public class Train extends Vehicle {

	private String trainName;
	private String trainType;

	public Train() {
		super();
		this.trainName = "";
		this.trainType = "";
	}

	public Train(String trainName, String trainType) {
		super();
		this.trainName = trainName;
		this.trainType = trainType;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

}
