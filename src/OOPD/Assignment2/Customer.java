package OOPD.Assignment2;

import java.util.ArrayList;

public class Customer extends Address {
	private int custId;
	private String custName;
	private int custCartCost;
	private String custEmail;
	private int custOrderedItems;
	private Order order;
	private boolean owner;
	private ArrayList<Order> orderHistory;
	private ArrayList<MenuItem> cart;
	private ArrayList<Order> currentOrders;

	public Customer() {
		this.custId = 0;
		this.custName = "";
		this.custEmail = "";
		this.custCartCost = 0;
		this.custOrderedItems = 0;
		this.order = new Order();
		this.owner = false;
		this.orderHistory = new ArrayList<>();
		this.cart = new ArrayList<>();
		this.currentOrders = new ArrayList<>();

	}

	public Customer(int custId, String custName, String custEmail) {
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
	}

	public Customer(int custId, String custName, int custCartCost, int custOrderedItems, Order order, boolean owner) {
		this.custId = custId;
		this.custName = custName;
		this.custCartCost = custCartCost;
		this.custOrderedItems = custOrderedItems;
		this.order = order;
		this.owner = owner;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustCartCost() {
		return custCartCost;
	}

	public void setCustCartCost(int custCartCost) {
		this.custCartCost = custCartCost;
	}

	public int getCustOrderedItems() {
		return custOrderedItems;
	}

	public void setCustOrderedItems(int custOrderedItems) {
		this.custOrderedItems = custOrderedItems;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public boolean isOwner() {
		return owner;
	}

	public void setOwner(boolean owner) {
		this.owner = owner;
	}

	public ArrayList<Order> getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(ArrayList<Order> orderHistory) {
		this.orderHistory = orderHistory;
	}

	public ArrayList<MenuItem> getCart() {
		return cart;
	}

	public void setCart(ArrayList<MenuItem> cart) {
		this.cart = cart;
	}

	public ArrayList<Order> getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(ArrayList<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

}
