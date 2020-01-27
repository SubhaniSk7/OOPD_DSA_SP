package OOPD.Assignment2;

public class MenuItem {

	private int itemId;
	private String category;
	private String itemName;
	private int itemCost;
	private int restId;

	public MenuItem() {
		this.restId = 0;
		this.itemId = 0;
		this.category = "";
		this.itemName = "";
		this.itemCost = 0;
	}

	public MenuItem(int itemId, String category, String itemName, int itemCost) {
		this.itemId = itemId;
		this.category = category;
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemCost(int itemCost) {
		this.itemCost = itemCost;
	}

}
