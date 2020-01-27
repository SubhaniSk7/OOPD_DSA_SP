package OOPD.Assignment2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class BussinessObject {

	public static int restaurantId = 0;
	public static int ownerId = 0;
	public static int custId = 0;
	public static int itemId = 0;
	public static int orderId = 0;

	public static ArrayList<Restaurant> rests = new ArrayList<>();
	public static ArrayList<Owner> ownerList = new ArrayList<>();
	public static ArrayList<Customer> customerList = new ArrayList<>();
	public static ArrayList<Admin> adminList = new ArrayList<>();

	public static Login login = new Login();

	static Scanner sc = new Scanner(System.in);

	public void superAdmin() {

		Admin superAdmin = new Admin(1, "subhani");
		adminList.add(superAdmin);
	}

	public void addRestaurant() {

		restaurantId += 1;

		// String restaurantId = "" + restaurantId;
		System.out.println("enter restaurantName:");
		String restName = sc.next();
		System.out.println("enter restAddress:");
		String address = sc.next();

		System.out.println("enter ownerName:");
		String ownerName = sc.next();
		ownerId += 1;

		ArrayList<MenuItem> menuList = new ArrayList<>();
		Restaurant r = new Restaurant();

		r.setRestId(restaurantId);
		r.setRestName(restName);
		r.setOwnerId(ownerId);
		r.setOwnerName(ownerName);
		r.setAddress(address);
		r.setMenuList(menuList);

		Owner head = new Owner(ownerId, ownerName);
		head.setOwned(r);

		rests.add(r);
		ownerList.add(head);
	}

	public void modifyRestaurantDetails() {

	}

	public void removeRestaurant() {
		System.out.println("enter restaurantId to remove:");
		int restId = sc.nextInt();

		removeRestaurantId(restId);
		System.out.println("after deletion:\n-----------------");
		viewRestaurants();
	}

	public void viewRestaurants() {

		if (rests.size() == 0) {
			System.out.println("No Restaurants in the List..");
			return;
		}

		Iterator<Restaurant> itr = rests.iterator();
		while (itr.hasNext()) {
			Restaurant obj = itr.next();
			System.out.println("RestId:" + obj.getRestId() + "\tRestName:" + obj.getRestName() + "\tRestAddress:"
					+ obj.getAddress() + "\tOwnerId:" + obj.getOwnerId() + "\tOwnerName:" + obj.getOwnerName()
					+ "\t#Items:" + obj.getMenuList().size() + "\tDeliveryCharges:" + obj.getDeliveryCharges()
					+ "\tminPurchaseCost:" + obj.getMinCost());
		}
	}

	public void viewOwners() {

		if (ownerList.size() == 0) {
			System.out.println("No Owners in the List..");
			return;
		}

		Iterator<Owner> itr = ownerList.iterator();
		while (itr.hasNext()) {
			Owner obj = itr.next();
			System.out.println("ownerId:" + obj.getOwnerId() + "\townerName:" + obj.getOwnerName() + "\tRestId:"
					+ obj.getOwned().getRestId() + "\tRestName:" + obj.getOwned().getRestName());
		}
	}

	public void viewCustomers() {

		if (customerList.size() == 0) {
			System.out.println("No Customers in the List..");
			return;
		}

		Iterator<Customer> itr = customerList.iterator();
		while (itr.hasNext()) {
			Customer obj = itr.next();
			System.out.println("custId:" + obj.getCustId() + "\tcustName:" + obj.getCustName() + "\tcustEmail:"
					+ obj.getCustEmail());
		}
	}

	public void removeRestaurantId(int restId) {

		boolean removed = false;
		Iterator<Restaurant> itr = rests.iterator();
		while (itr.hasNext()) {
			Restaurant obj = itr.next();
			if (obj.getRestId() == restId) {
				rests.remove(obj);
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println("Restaurant removed..");
		} else {
			System.out.println("Restaurant not in the list(Failed)..");
		}
	}

	public void addOwner() {

	}

	public void updateOwner() {

	}

	public void addCustomer() {

		custId += 1;

		System.out.println("enter custName:");
		String custName = sc.next();
		System.out.println("email:");
		String custEmail = sc.next();

		Customer cust = new Customer();

		cust.setCustId(custId);
		cust.setCustName(custName);
		cust.setCustEmail(custEmail);

		customerList.add(cust);

	}

	public void updateCustomer() {

	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public void viewMenu(int restId) {

		if (rests.size() == 0) {
			System.out.println("No Restaurants in the List..");
			return;
		}

		Restaurant obj = new Restaurant();
		Iterator<Restaurant> itr = rests.iterator();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				System.out.println(obj.getRestId() + " " + obj.getRestName() + " " + obj.getOwnerName());
				break;
			}
		}

		System.out.println("\n---------Menu-------------");
		if (obj.getMenuList().size() == 0) {
			System.out.println("No Items in the List..");
			return;
		}
		Iterator<MenuItem> itr2 = obj.getMenuList().iterator();
		while (itr2.hasNext()) {
			MenuItem item = itr2.next();
			System.out.println("catg:" + item.getCategory() + "\titemId:" + item.getItemId() + "\titemName:"
					+ item.getItemName() + "\titemCost:" + item.getItemCost());
		}
	}

	// ---------------------------------------------------------------------------------------------------------------------------

	public Login adminLogin(int adminId) {

		Admin obj = new Admin();
		login.setLoginStatus("failed.");
		Iterator<Admin> itr = adminList.iterator();

		if (adminList.size() == 0) {
			System.out.println("adminList is empty..");
			return login;
		}

		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getAdminId() == adminId) {
				System.out.println(obj.getAdminId());
				boolean admin = true;

				login = new Login(obj.getAdminId(), admin, false, false, "success");

				return login;
			}
		}
		return login;
	}

	public Login ownerLogin(int ownerId) {

		Owner obj = new Owner();
		login.setLoginStatus("failed.");
		Iterator<Owner> itr = ownerList.iterator();

		if (ownerList.size() == 0) {
			System.out.println("OwnerList is empty..");
			return login;
		}

		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getOwnerId() == ownerId) {
				System.out.println(obj.getOwnerId());
				boolean owner = true;
				login = new Login(obj.getOwnerId(), false, owner, false, "success");

				return login;
			}
		}
		return login;
	}

	public Login customerLogin(int customerId) {

		Customer obj = new Customer();
		login.setLoginStatus("failed.");
		Iterator<Customer> itr = customerList.iterator();

		if (customerList.size() == 0) {
			System.out.println("CustomerList is empty..");
			return login;
		}

		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getCustId() == customerId) {
				System.out.println(obj.getCustId());
				boolean customer = true;
				login = new Login(obj.getCustId(), false, false, customer, "success");

				return login;
			}
		}
		return login;
	}

	public int getOwnedRestId(int ownerId) {
		int restId = 0;

		Iterator<Owner> itr = ownerList.iterator();
		Owner obj = new Owner();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getOwnerId() == ownerId) {
				System.out.println("ownerId:" + obj.getOwnerId() + "\tRestName:" + obj.getOwned().getRestName()
						+ "\tRestId:" + obj.getOwned().getRestId());
				restId = obj.getOwned().getRestId();
				return restId;
			}
		}
		return restId;
	}

	public Customer getCustomerFromLoginId(int loginId) {
		Customer obj = new Customer();
		if (customerList.size() == 0) {
			System.out.println("No Customers in the List..");
			return obj;
		}

		Iterator<Customer> itr = customerList.iterator();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getCustId() == loginId) {
				System.out.println("custId:" + obj.getCustId() + "\tcustName:" + obj.getCustName() + "\tcustEmail:"
						+ obj.getCustEmail());
				break;
			}
		}
		return obj;
	}

	public void addMenu(int restId) {

		Iterator<Restaurant> itr = rests.iterator();
		Restaurant obj = new Restaurant();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				System.out.println(obj.getRestId() + " " + obj.getRestName() + " " + obj.getOwnerName());
				break;
			}
		}
		System.out.println("enter how many items:");
		int noOfItems = sc.nextInt();
		int i;

		System.out.println("---------Menu-------------");
		for (i = 0; i < noOfItems; i++) {
			MenuItem item = new MenuItem();

			System.out.println("-----------");
			// System.out.println("Item-" + (i + 1) + " itemId:");
			itemId += 1;

			System.out.println("Item-" + (i + 1) + " Category (V/NV):");
			String itemCat = sc.next();

			System.out.println("Item-" + (i + 1) + " Name:");
			String itemName = sc.next();

			System.out.println("Item-" + (i + 1) + " Cost:");
			int itemCost = sc.nextInt();

			item.setItemId(itemId);
			item.setCategory(itemCat);
			item.setItemName(itemName);
			item.setItemCost(itemCost);
			item.setRestId(restId);

			obj.getMenuList().add(item);
		}
	}

	public void updateDeliveryCharges(int restId, int deliveryCharges) {
		Iterator<Restaurant> itr = rests.iterator();
		Restaurant obj = new Restaurant();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				System.out.println(obj.getRestId() + " " + obj.getRestName() + " " + obj.getOwnerName());
				break;
			}
		}

		obj.setDeliveryCharges(deliveryCharges);

	}

	public void updateMinPurchaseCost(int restId, int minCost) {
		Iterator<Restaurant> itr = rests.iterator();
		Restaurant obj = new Restaurant();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				System.out.println(obj.getRestId() + " " + obj.getRestName() + " " + obj.getOwnerName());
				break;
			}
		}
		obj.setMinCost(minCost);
	}

	public void addToCart(int loginId, int restId) {

		System.out.println("enter how many items to add:");
		int n = sc.nextInt();
		int[] itemIdArray = new int[n];

		Customer cust = new Customer();
		// cust = getCustomerFromLoginId(loginId);
		Iterator<Customer> itr = customerList.iterator();
		while (itr.hasNext()) {
			cust = itr.next();
			if (cust.getCustId() == loginId) {
				System.out.println("custId:" + cust.getCustId() + "\tcustName:" + cust.getCustName() + "\tcustEmail:"
						+ cust.getCustEmail());
				break;
			}
		}

		System.out.println("cart:" + cust.getCart().size());
		int i;
		for (i = 0; i < n; i++) {
			System.out.println("enter itemId-" + (i + 1) + ":");
			itemIdArray[i] = sc.nextInt();
		}
		for (i = 0; i < n; i++) {
			System.out.print(itemIdArray[i] + " ");
		}
		System.out.println("---------");

		ArrayList<MenuItem> menu = getMenuListFromRestId(restId);

		for (i = 0; i < n; i++) {
			Iterator<MenuItem> itr1 = menu.iterator();
			while (itr1.hasNext()) {
				MenuItem item = itr1.next();

				if (item.getItemId() == itemIdArray[i]) {
					System.out.println("---->" + item.getItemId());
					System.out.println("---->cart:" + cust.getCart().size());
					cust.getCart().add(item);

					cust.setCustCartCost(cust.getCustCartCost() + item.getItemCost());
					System.out.println("catg:" + item.getCategory() + "\titemId:" + item.getItemId() + "\titemName:"
							+ item.getItemName() + "\titemCost:" + item.getItemCost());

					System.out.println("-->added...........");

				}
			}
		}
	}

	public ArrayList<MenuItem> getMenuListFromRestId(int restId) {
		ArrayList<MenuItem> menu = new ArrayList<>();

		Restaurant obj = new Restaurant();
		Iterator<Restaurant> itr = rests.iterator();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				System.out.println(obj.getRestId() + " " + obj.getRestName() + " " + obj.getOwnerName());
				break;
			}
		}
		menu.addAll(obj.getMenuList());
		System.out.println("menu length:" + menu.size());
		return menu;
	}

	public void viewCart(int loginId) {

		Customer cust = getCustomerFromLoginId(loginId);
		if (cust == null) {
			return;
		}

		Iterator<MenuItem> itr = cust.getCart().iterator();
		while (itr.hasNext()) {
			MenuItem obj = itr.next();
			System.out.println("itemId:" + obj.getItemId() + "\titemName:" + obj.getItemName() + "\titemCost:"
					+ obj.getItemCost());
		}
		System.out.println("Total CartCost:" + cust.getCustCartCost());
		System.out.println("--------------------------------------------");
	}

	public void removeItemFromCart(int loginId) {

		System.out.println("enter how many items to remove:");
		int n = sc.nextInt();
		int[] itemIdArray = new int[n];

		Customer cust = new Customer();
		// cust = getCustomerFromLoginId(loginId);
		Iterator<Customer> itr = customerList.iterator();
		while (itr.hasNext()) {
			cust = itr.next();
			if (cust.getCustId() == loginId) {
				System.out.println("custId:" + cust.getCustId() + "\tcustName:" + cust.getCustName() + "\tcustEmail:"
						+ cust.getCustEmail());
				break;
			}
		}

		int i, deleteItem;
		for (i = 0; i < n; i++) {
			System.out.println("enter itemId-" + (i + 1) + ":");
			deleteItem = sc.nextInt();
			Iterator<MenuItem> itr1 = cust.getCart().iterator();
			while (itr1.hasNext()) {

				MenuItem item = itr1.next();

				if (item.getItemId() == deleteItem) {
					cust.getCart().remove(item);
					cust.setCustCartCost(cust.getCustCartCost() - item.getItemCost());
					System.out.println("-->removed..");
					break;
				}
			}
		}
		System.out.println("---------");
	}

	public void orderFood(int loginId) {
		System.out.println("==========================");
		Customer cust = new Customer();
		cust = getCustomerFromLoginId(loginId);

		viewCart(loginId);
		if (cust.getCart().size() == 0) {
			System.out.println("No items in the Cart..");
			return;
		}

		int cartRestId = cust.getCart().get(0).getRestId();
		int minCost = 0;
		Iterator<Restaurant> itr = rests.iterator();
		Restaurant obj = new Restaurant();
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == cartRestId) {

				minCost = obj.getMinCost();
				System.out.println("RestId:" + obj.getRestId() + "\tRestName:" + obj.getRestName()
						+ "\tDeliveryCharges:" + obj.getDeliveryCharges() + "\tminPurchaseCose:" + obj.getMinCost());
				cust.setCustCartCost(cust.getCustCartCost() + obj.getDeliveryCharges());
				break;
			}
		}

		if (cust.getCustCartCost() < minCost) {
			System.out.println("please buy MinPurchase by AddItemsToCart..");
			return;
		}

		Order order = new Order();
		order.setOrderId(++orderId);
		order.setOrderCost(cust.getCustCartCost());
		// order.setOrder();
		order.setOrderedByCustomerId(cust.getCustId());
		order.setOrderedByCustomerName(cust.getCustName());
		order.setOrderToRestId(obj.getRestId());
		order.setStatus("Order Placed Successfully.");
		order.setOrder(cust.getCart());

		order.setOrderTime(new Date());

		obj.getOrderToDelivery().add(order);

		cust.getOrderHistory().add(order);
		cust.getCurrentOrders().add(order);

		cust.setCart(new ArrayList<>());

		System.out.println("-->" + cust.getCurrentOrders().get(0).getStatus());
		System.out.println("==========================");

	}

	public void trackOrder(int loginId) throws InterruptedException {

		System.out.println("==========================");

		Customer cust = new Customer();
		cust = getCustomerFromLoginId(loginId);

		if (cust.getCurrentOrders().size() == 0) {
			System.out.println("No Orders placed.");
			return;
		}

		if (cust.getCurrentOrders().size() == 0) {
			System.out.println("No items in the Orders..");
			return;
		}

		Thread.sleep(2000);

		cust.getCurrentOrders().get(0).setStatus("Order Confirmed by Restaurant..");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());

		Thread.sleep(2000);
		cust.getCurrentOrders().get(0).setStatus("Order picked up by our Agent..");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());

		Thread.sleep(2000);
		cust.getCurrentOrders().get(0).setStatus("your order is on the way..");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());

		Thread.sleep(2000);
		cust.getCurrentOrders().get(0).setStatus("Agent will arrive in 20 minutes");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());

		Thread.sleep(2000);
		cust.getCurrentOrders().get(0).setStatus("Agent will arrive in 5 minutes..");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());

		Thread.sleep(1000);
		cust.getCurrentOrders().get(0).setStatus("Order Delivered Successfully.");
		System.out.println(cust.getCurrentOrders().get(0).getStatus());
		System.out.println("Thank your for Placing Order.");

		int restId = cust.getCurrentOrders().get(0).getOrderToRestId();

		Iterator<Restaurant> itr = rests.iterator();
		Restaurant obj;
		while (itr.hasNext()) {
			obj = itr.next();
			if (obj.getRestId() == restId) {
				obj.getOrdersDelivered().add(cust.getCurrentOrders().get(0));
				obj.getOrderToDelivery().remove(0);
			}
		}
		cust.getCurrentOrders().remove(0);

	}

	public void viewOrderedHistory(int loginId) {
		System.out.println("==========================");
		Customer cust = new Customer();
		cust = getCustomerFromLoginId(loginId);

		System.out.println("\n---------OrderHistory-------------");
		if (cust.getOrderHistory().size() == 0) {
			System.out.println("No Orders till now.");
			return;
		}
		Iterator<Order> itr2 = cust.getOrderHistory().iterator();
		while (itr2.hasNext()) {
			Order order = itr2.next();
			System.out.println("orderId:" + order.getOrderId() + "\torderToRestId:" + order.getOrderToRestId()
					+ "\torderTime:" + order.getOrderTime() + "\torderCost:" + order.getOrderCost());
		}

		System.out.println("==========================");

	}
}
