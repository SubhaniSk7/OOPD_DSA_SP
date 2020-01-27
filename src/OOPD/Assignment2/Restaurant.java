package OOPD.Assignment2;

import java.util.ArrayList;

public class Restaurant extends Address {

	// private String restId;
	private int restId;
	private String restName;
	private int ownerId;
	private String ownerName;
	private int deliveryCharges;
	private MenuItem menu;
	private ArrayList<MenuItem> menuList;
	private ArrayList<Order> orderToDelivery;
	private ArrayList<Order> ordersDelivered;

	private int minCost;

	// Restaurant[] restaurant;

	public Restaurant() {
		// this.restId = "";
		this.restId = 0;
		this.restName = "";
		this.ownerName = "";
		this.deliveryCharges = 0;
		this.menu = new MenuItem();
		this.menuList = new ArrayList<>();
		this.orderToDelivery = new ArrayList<>();
		this.ordersDelivered = new ArrayList<>();
		this.minCost = 0;

	}

	public Restaurant(int restId, String restName, int ownerId, String ownerName, int deliveryCharges, int minCost) {
		this.restId = restId;
		this.restName = restName;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.deliveryCharges = deliveryCharges;
		this.minCost = minCost;
	}

	public Restaurant(int restId, String restName, int ownerId, String ownerName, String address,
			ArrayList<MenuItem> menuList) {
		this.restId = restId;
		this.restName = restName;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.address = address;
		this.menuList = menuList;
	}

	public Restaurant(int restId, String restName, int ownerId, String ownerName, int deliveryCharges) {
		this.restId = restId;
		this.restName = restName;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.deliveryCharges = deliveryCharges;
	}

	public Restaurant(int restId, String restName, int ownerId, String ownerName, int deliveryCharges, MenuItem menu) {
		this.restId = restId;
		this.restName = restName;
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.deliveryCharges = deliveryCharges;
		this.menu = menu;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public String getRestName() {
		return restName;
	}

	public void setRestName(String restName) {
		this.restName = restName;
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

	public int getDeliveryCharges() {
		return deliveryCharges;
	}

	public void setDeliveryCharges(int deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}

	public MenuItem getMenu() {
		return menu;
	}

	public void setMenu(MenuItem menu) {
		this.menu = menu;
	}

	public ArrayList<MenuItem> getMenuList() {
		return menuList;
	}

	public void setMenuList(ArrayList<MenuItem> menuList) {
		this.menuList = menuList;
	}

	public ArrayList<Order> getOrderToDelivery() {
		return orderToDelivery;
	}

	public void setOrderToDelivery(ArrayList<Order> orderToDelivery) {
		this.orderToDelivery = orderToDelivery;
	}

	public ArrayList<Order> getOrdersDelivered() {
		return ordersDelivered;
	}

	public void setOrdersDelivered(ArrayList<Order> ordersDelivered) {
		this.ordersDelivered = ordersDelivered;
	}

	public int getMinCost() {
		return minCost;
	}

	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}

}
