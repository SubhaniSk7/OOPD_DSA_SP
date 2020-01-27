package OOPD.Assignment2;

import java.util.Scanner;

public class OnlineFood {

	Restaurant restaurant = new Restaurant();

	static OnlineFood onlineFood = new OnlineFood();
	static BussinessObject busObj = new BussinessObject();
	static Login login = new Login();
	static Scanner sc = new Scanner(System.in);

	public static void main(String subhani[]) throws InterruptedException {

		busObj.superAdmin();
		int choice;
		int loginChoice;

		do {
			System.out.println("\n1.Login Admin.\n2.Login Owner.\n3.Customer.\n4.exit");
			loginChoice = sc.nextInt();

			switch (loginChoice) {
			case 1:

				System.out.println("enter adminId:");
				int adminId = sc.nextInt();

				onlineFood.admin(adminId);

				break;
			case 2:
				System.out.println("enter ownerId:");
				int ownerId = sc.nextInt();

				onlineFood.owner(ownerId);
				break;
			case 3:

				System.out.println("customer list:");
				busObj.viewCustomers();
				System.out.println("------");
				int custChoice;
				do {
					System.out.println("\n1.login\n2.signup.\n3.goBack");
					custChoice = sc.nextInt();
					switch (custChoice) {
					case 1:

						System.out.println("enter customerId:");
						int customerId = sc.nextInt();
						onlineFood.customer(customerId);
						break;
					case 2:
						busObj.addCustomer();
						System.out.println("successfully added.");
						break;
					case 3:
						System.out.println("Going Back..");
						break;
					default:
						System.out.println("invalid choice..");
						break;
					}

				} while (custChoice != 3);

				break;
			case 4:
				System.out.println("exited.");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}

		} while (loginChoice != 4);

	}

	public void admin(int adminId) {

		if (busObj.adminLogin(adminId).getLoginStatus().equals("success")) {

			System.out.println("Logged in Successfully..");
			int adminChoice;

			do {

				System.out.println(
						"\n1.addRestaurant\n2.removeRestaurant\n3.viewRestaurants\n4.viewCustomersList\n5.viewOwnersList\n6.logout");
				adminChoice = sc.nextInt();
				switch (adminChoice) {

				case 1:
					busObj.addRestaurant();
					break;
				case 2:
					busObj.removeRestaurant();
					break;
				case 3:
					busObj.viewRestaurants();
					break;
				case 4:
					busObj.viewCustomers();
					break;
				case 5:
					busObj.viewOwners();
					break;
				case 6:
					System.out.println("Logged out successfully..");
					break;
				default:
					System.out.println("enter valid choice..");
					break;
				}

			} while (adminChoice != 6);
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

	public void owner(int ownerId) {
		login = busObj.ownerLogin(ownerId);
		if (login.getLoginStatus().equals("success")) {

			System.out.println("Owner LoggedIn Successfully..");

			int restId = busObj.getOwnedRestId(login.getLoginId());

			int ownerChoice;
			do {
				System.out.println(
						"\n1.addMenuItem\n2.removeMenuItem\n3.updateItemCost\n4.updateDeliveryCharges\n5.updateMinCost\n6.viewMenuItems\n7.logout");
				ownerChoice = sc.nextInt();
				switch (ownerChoice) {

				case 1:
					busObj.addMenu(restId);
					busObj.viewMenu(restId);
					break;

				case 2:
					break;

				case 3:
					break;

				case 4:

					System.out.println("enter Delivery Charges:");
					int deliveryCharges = sc.nextInt();
					busObj.updateDeliveryCharges(restId, deliveryCharges);
					System.out.println("Updated Successfully.");
					break;

				case 5:
					System.out.println("enter Minimum purchase:");
					int minCost = sc.nextInt();
					busObj.updateMinPurchaseCost(restId, minCost);
					System.out.println("Updated Successfully.");
					break;
				case 6:
					busObj.viewMenu(restId);
					break;
				case 7:
					System.out.println("Logging out..");
					break;
				default:
					System.out.println("enter valid choice..");
					break;
				}

			} while (ownerChoice != 7);
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

	public void customer(int customerId) throws InterruptedException {

		if (busObj.customerLogin(customerId).getLoginStatus().equals("success")) {

			System.out.println("Customer LoggedIn Successfully..");

			int customerChoice;
			do {
				System.out.println(
						"\n1.viewRestaurants.\n2.viewMenu\n3.addItemToCart\n4.removeItemFromCart\n5.viewCart\n6.OrderFood\n7.viewOrderHistory\n8.trackOrder\n9.logout");

				customerChoice = sc.nextInt();
				switch (customerChoice) {

				case 1:
					busObj.viewRestaurants();
					break;
				case 2:
					busObj.viewRestaurants();
					System.out.println("select Restaurant restId:");
					int restId = sc.nextInt();
					busObj.viewMenu(restId);
					break;
				case 3:
					System.out.println("========================AddItemsToCart========================");
					System.out.println("enter RestId:");
					busObj.viewRestaurants();
					System.out.println("select Restaurant restId:");
					int restIdToView = sc.nextInt();
					busObj.viewMenu(restIdToView);
					busObj.addToCart(login.getLoginId(), restIdToView);

					System.out.println("--------------Cart-------------");
					busObj.viewCart(login.getLoginId());
					break;
				case 4:
					System.out.println("========================RemoveItemsFromCart========================");
					busObj.viewRestaurants();
					System.out.println("--------------Cart-------------");
					busObj.viewCart(login.getLoginId());
					busObj.removeItemFromCart(login.getLoginId());
					System.out.println("--------------Cart-------------");
					busObj.viewCart(login.getLoginId());

					System.out.println("================================================");

					break;
				case 5:
					System.out.println("========================viewCart========================");
					busObj.viewCart(login.getLoginId());
					break;
				case 6:
					System.out.println("========================placeOrder========================");
					busObj.orderFood(login.getLoginId());
					break;
				case 7:

					System.out.println("========================viewOrderHistory========================");

					busObj.viewOrderedHistory(login.getLoginId());
					break;
				case 8:
					System.out.println("========================trackOrder========================");
					busObj.trackOrder(login.getLoginId());

					break;
				case 9:
					System.out.println("Logged out..");
					break;
				default:
					System.out.println("enter valid choice..");
					break;
				}

			} while (customerChoice != 9);
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

}
