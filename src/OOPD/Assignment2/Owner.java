package OOPD.Assignment2;

public class Owner {
	int ownerId;
	String ownerName;
	Restaurant owned;

	public Owner() {
		this.ownerId = 0;
		this.ownerName = "";
		this.owned = new Restaurant();
	}

	public Owner(int ownerId, String ownerName) {
		this.ownerId = ownerId;
		this.ownerName = ownerName;
	}

	public Owner(Restaurant owned) {
		this.owned = owned;
	}

	public Owner(String ownerName, Restaurant owned) {
		this.ownerName = ownerName;
		this.owned = owned;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public Restaurant getOwned() {
		return owned;
	}

	public void setOwned(Restaurant owned) {
		this.owned = owned;
	}

	@Override
	public String toString() {
		return "Owner [ownerName=" + ownerName + ", owned=" + owned + "]";
	}

}
