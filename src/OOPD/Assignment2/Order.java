package OOPD.Assignment2;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	private int orderId;
	private String orderName;
	private int orderedByCustomerId;
	private String orderedByCustomerName;
	private int orderToRestId;
	private int orderCost;
	private Date orderTime;
	private String status;
	private ArrayList<MenuItem> order;

	public Order() {
		this.orderId = 0;
		this.orderName = "";
		this.orderToRestId = 0;
		this.orderedByCustomerId = 0;
		this.orderedByCustomerName = "";
		this.orderCost = 0;
		this.status = "";
		this.order = new ArrayList<>();
	}

	public Order(int orderId, String orderName, int orderedByCustomerId, int orderToRestId,
			String orderedByCustomerName, int orderCost, Date orderTime, String status, ArrayList<MenuItem> order) {

		this.orderId = orderId;
		this.orderName = orderName;
		this.orderToRestId = orderToRestId;
		this.orderedByCustomerId = orderedByCustomerId;
		this.orderedByCustomerName = orderedByCustomerName;
		this.orderCost = orderCost;
		this.orderTime = orderTime;
		this.status = status;
		this.order = order;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public int getOrderedByCustomerId() {
		return orderedByCustomerId;
	}

	public void setOrderedByCustomerId(int orderedByCustomerId) {
		this.orderedByCustomerId = orderedByCustomerId;
	}

	public String getOrderedByCustomerName() {
		return orderedByCustomerName;
	}

	public void setOrderedByCustomerName(String orderedByCustomerName) {
		this.orderedByCustomerName = orderedByCustomerName;
	}

	public int getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(int orderCost) {
		this.orderCost = orderCost;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public String getStatus() {
		return status;
	}

	public int getOrderToRestId() {
		return orderToRestId;
	}

	public void setOrderToRestId(int orderToRestId) {
		this.orderToRestId = orderToRestId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ArrayList<MenuItem> getOrder() {
		return order;
	}

	public void setOrder(ArrayList<MenuItem> order) {
		this.order = order;
	}

}
