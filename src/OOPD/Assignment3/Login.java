package OOPD.Assignment3;

public class Login {

	private int loginId;
	private String email;
	private String password;
	private boolean admin;
	private boolean customer;
	private boolean owner;
	private String loginStatus;

	public Login() {
		this.loginId = 0;
		this.email = "";
		this.password = "";
		this.admin = false;
		this.customer = false;
		this.owner = false;
		this.loginStatus = "failed";
	}

	public Login(int loginId, boolean admin, boolean owner, boolean customer, String loginStatus) {
		this.loginId = loginId;
		this.admin = admin;
		this.customer = customer;
		this.owner = owner;
		this.loginStatus = loginStatus;
	}

	public Login(int id, String email, String password, boolean admin, boolean owner, boolean customer) {
		this.loginId = id;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.customer = customer;
		this.owner = owner;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isCustomer() {
		return customer;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

}
