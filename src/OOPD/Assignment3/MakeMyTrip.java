package OOPD.Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeMyTrip {

	static Scanner sc = new Scanner(System.in);

	static MakeMyTrip makeMyTrip = new MakeMyTrip();
	static Constants constants = new Constants();
	static BussinessObject bObj = new BussinessObject();

	public static Login login = new Login();

	public static void main(String subhani[]) throws InterruptedException {

		bObj.superAdmin();
		bObj.HardAddServiceByAdmin();
		bObj.cancellationChargesArray();

		int choice;
		int loginChoice;

		try {
			do {
				System.out.println("\n1.Admin Login.\n2.Company Login.\n3.User Login.\n4.exit");
				loginChoice = sc.nextInt();

				switch (loginChoice) {
				case 1:

					// System.out.println("enter adminId:");
					// int adminId = sc.nextInt();
					int adminId = 1;

					makeMyTrip.admin(adminId);

					break;
				case 2:

					System.out.println("companies list:");
					// bObj.viewCustomers();
					System.out.println("------");
					int companyChoice;
					do {
						System.out.println("\n1.login\n2.Register.\n3.goBack");
						companyChoice = sc.nextInt();
						switch (companyChoice) {
						case 1:

							System.out.println("enter companyUserId:");
							int companyUserId = sc.nextInt();

							makeMyTrip.company(companyUserId);

							break;
						case 2:

							int registeredId = bObj.registerCompany();
							// int registeredId = bObj.HardRegisterCompany();

							System.out.println("company registered Id:" + registeredId);

							bObj.viewCompanyList();

							break;
						case 3:
							System.out.println("Going Back..");
							break;
						default:
							System.out.println("invalid choice..");
							break;
						}
					} while (companyChoice != 3);

					break;
				case 3:

					System.out.println("User list:");
					// bObj.viewCustomers();
					System.out.println("------");
					int custChoice;

					System.out.println("=============UserList=============");
					bObj.viewUserList();

					do {
						System.out.println("\n1.login\n2.signup.\n3.goBack");
						custChoice = sc.nextInt();
						switch (custChoice) {
						case 1:
							System.out.println("=============User Login=============");
							System.out.println("enter userId:");
							int userId = sc.nextInt();
							makeMyTrip.user(userId);
							break;
						case 2:
							System.out.println("=============User SignUp=============");
							bObj.registerUser();
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
		} catch (NumberFormatException n) {
			n.printStackTrace();
		}

	}

	public void admin(int adminId) {

		if (bObj.adminLogin(adminId).getLoginStatus().equals(constants.LOGIN_SUCCESS)) {

			System.out.println("Logged in Successfully..");
			int adminChoice;

			try {
				do {

					System.out.println("\n-----------------------------------------\n"
							+ "1.viewCompanies\n2.viewUsers\n3.addCompany\n"
							// + "4.removeCompany\n"
							// + "5.addUser\n6.removeUser\n"
							+ "4.viewBuses\n" + "5.viewFlights\n6.viewTrains\n" + "7.viewServices" + "\n8.logout");
					adminChoice = sc.nextInt();
					switch (adminChoice) {

					case 1:
						System.out.println("============ViewCompanyList============");
						bObj.viewCompanyList();
						break;
					case 2:
						System.out.println("============ViewUserList============");
						bObj.viewUserList();
						break;
					case 3:
						System.out.println("============RegisterCompany============");
						int companyRegisteredId = bObj.registerCompany();
						System.out.println("Company registered Id:" + companyRegisteredId);
						break;
					// case 4:
					// System.out.println("============RemoveCompany============");
					//
					// bObj.viewCompanyList();
					// System.out.println("Enter companyId:");
					// int companyId = sc.nextInt();
					//
					// bObj.removeCompanyId(companyId);
					// break;
					// case 5:
					// System.out.println("============AddUser============");
					//
					// // bObj.addUser();
					// break;
					// case 6:
					// System.out.println("============RemoveUser============");
					//
					// bObj.viewUserList();
					// System.out.println("enter UserId:");
					// // bObj.removeUser();
					// break;
					case 4:
						System.out.println("============ViewBuses============");

						bObj.viewBusList();
						break;
					case 5:
						System.out.println("============ViewFlights============");

						bObj.viewFlightList();
						break;
					case 6:
						System.out.println("============ViewTrains============");
						bObj.viewTrainList();
						break;

					case 7:
						bObj.printServices();
						break;
					case 8:
						System.out.println("Logged out successfully..");
						break;
					default:
						System.out.println("enter valid choice..");
						break;
					}

				} while (adminChoice != 8);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

	public void company(int companyId) {

		login = bObj.companyLogin(companyId);

		if (login.getLoginStatus().equals(constants.LOGIN_SUCCESS)) {

			System.out.println("Company LoggedIn Successfully..");

			// int restId = bObj.getOwnedRestId(login.getLoginId());

			int companyChoice;
			try {
				do {
					System.out.println(
							// "\n1.viewServices\n"
							// + "2.addService\n3.removeService\n"
							"\n-----------------------------------------\n" + "1.Add Bus\n"
							// + "2.Remove Bus\n"
									+ "2.Add Flight\n"
									// + "4.Remove Flight\n"
									+ "3.Add Train\n"
									// + "6.Remove Train\n"
									+ "4.Update BookingCharges\n" + "5.View Buses\n" + "6.View Flights\n"
									+ "7.View Trains\n" + "8.updateOfferCost\n" + "9.logout");
					companyChoice = sc.nextInt();
					switch (companyChoice) {

					case 1:
						System.out.println("=============Add Bus=============");
						// bObj.HardAddBusToCompany(companyId);
						bObj.addBusToCompany(companyId);

						break;
					// case 2:
					// System.out.println("=============Remove Bus=============");
					// bObj.removeBusFromCompany(companyId);
					//
					// break;
					case 2:
						System.out.println("=============Add Flight=============");

						bObj.addFlightToCompany(companyId);
						// bObj.HardAddFlightToCompany(companyId);

						break;
					// case 4:
					// System.out.println("=============Remove Flight=============");
					// bObj.removeFlightFromCompany(companyId);
					//
					// break;
					case 3:
						System.out.println("=============Add Train=============");
						bObj.addTrainToCompany(companyId);

						// bObj.HardAddTrainToCompany(companyId);
						break;
					// case 6:
					// System.out.println("=============Remove Train=============");
					// bObj.removeTrainFromCompany(companyId);
					//
					// break;
					case 4:
						System.out.println("=============Update BookingCharges=============");
						System.out.println("Enter Booking Charges:");
						int bookingCharges = sc.nextInt();

						bObj.updateBookingCharges(companyId, bookingCharges);
						break;
					case 5:
						System.out.println("=============View BusList=============");
						bObj.viewBusListOfCompany(companyId);

						break;
					case 6:
						System.out.println("=============View FlightList=============");
						bObj.viewFlightListOfCompany(companyId);

						break;
					case 7:
						System.out.println("=============View TrainList=============");
						bObj.viewTrainListOfCompany(companyId);

						break;
					case 8:
						System.out.println("=============Update OfferCost per Ticket=============");
						System.out.println("Enter Offer Cost:");
						int offerCost = sc.nextInt();

						bObj.updateOfferCost(companyId, offerCost);

						break;
					case 9:
						System.out.println("Logging out..");
						break;
					default:
						System.out.println("enter valid choice..");
						break;
					}

				} while (companyChoice != 9);
			} catch (NumberFormatException f) {
				f.printStackTrace();
			} catch (Exception z) {
				z.printStackTrace();
			}
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

	public void user(int userId) throws InterruptedException {

		login = bObj.userLogin(userId);
		if (login.getLoginStatus().equals(constants.LOGIN_SUCCESS)) {

			System.out.println("User LoggedIn Successfully..");

			int customerChoice;
			try {
				do {
					System.out.println("\n-----------------------------------------\n"
							+ "1.viewServices.\n2.bookBusTickets\n3.bookFlightTickets\n4.bookTrainTickets\n5.viewHistory\n6.cancelTicket\n"
							+ "7.searchBuses\n" + "8.searchFlights\n" + "9.searchTrains\n" + "10.logout");

					customerChoice = sc.nextInt();
					String source, destination;
					switch (customerChoice) {

					case 1:
						System.out.println("========================View Services========================");
						bObj.printServices();
						break;
					case 2:
						System.out.println("========================Book BusTickets========================");
						// bObj.viewBusCompanies();

						bObj.bookBusTickets(userId);
						break;
					case 3:
						System.out.println("========================Book FlightTickets========================");
						// bObj.viewFlightCompanies();

						bObj.bookFlightTickets(userId);

						break;
					case 4:
						System.out.println("========================Book TrainTickets========================");
						// bObj.viewTrainCompanies();

						bObj.bookTrainTickets(userId);
						break;

					case 5:
						System.out.println("========================View History========================");

						bObj.viewHistory(login.getLoginId());
						break;
					case 6:
						System.out.println("========================Cancel Ticket========================");
						bObj.cancelTicket(userId);
						break;
					case 7:
						System.out.println("========================Search BUS========================");
						System.out.println("source:");
						source = sc.next();
						System.out.println("Destination:");
						destination = sc.next();

						ArrayList<Bus> searchedBuses = bObj.searchBus(source, destination);

						break;
					case 8:
						System.out.println("========================Search Flight========================");
						System.out.println("source:");
						source = sc.next();
						System.out.println("Destination:");
						destination = sc.next();

						ArrayList<Flight> searchedFlights = bObj.searchFlight(source, destination);

						break;
					case 9:
						System.out.println("========================Search Train========================");
						System.out.println("source:");
						source = sc.next();
						System.out.println("Destination:");
						destination = sc.next();

						ArrayList<Train> searchedTrains = bObj.searchTrain(source, destination);

						break;
					case 10:
						System.out.println("Logged out..");
						break;
					default:
						System.out.println("enter valid choice..");
						break;
					}

				} while (customerChoice != 10);
			} catch (NumberFormatException f) {
				f.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Invalid Credentials..");
			return;
		}
	}

}
