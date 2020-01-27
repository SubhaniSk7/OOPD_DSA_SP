package OOPD.Assignment2;

public class Address {

	String mobile;
	String address;

	public Address() {
		this.mobile = "";
		this.address = "";
	}

	public Address(String mobile, String address) {
		this.mobile = mobile;
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
