package OOPD.Assignment3;

public class Admin extends Address {

	private int adminId;
	private String password;

	public Admin() {
		this.adminId = 0;
		this.password = "";
	}

	public Admin(int adminId, String password) {
		this.adminId = adminId;
		this.password = password;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
