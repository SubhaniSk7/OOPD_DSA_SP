package OOPD.Assignment3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

public class BussinessObject {

	static Scanner sc = new Scanner(System.in);

	public static Constants constants = new Constants();
	public static Login login = new Login();

	public static ArrayList<Bus> busList = new ArrayList<>();
	public static ArrayList<Train> trainList = new ArrayList<>();
	public static ArrayList<Flight> flightList = new ArrayList<>();

	public static ArrayList<Admin> adminList = new ArrayList<>();
	public static ArrayList<User> userList = new ArrayList<>();
	public static ArrayList<Company> companyList = new ArrayList<>();
	public static ArrayList<Service> availableServices = new ArrayList<>();

	public static int companyUserCounterId = 0;
	public static int userCounterId = 0;
	public static int adminCounterId = 0;
	public static int busCounterId = 0;
	public static int trainCounterId = 0;
	public static int flightCounterId = 0;
	public static int tripCounterId = 0;

	public static int[] cancellationCharges = new int[3];

	// public static ArrayList<Company> busOfferedCompaniesList = new ArrayList<>();
	// public static ArrayList<Company> flightOfferedCompaniesList = new
	// ArrayList<>();
	// public static ArrayList<Company> trainOfferedCompaniesList = new
	// ArrayList<>();

	public void cancellationChargesArray() {
		cancellationCharges[0] = 400;// flight
		cancellationCharges[1] = 80;// bus
		cancellationCharges[2] = 60;// train
	}

	public void superAdmin() {

		Admin superAdmin = new Admin(1, "subhani");
		adminList.add(superAdmin);
	}

	// Admin Login
	public Login adminLogin(int adminId) {

		Admin obj = new Admin();
		login.setLoginStatus("failed.");
		Iterator<Admin> itr = adminList.iterator();

		if (adminList.size() == 0) {
			System.out.println("adminList is empty..");
			return login;
		}

		login.setLoginStatus(constants.LOGIN_FAILURE);
		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getAdminId() == adminId) {
				System.out.println(obj.getAdminId());

				login = new Login(obj.getAdminId(), constants.ADMIN, false, false, constants.LOGIN_SUCCESS);

				return login;
			}
		}
		return login;
	}

	// ==============================Company Related==============================
	public int registerCompany() {

		try {
			companyUserCounterId += 1;

			System.out.println("enter companyName:");
			String companyName = sc.next();
			System.out.println("email:");
			String companyEmail = sc.next();

			int companyServiceTypeId;
			if (companyName.equalsIgnoreCase("IRCTC")) {
				companyServiceTypeId = constants.TRAIN_SERVICE_ID;
			} else {
				System.out.println("enter serviceTypeId:");
				companyServiceTypeId = sc.nextInt();
			}

			Company company = new Company();

			company.setCompanyId(companyUserCounterId);
			company.setCompanyName(companyName);
			company.setCompanyEmail(companyEmail);
			company.setCompanyServiceTypeId(companyServiceTypeId);

			companyList.add(company);

			System.out.println("company added Successfully.");
			// if (companyServiceTypeId == constants.BUS_SERVICE_ID) {
			// busOfferedCompaniesList.add(company);
			// }
			// if (companyServiceTypeId == constants.FLIGHT_SERVICE_ID) {
			// flightOfferedCompaniesList.add(company);oid updateCompany(int companyId) {
			//
			// }
			// }
			// if (companyServiceTypeId == constants.TRAIN_SERVICE_ID) {
			// trainOfferedCompaniesList.add(company);
			// }

			return company.getCompanyId();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int HardRegisterCompany() {

		Company company_1 = new Company();
		companyUserCounterId++;
		String companyName = "IRCTC";
		String companyEmail = "irctc@gmail";
		int companyServiceTypeId = constants.TRAIN_SERVICE_ID;

		company_1.setCompanyId(companyUserCounterId);
		company_1.setCompanyName(companyName);
		company_1.setCompanyEmail(companyEmail);
		company_1.setCompanyServiceTypeId(companyServiceTypeId);

		companyList.add(company_1);
		// trainOfferedCompaniesList.add(company_1);

		// -----------------------------------------------------------------
		Company company_2 = new Company();
		companyUserCounterId++;
		String company2 = "BusCompany";
		String companyEmail2 = "@gmail";
		int companyServiceTypeId2 = constants.BUS_SERVICE_ID;

		company_2.setCompanyId(companyUserCounterId);
		company_2.setCompanyName(company2);
		company_2.setCompanyEmail(companyEmail2);
		company_2.setCompanyServiceTypeId(companyServiceTypeId2);

		companyList.add(company_2);
		// busOfferedCompaniesList.add(company_2);

		// -----------------------------------------------------------------
		Company company_3 = new Company();
		companyUserCounterId++;
		String company3 = "FlightCompany";
		String companyEmail3 = "@gmail";
		int companyServiceTypeId3 = constants.FLIGHT_SERVICE_ID;

		company_3.setCompanyId(companyUserCounterId);
		company_3.setCompanyName(company3);
		company_3.setCompanyEmail(companyEmail3);
		company_3.setCompanyServiceTypeId(companyServiceTypeId3);

		companyList.add(company_3);
		// flightOfferedCompaniesList.add(company_3);

		return companyUserCounterId;
	}

	// Company Login
	public Login companyLogin(int companyId) {
		// System.out.println("in company Login");

		Company obj = new Company();
		login.setLoginStatus(constants.LOGIN_FAILURE);

		if (companyList.size() == 0) {
			System.out.println("companyList is empty..");
			return login;
		}

		Iterator<Company> itr = companyList.iterator();
		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getCompanyId() == companyId) {
				System.out.println(obj.getCompanyId());

				login = new Login(obj.getCompanyId(), false, constants.COMPANY, false, constants.LOGIN_SUCCESS);

				return login;
			}
		}
		return login;
	}

	public void viewCompanyList() {

		if (companyList.size() == 0) {
			System.out.println("No companies in the List..");
			return;
		}

		Iterator<Company> itr = companyList.iterator();
		while (itr.hasNext()) {
			Company company = itr.next();
			System.out.println("companyId:" + company.getCompanyId() + "\tcompanyName:" + company.getCompanyName()
					+ "\tserviceTypeId:" + company.getCompanyServiceTypeId() + "\tBookingCharges:"
					+ company.getBookingCharges());
		}
	}

	public void removeCompanyId(int companyId) {
		if (companyList.size() == 0) {
			System.out.println("No Companies in the List..");
			return;
		}

		Iterator<Company> itr = companyList.iterator();
		while (itr.hasNext()) {
			Company obj = itr.next();
			if (obj.getCompanyId() == companyId) {

				System.out.println("compId:" + obj.getCompanyId() + "\tcompName:" + obj.getCompanyName());
				System.out.println("Before-->" + companyList.size());
				companyList.remove(obj);
				System.out.println("After-->" + companyList.size());

				break;
			}
		}
	}

	public Company getCompanyFromId(int companyId) {

		Company company = new Company();

		if (companyList.size() == 0) {
			System.out.println("No Companies in the List..");
			return company;
		}

		Iterator<Company> itr = companyList.iterator();

		while (itr.hasNext()) {
			company = itr.next();
			if (company.getCompanyId() == companyId) {
				return company;
			}
		}
		return company;

	}

	// public Company getBusCompanyFromBusList(int companyId) {
	//
	// Company company = new Company();
	//
	// if (busOfferedCompaniesList.size() == 0) {
	// System.out.println("No Companies in the List..");
	// return company;
	// }
	//
	// Iterator<Company> itr = busOfferedCompaniesList.iterator();
	//
	// while (itr.hasNext()) {
	// company = itr.next();
	// if (company.getCompanyId() == companyId) {
	// return company;
	// }
	// }
	// return company;
	// }

	// public Company getFlightCompanyFromFlightList(int companyId) {
	//
	// Company company = new Company();
	//
	// if (flightOfferedCompaniesList.size() == 0) {
	// System.out.println("No Companies in the List..");
	// return company;
	// }
	//
	// Iterator<Company> itr = flightOfferedCompaniesList.iterator();
	//
	// while (itr.hasNext()) {
	// company = itr.next();
	// if (company.getCompanyId() == companyId) {
	// return company;
	// }
	// }
	// return company;
	// }

	// public Company getTrainCompanyFromTrainList(int companyId) {
	//
	// Company company = new Company();
	//
	// if (trainOfferedCompaniesList.size() == 0) {
	// System.out.println("No Companies in the List..");
	// return company;
	// }
	//
	// Iterator<Company> itr = trainOfferedCompaniesList.iterator();
	//
	// while (itr.hasNext()) {
	// company = itr.next();
	// if (company.getCompanyId() == companyId) {
	// return company;
	// }
	// }
	// return company;
	// }

	public void updateBookingCharges(int companyId, int bookingCharges) {
		Company company = getCompanyFromId(companyId);

		System.out.println("Before==>" + company.getBookingCharges());
		company.setBookingCharges(bookingCharges);
		System.out.println("After==>" + company.getBookingCharges());
		System.out.println("Updated Successfully.");
	}

	public void updateOfferCost(int companyId, int offerCost) {
		Company company = getCompanyFromId(companyId);

		System.out.println("Before==>" + company.getOfferCost());
		company.setOfferCost(offerCost);
		System.out.println("After==>" + company.getOfferCost());
		System.out.println("Updated Successfully.");
	}

	// ==============================User Related==============================

	// User Login
	public Login userLogin(int userId) {

		User obj = new User();
		login.setLoginStatus(constants.LOGIN_FAILURE);
		Iterator<User> itr = userList.iterator();

		if (userList.size() == 0) {
			System.out.println("userList is empty..");
			return login;
		}

		while (itr.hasNext()) {
			obj = itr.next();

			if (obj.getUserId() == userId) {

				System.out.println(obj.getUserId());

				login = new Login(obj.getUserId(), false, false, constants.USER, constants.LOGIN_SUCCESS);

				return login;
			}
		}
		return login;
	}

	public void viewUserList() {

		if (userList.size() == 0) {
			System.out.println("No Users in the List..");
			return;
		}

		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			User obj = itr.next();
			System.out.println("userId:" + obj.getUserId() + "\tuserName:" + obj.getUserName() + "\tuserEmail:"
					+ obj.getUserEmail());
		}
	}

	public void registerUser() {

		try {
			userCounterId += 1;

			System.out.println("enter userName:");
			String userName = sc.next();
			System.out.println("email:");
			String userEmail = sc.next();

			User user = new User();

			user.setUserId(userCounterId);
			user.setUserName(userName);
			user.setUserEmail(userEmail);

			userList.add(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void removeUserId(int userId) {
		if (userList.size() == 0) {
			System.out.println("No Users in the List..");
			return;
		}

		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			User obj = itr.next();
			if (obj.getUserId() == userId) {

				System.out.println("userId:" + obj.getUserId() + "\tuserName:" + obj.getUserName() + "\tuserEmail:"
						+ obj.getUserEmail());
				System.out.println("Before-->" + userList.size());
				userList.remove(obj);
				System.out.println("After-->" + userList.size());

				break;
			}
		}
	}

	public void updateUser() {

	}

	public User getUserFromId(int userId) {

		User user = new User();

		if (userList.size() == 0) {
			System.out.println("No users in the List..");
			return user;
		}

		Iterator<User> itr = userList.iterator();
		while (itr.hasNext()) {
			user = itr.next();
			if (user.getUserId() == userId) {
				System.out.println("userId:" + user.getUserId() + "\tuserName:" + user.getUserName() + "\tuserEmail:"
						+ user.getUserEmail());
				break;
			}
		}

		return user;

	}
	// =======================Bus Service Related=======================

	public void viewBusList() {

		if (busList.size() == 0) {
			System.out.println("No buses in the List..");
			return;
		}

		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			Bus obj = itr.next();
			System.out.println("busId:" + obj.getVehicleId() + "\tbusName:" + obj.getBusName() + "\tseatsAvailable:"
					+ obj.getSeatsAvailable() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());
		}
	}

	public void viewBusCompanies() {
		Company company = new Company();
		if (companyList.size() == 0) {
			System.out.println("No Companies in the List..");
			return;
		}

		Iterator<Company> itr = companyList.iterator();
		boolean present = false;
		while (itr.hasNext()) {
			company = itr.next();
			System.out.println("-->");
			if (company.getCompanyServiceTypeId() == constants.BUS_SERVICE_ID) {
				System.out.println("==>");

				System.out.println("companyId:" + company.getCompanyId() + "  companyName:" + company.getCompanyName()
						+ " #buses:" + company.getOwnedBusList().size() + "  serviceTypeId:"
						+ company.getCompanyServiceTypeId());
				present = true;
			}
		}
		if (!present) {
			System.out.println("No Bus companies in List.");
		}
	}

	public void viewBusListOfCompany(int companyId) {

		if (presenceOfService(companyId, constants.BUS_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company comp = getCompanyFromId(companyId);
		if (comp.getOwnedBusList().size() == 0) {
			System.out.println("No Buses in the List..");
			return;
		}

		Bus bus = new Bus();

		Iterator<Bus> itr = comp.getOwnedBusList().iterator();
		while (itr.hasNext()) {
			bus = itr.next();
			System.out.println("busId:" + bus.getVehicleId() + "  Fare:" + bus.getSeatCost() + "  Seats:"
					+ bus.getSeatsCount() + "  AvailableSeats:" + bus.getSeatsAvailable() + "  source:"
					+ bus.getSourceStation() + "  destination:" + bus.getDestinationStation());
		}

	}

	public Bus getBusFromId(int companyId, int busId) {

		Company company = getCompanyFromId(companyId);

		Bus bus = new Bus();

		if (busList.size() == 0) {
			System.out.println("No Buses in the List..");
			return bus;
		}

		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			bus = itr.next();
			if (bus.getVehicleId() == busId) {
				System.out.println("vehicleId:" + bus.getVehicleId() + "\tvehicleName:" + bus.getBusName());
				break;
			}
		}

		return bus;
	}

	public Bus getBusFromCompanyWithBusId(int companyId, int busId) {

		Company company = getCompanyFromId(companyId);

		Bus bus = new Bus();

		if (company.getOwnedBusList().size() == 0) {
			System.out.println("No Buses in the List..");
			return bus;
		}

		Iterator<Bus> itr = company.getOwnedBusList().iterator();
		while (itr.hasNext()) {
			bus = itr.next();
			if (bus.getVehicleId() == busId) {
				System.out.println("vehicleId:" + bus.getVehicleId() + "\tvehicleName:" + bus.getBusName());
				break;
			}
		}

		return bus;
	}

	// =======================Flight Service Related=======================
	public void viewFlightList() {

		if (flightList.size() == 0) {
			System.out.println("No flight in the List..");
			return;
		}

		Iterator<Flight> itr = flightList.iterator();
		while (itr.hasNext()) {
			Flight obj = itr.next();
			System.out.println(
					"flightId:" + obj.getVehicleId() + "\tflightName:" + obj.getFlightName() + "\tseatsAvailable:"
							+ obj.getSeatsAvailable() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());
		}
	}

	public void viewFlightCompanies() {
		Company company = new Company();
		if (companyList.size() == 0) {
			System.out.println("No Companies in the List..");
			return;
		}

		Iterator<Company> itr = companyList.iterator();
		boolean present = false;
		while (itr.hasNext()) {
			company = itr.next();
			System.out.println("-->");
			if (company.getCompanyServiceTypeId() == constants.FLIGHT_SERVICE_ID) {
				System.out.println("==>");

				System.out.println("companyId:" + company.getCompanyId() + "  companyName:" + company.getCompanyName()
						+ " #flight:" + company.getOwnedFlightList().size() + "  serviceTypeId:"
						+ company.getCompanyServiceTypeId());
				present = true;
			}
		}
		if (!present) {
			System.out.println("No Flight companies in List.");
		}
	}

	public void viewFlightListOfCompany(int companyId) {

		if (presenceOfService(companyId, constants.FLIGHT_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company comp = getCompanyFromId(companyId);

		if (comp.getOwnedFlightList().size() == 0) {
			System.out.println("No Flights in the List..");
			return;
		}

		Flight flight = new Flight();
		Iterator<Flight> itr = comp.getOwnedFlightList().iterator();
		while (itr.hasNext()) {
			flight = itr.next();
			System.out.println("vehicleId:" + flight.getVehicleId() + "  vehicleName:" + flight.getFlightName()
					+ "  Fare:" + flight.getSeatCost() + "  Seats:" + flight.getSeatsCount() + "  ownedByCompanyId:"
					+ flight.getOwnedByCompanyId());
		}

	}

	public Flight getFlightFromId(int flightId) {

		Flight flight = new Flight();

		if (flightList.size() == 0) {
			System.out.println("No flights in the List..");
			return flight;
		}

		Iterator<Flight> itr = flightList.iterator();
		while (itr.hasNext()) {
			flight = itr.next();
			if (flight.getVehicleId() == flightId) {
				System.out.println("vehicleId:" + flight.getVehicleId() + "\tvehicleName:" + flight.getFlightName());
				break;
			}
		}

		return flight;

	}

	public Flight getFlightFromCompanyWithFlightId(int companyId, int flightId) {

		Company company = getCompanyFromId(companyId);

		Flight flight = new Flight();

		if (company.getOwnedFlightList().size() == 0) {
			System.out.println("No Flights in the List..");
			return flight;
		}

		Iterator<Flight> itr = company.getOwnedFlightList().iterator();
		while (itr.hasNext()) {
			flight = itr.next();
			if (flight.getVehicleId() == flightId) {
				System.out.println("vehicleId:" + flight.getVehicleId() + "\tvehicleName:" + flight.getFlightName());
				break;
			}
		}

		return flight;
	}

	// =======================Train Service Related=======================
	public void viewTrainList() {

		if (trainList.size() == 0) {
			System.out.println("No trains in the List..");
			return;
		}

		Iterator<Train> itr = trainList.iterator();
		while (itr.hasNext()) {
			Train obj = itr.next();
			System.out
					.println("trainId:" + obj.getVehicleId() + "\ttrainName:" + obj.getTrainName() + "\tseatsAvailable:"
							+ obj.getSeatsAvailable() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());
		}

	}

	public void viewTrainCompanies() {
		Company company = new Company();
		if (companyList.size() == 0) {
			System.out.println("No Companies in the List..");
			return;
		}

		Iterator<Company> itr = companyList.iterator();
		boolean present = false;
		while (itr.hasNext()) {
			company = itr.next();
			if (company.getCompanyServiceTypeId() == constants.TRAIN_SERVICE_ID) {

				System.out.println("companyId:" + company.getCompanyId() + "  companyName:" + company.getCompanyName()
						+ " #trains:" + company.getOwnedTrainList().size() + "  serviceTypeId:"
						+ company.getCompanyServiceTypeId());
				present = true;
			}
		}
		if (!present) {
			System.out.println("No Train Companies in List.");
		}
	}

	public void viewTrainListOfCompany(int companyId) {

		if (presenceOfService(companyId, constants.TRAIN_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company comp = getCompanyFromId(companyId);

		if (comp.getOwnedTrainList().size() == 0) {
			System.out.println("No Trains in the List..");
			return;
		}

		Train train = new Train();
		Iterator<Train> itr = comp.getOwnedTrainList().iterator();
		while (itr.hasNext()) {
			train = itr.next();
			System.out.println("vehicleId:" + train.getVehicleId() + " vehicleName:" + train.getTrainName() + " Fare:"
					+ train.getSeatCost() + " Seats:" + train.getSeatsCount() + "  ownedByCompanyId:"
					+ train.getOwnedByCompanyId());
		}

	}

	public Train getTrainFromId(int trainId) {

		Train train = new Train();

		if (trainList.size() == 0) {
			System.out.println("No trains in the List..");
			return train;
		}

		Iterator<Train> itr = trainList.iterator();
		while (itr.hasNext()) {
			train = itr.next();
			if (train.getVehicleId() == trainId) {
				System.out.println("vehicleId:" + train.getVehicleId() + "\tvehicleName:" + train.getTrainName());
				break;
			}
		}

		return train;

	}

	public Train getTrainFromCompanyWithTrainId(int companyId, int trainId) {

		Company company = getCompanyFromId(companyId);

		Train train = new Train();

		if (company.getOwnedTrainList().size() == 0) {
			System.out.println("No Trains in the List..");
			return train;
		}

		Iterator<Train> itr = company.getOwnedTrainList().iterator();
		while (itr.hasNext()) {
			train = itr.next();
			if (train.getVehicleId() == trainId) {
				System.out.println("vehicleId:" + train.getVehicleId() + "\tvehicleName:" + train.getTrainName());
				break;
			}
		}

		return train;
	}
	// ---------------------------------------------------------------------------------------------------------------------------

	// =======================Adding=======================

	public void HardAddBusToCompany(int companyId) {

		if (presenceOfService(companyId, constants.BUS_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company company = getCompanyFromId(companyId);

		for (int i = 0; i < 3; i++) {
			Bus bus = new Bus();

			String busName = "B" + i;
			String busType = "BT" + i;
			int seatsCount = 100;
			int seatCost = 50;
			String sourceStation = "b" + i;
			String destinationStation = "b" + (i + 1);

			busCounterId++;

			bus.setVehicleId(busCounterId);
			bus.setBusName(busName);
			bus.setBusType(busType);
			bus.setSeatsCount(seatsCount);
			bus.setSeatCost(seatCost);
			bus.setOwnedByCompanyId(companyId);
			bus.setSeatsAvailable(seatsCount);
			bus.setOfferCost(0);
			bus.setVehicleServiceTypeId(constants.BUS_SERVICE_ID);
			bus.setSourceStation(sourceStation);
			bus.setDestinationStation(destinationStation);

			company.getOwnedBusList().add(bus);
			busList.add(bus);
		}

		viewBusListOfCompany(companyId);
	}

	public void addBusToCompany(int companyId) {

		try {
			if (presenceOfService(companyId, constants.BUS_SERVICE_ID)) {
				System.out.println("Service Offered by Company.");
			} else {
				System.out.println("Service Not Offered by Company.");
				return;
			}

			Company company = getCompanyFromId(companyId);

			Bus bus = new Bus();
			System.out.println("enter Bus Name:");
			String busName = sc.next();

			System.out.println("enter Bus Type:");
			String busType = sc.next();

			System.out.println("enter No.of Seats:");
			int seatsCount = sc.nextInt();

			System.out.println("Seat Cost:");
			int seatCost = sc.nextInt();

			System.out.println("Enter Source:");
			String sourceStation = sc.next();
			System.out.println("Enter Destination:");
			String destinationStation = sc.next();

			busCounterId++;
			bus.setVehicleId(busCounterId);
			bus.setBusName(busName);
			bus.setBusType(busType);
			bus.setSeatsCount(seatsCount);
			bus.setSeatCost(seatCost);
			bus.setOwnedByCompanyId(companyId);
			bus.setSeatsAvailable(seatsCount);
			bus.setOfferCost(0);
			bus.setVehicleServiceTypeId(constants.BUS_SERVICE_ID);
			bus.setSourceStation(sourceStation);
			bus.setDestinationStation(destinationStation);

			company.getOwnedBusList().add(bus);
			busList.add(bus);

			System.out.println("Successfully Added Bus to List..");
			viewBusListOfCompany(companyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void HardAddFlightToCompany(int companyId) {

		if (presenceOfService(companyId, constants.FLIGHT_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company company = getCompanyFromId(companyId);

		for (int i = 0; i < 3; i++) {
			Flight flight = new Flight();

			String flightName = "F" + i;
			String flightType = "FT" + i;
			int seatsCount = 100;
			int seatCost = 200;
			String sourceStation = "f" + i;
			String destinationStation = "f" + (i + 1);

			flightCounterId++;

			flight.setVehicleId(flightCounterId);
			flight.setFlightName(flightName);
			flight.setFlightType(flightType);
			flight.setSeatsCount(seatsCount);
			flight.setSeatCost(seatCost);
			flight.setOwnedByCompanyId(companyId);
			flight.setSeatsAvailable(seatsCount);
			flight.setOfferCost(0);
			flight.setVehicleServiceTypeId(constants.FLIGHT_SERVICE_ID);
			flight.setSourceStation(sourceStation);
			flight.setDestinationStation(destinationStation);

			company.getOwnedFlightList().add(flight);
			flightList.add(flight);
		}

		viewFlightListOfCompany(companyId);
	}

	public void addFlightToCompany(int companyId) {

		try {
			if (presenceOfService(companyId, constants.FLIGHT_SERVICE_ID)) {
				System.out.println("Service Offered by Company.");
			} else {
				System.out.println("Service Not Offered by Company.");
				return;
			}

			Company company = getCompanyFromId(companyId);

			Flight flight = new Flight();
			System.out.println("enter Flight Name:");
			String busName = sc.next();

			System.out.println("enter Flight Type:");
			String busType = sc.next();

			System.out.println("enter No.of Seats:");
			int seatsCount = sc.nextInt();

			System.out.println("Seat Cost:");
			int seatCost = sc.nextInt();

			System.out.println("Enter Source:");
			String sourceStation = sc.next();

			System.out.println("Enter Destination:");
			String destinationStation = sc.next();

			flightCounterId++;
			flight.setVehicleId(flightCounterId);
			flight.setFlightName(busName);
			flight.setFlightType(busType);
			flight.setSeatsCount(seatsCount);
			flight.setSeatCost(seatCost);
			flight.setOwnedByCompanyId(companyId);
			flight.setSeatsAvailable(seatsCount);
			flight.setOfferCost(0);
			flight.setVehicleServiceTypeId(constants.FLIGHT_SERVICE_ID);
			flight.setSourceStation(sourceStation);
			flight.setDestinationStation(destinationStation);

			company.getOwnedFlightList().add(flight);
			flightList.add(flight);

			System.out.println("Successfully Added Flight to List..");
			viewFlightListOfCompany(companyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void HardAddTrainToCompany(int companyId) {

		if (presenceOfService(companyId, constants.TRAIN_SERVICE_ID)) {
			System.out.println("Service Offered by Company.");
		} else {
			System.out.println("Service Not Offered by Company.");
			return;
		}

		Company company = getCompanyFromId(companyId);

		for (int i = 0; i < 3; i++) {
			Train train = new Train();

			String trainName = "T" + i;
			String trainType = "TT" + i;
			int seatsCount = 1000;
			int seatCost = 10;
			String sourceStation = "t" + i;
			String destinationStation = "t" + (i + 1);

			trainCounterId++;

			train.setVehicleId(trainCounterId);
			train.setTrainName(trainName);
			train.setTrainType(trainType);
			train.setSeatsCount(seatsCount);
			train.setSeatCost(seatCost);
			train.setOwnedByCompanyId(companyId);
			train.setSeatsAvailable(seatsCount);
			train.setOfferCost(0);
			train.setVehicleServiceTypeId(constants.TRAIN_SERVICE_ID);
			train.setSourceStation(sourceStation);
			train.setDestinationStation(destinationStation);

			company.getOwnedTrainList().add(train);
			trainList.add(train);
		}

		viewTrainListOfCompany(companyId);
	}

	public void addTrainToCompany(int companyId) {

		try {
			if (presenceOfService(companyId, constants.TRAIN_SERVICE_ID)) {
				System.out.println("Service Offered by Company.");
			} else {
				System.out.println("Service Not Offered by Company.");
				return;
			}

			Company company = getCompanyFromId(companyId);

			Train train = new Train();
			System.out.println("enter Train Name:");
			String trainName = sc.next();

			System.out.println("enter Train Type:");
			String trainType = sc.next();

			System.out.println("enter No.of Seats:");
			int seatsCount = sc.nextInt();

			System.out.println("Seat Cost:");
			int seatCost = sc.nextInt();

			System.out.println("Enter Source:");
			String sourceStation = sc.next();

			System.out.println("Enter Destination:");
			String destinationStation = sc.next();

			trainCounterId++;
			train.setVehicleId(trainCounterId);
			train.setTrainName(trainName);
			train.setTrainType(trainType);
			train.setSeatsCount(seatsCount);
			train.setSeatCost(seatCost);
			train.setOwnedByCompanyId(companyId);
			train.setSeatsAvailable(seatsCount);
			train.setOfferCost(0);
			train.setVehicleServiceTypeId(constants.TRAIN_SERVICE_ID);
			train.setSourceStation(sourceStation);
			train.setDestinationStation(destinationStation);

			company.getOwnedTrainList().add(train);
			trainList.add(train);

			System.out.println("Successfully Added Train to List..");
			viewTrainListOfCompany(companyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// =======================Removing=======================
	public void removeBusFromCompany(int companyId) {

	}

	public void removeFlightFromCompany(int companyId) {

	}

	public void removeCarFromCompany(int companyId) {

	}

	public void removeTrainFromCompany(int companyId) {

	}

	// ----------------------------------------------------------------------------------------------------------------
	public void viewServicesOfCompany(int companyId) {
		Company company = getCompanyFromId(companyId);

		System.out.println();
		System.out.println("-------Company Services-------");
		if (company.getCompanyServiceList().size() == 0) {
			System.out.println("No Services offered by Company.");
			return;
		}
		Service service = new Service();
		Iterator<Service> itr = company.getCompanyServiceList().iterator();
		while (itr.hasNext()) {
			service = itr.next();
			System.out.println("serviceId:" + service.getServiceId() + "\tserviceName:" + service.getServiceName());
		}
	}

	public void printServices() {

		System.out.println("------------------Supported Services------------------");
		Service service = new Service();
		Iterator<Service> itr = availableServices.iterator();
		while (itr.hasNext()) {
			service = itr.next();
			System.out.println("serviceId:" + service.getServiceId() + "\tserviceName:" + service.getServiceName());
		}
	}

	public void HardAddServiceByAdmin() {

		Service service = new Service(constants.BUS_SERVICE_ID, constants.SERVICE_NAME_BUS);
		availableServices.add(service);

		service = new Service(constants.FLIGHT_SERVICE_ID, constants.SERVICE_NAME_FLIGHT);
		availableServices.add(service);

		service = new Service(constants.TRAIN_SERVICE_ID, constants.SERVICE_NAME_TRAIN);
		availableServices.add(service);

		printServices();

	}

	// public void addServiceToCompany(int companyId) {
	//
	// Company company = getCompanyFromId(companyId);
	//
	// if (availableServices.size() == 0) {
	// System.out.println("No available Services.Please Consult Admin.");
	// return;
	// }
	//
	// printServices();
	//
	// System.out.println("enter Service Id:");
	// int serviceId = sc.nextInt();
	//
	// Service service = new Service();
	// Iterator<Service> itr = availableServices.iterator();
	// boolean serviceCheck = false;
	// while (itr.hasNext()) {
	// service = itr.next();
	// if (service.getServiceId() == serviceId) {
	// System.out.println("serviceId:" + service.getServiceId() + "\tserviceName:" +
	// service.getServiceName());
	// serviceCheck = true;
	// break;
	// }
	// }
	// if (serviceCheck) {
	// company.setCompanyServiceCount(company.getCompanyServiceCount() + 1);
	//
	// company.getCompanyServiceList().add(service);
	//
	// if (serviceId == constants.BUS_SERVICE_ID) {
	// busOfferedCompaniesId.add(companyId);
	// }
	// if (serviceId == constants.FLIGHT_SERVICE_ID) {
	// flightOfferedCompaniesId.add(companyId);
	// }
	// if (serviceId == constants.TRAIN_SERVICE_ID) {
	// trainOfferedCompaniesId.add(companyId);
	// }
	//
	// System.out.println("Added Successfully..");
	// } else {
	// System.out.println("failed..");
	// }
	// }

	public void removeServiceFromCompany(int companyId) {
		try {
			Company company = getCompanyFromId(companyId);

			if (company.getCompanyServiceList().size() == 0) {
				System.out.println("Service List is empty..");
			} else {
				System.out.println("enter Service Id:");
				int serviceId = sc.nextInt();

				Service service = new Service();
				Iterator<Service> itr = company.getCompanyServiceList().iterator();
				while (itr.hasNext()) {
					service = itr.next();
					if (service.getServiceId() == serviceId) {

						System.out.println("Before--->" + company.getCompanyServiceList().size());
						System.out.println(
								"serviceId:" + service.getServiceId() + "\tserviceName:" + service.getServiceName());
						company.getCompanyServiceList().remove(service);
						System.out.println("After--->" + company.getCompanyServiceList().size());
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean presenceOfService(int companyId, int serviceTypeId) {
		Company comp = getCompanyFromId(companyId);

		boolean present = false;
		// Iterator<Service> itr = comp.getCompanyServiceList().iterator();
		// Service service = new Service();
		// while (itr.hasNext()) {
		// service = itr.next();
		//
		// if (serviceTypeId == constants.TRAIN_SERVICE_ID
		// && comp.getCompanyName().equals(constants.SERVICE_TRAIN_IRCTC)
		// && service.getServiceName().equals(constants.SERVICE_NAME_TRAIN)
		// && service.getServiceId() == serviceTypeId) {
		//
		// present = true;
		// return present;
		// }
		// if (service.getServiceId() == serviceTypeId) {
		// present = true;
		// return present;
		// }
		// }

		if (comp.getCompanyServiceTypeId() == serviceTypeId) {

			present = true;
		}
		return present;

	}

	// =============================Searching=============================

	public ArrayList<Bus> searchBus(String source, String destination) {

		ArrayList<Bus> buses = new ArrayList<>();

		if (busList.size() == 0) {
			System.out.println("No buses in the List..");
			return buses;
		}

		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			Bus obj = itr.next();

			if (obj.getSourceStation().equals(source) && obj.getDestinationStation().equals(destination)) {

				System.out.println("busId:" + obj.getVehicleId() + "\tbusName:" + obj.getBusName()
						+ "\townedByCompanyId:" + obj.getOwnedByCompanyId() + " source:" + obj.getSourceStation()
						+ " destination:" + obj.getDestinationStation() + " availableSeats:" + obj.getSeatsAvailable()
						+ " seatCost:" + obj.getSeatCost());

				// System.out.println("busId:" + obj.getVehicleId() + "\tbusName:" +
				// obj.getBusName() + "\tbusType:"
				// + obj.getBusType() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());

				buses.add(obj);
			}
		}

		return buses;
	}

	public ArrayList<Flight> searchFlight(String source, String destination) {

		ArrayList<Flight> flights = new ArrayList<>();

		if (flightList.size() == 0) {
			System.out.println("No flights in the List..");
			return flights;
		}

		Iterator<Flight> itr = flightList.iterator();
		while (itr.hasNext()) {
			Flight obj = itr.next();
			if (obj.getSourceStation().equals(source) && obj.getDestinationStation().equals(destination)) {

				System.out.println(
						"flightId:" + obj.getVehicleId() + "\tflightName:" + obj.getFlightName() + "\tseatsAvailable:"
								+ obj.getSeatsAvailable() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());

				flights.add(obj);
			}
		}

		return flights;
	}

	public ArrayList<Train> searchTrain(String source, String destination) {

		ArrayList<Train> trains = new ArrayList<>();

		if (trainList.size() == 0) {
			System.out.println("No trains in the List..");
			return trains;
		}

		Iterator<Train> itr = trainList.iterator();
		while (itr.hasNext()) {
			Train obj = itr.next();

			if (obj.getSourceStation().equals(source) && obj.getDestinationStation().equals(destination)) {

				System.out.println(
						"trainId:" + obj.getVehicleId() + "\ttrainName:" + obj.getTrainName() + "\tseatsAvailable:"
								+ obj.getSeatsAvailable() + "\townedByCompanyId:" + obj.getOwnedByCompanyId());

				trains.add(obj);
			}
		}

		return trains;
	}
	// =============================Displaying Search
	// List=============================

	public void displaySearchedBuses(ArrayList<Bus> buses) {

		if (buses.size() == 0) {
			System.out.println("No Buses in this search.");
			return;
		}

		Iterator<Bus> itr = buses.iterator();
		while (itr.hasNext()) {
			Bus obj = itr.next();
			System.out.println("ownedByCompanyId:" + obj.getOwnedByCompanyId() + "\tbusId:" + obj.getVehicleId()
					+ "\tbusName:" + obj.getBusName() + "\tseatsAvailable:" + obj.getSeatsAvailable() + "\tseatCost:"
					+ obj.getSeatCost());
		}

	}

	public void displaySearchedFlights(ArrayList<Flight> flights) {

		if (flights.size() == 0) {
			System.out.println("No Flights in this search.");
			return;
		}

		Iterator<Flight> itr = flights.iterator();
		while (itr.hasNext()) {
			Flight obj = itr.next();
			System.out.println("ownedByCompanyId:" + obj.getOwnedByCompanyId() + "\tflightId:" + obj.getVehicleId()
					+ "\tflightName:" + obj.getFlightName() + "\tseatsAvailable:" + obj.getSeatsAvailable()
					+ "\tseatCost:" + obj.getSeatCost());
		}

	}

	public void displaySearchedTrains(ArrayList<Train> trains) {

		if (trains.size() == 0) {
			System.out.println("No trains in this search.");
			return;
		}

		Iterator<Train> itr = trains.iterator();
		while (itr.hasNext()) {
			Train obj = itr.next();

			System.out.println("ownedByCompanyId:" + obj.getOwnedByCompanyId() + "\ttrainId:" + obj.getVehicleId()
					+ "\ttrainName:" + obj.getTrainName() + "\tseatsAvailable:" + obj.getSeatsAvailable()
					+ "\tseatCost:" + obj.getSeatCost());
		}
	}

	// =============================Booking Tickets=============================

	public void viewHistory(int userId) {
		User user = getUserFromId(userId);

		if (user.getTripHistory().size() == 0) {
			System.out.println("No Reserved Tickets in the History..");
			return;
		}

		Iterator<Trip> itr = user.getTripHistory().iterator();
		Trip trip = new Trip();
		while (itr.hasNext()) {
			trip = itr.next();
			System.out.println("tripId:" + trip.getTripId() + "  #Tickets:" + trip.getTicketsCount() + "  cost:"
					+ trip.getTripCost() + "  service:" + trip.getVehicleServiceType() + "  journeyDate:"
					+ trip.getJourneyDate());
		}
	}

	public void bookBusTickets(int userId) {

		try {
			viewBusCompanies();

			if (companyList.size() == 0) {
				return;
			}
			if (busList.size() == 0) {
				System.out.println("No Buses in the list.");
				return;
			}
			User user = getUserFromId(userId);

			System.out.println("enter sourceStation:");
			String source = sc.next();
			System.out.println("enter destinationStation:");
			String destination = sc.next();

			ArrayList<Bus> searchedBuses = searchBus(source, destination);
			if (searchedBuses.size() == 0) {
				System.out.println("No Buses for this search.");
				return;
			}

			displaySearchedBuses(searchedBuses);

			// viewBusCompanies();

			System.out.println("Enter CompanyId:");
			int companyId = sc.nextInt();

			Company company = getCompanyFromId(companyId);

			viewBusListOfCompany(companyId);

			System.out.println("enter busId:");
			int busId = sc.nextInt();
			Bus bus = getBusFromCompanyWithBusId(companyId, busId);

			if (bus == null) {
				System.out.println("No Bus");
				return;
			}

			System.out.println("enter no.of tickets:");
			int ticketsCount = sc.nextInt();

			if (ticketsCount <= bus.getSeatsAvailable()) {

				Date reservationDate = new Date();
				Date journeyDate = new Date();

				Trip journey = new Trip();
				tripCounterId++;

				journey.setTripId(tripCounterId);
				journey.setSource(bus.getSourceStation());
				journey.setDestination(bus.getDestinationStation());
				journey.setTicketsCount(ticketsCount);
				journey.setVehicleServiceType(company.getCompanyServiceTypeId());

				System.out.println("ticketsCost:" + (ticketsCount * bus.getSeatCost()));
				System.out.println("Booking Charges:" + company.getBookingCharges());
				System.out.println("Offer:" + company.getOfferCost());
				int totalCost = (bus.getSeatCost() * ticketsCount) + company.getBookingCharges()
						- company.getOfferCost();
				journey.setTripCost(totalCost);

				journey.setBookedDate(new Date());
				journey.setJourneyDate(new Date());
				journey.setCompanyId(companyId);
				journey.setVehicleId(bus.getVehicleId());

				System.out.println("\nTickets Cost:" + totalCost);
				System.out.println("\n1.proceed booking\n2.cancel booking");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:

					bus.setSeatsAvailable(bus.getSeatsAvailable() - ticketsCount);
					bus.setSeatsFilled(bus.getSeatsFilled() + ticketsCount);

					user.getCurrentTrips().add(journey);
					user.getTripHistory().add(journey);

					if (busList.size() == 0) {
						System.out.println("No buses in the List..");
						return;
					}

					Iterator<Bus> itr = busList.iterator();
					while (itr.hasNext()) {
						Bus obj = itr.next();
						if (obj.getVehicleId() == bus.getVehicleId()) {

							obj.setSeatsAvailable(bus.getSeatsAvailable());
							obj.setSeatsFilled(bus.getSeatsFilled());
							break;
						}
					}

					System.out.println("Reservation Successful.");
					viewHistory(userId);
					break;
				case 2:
					System.out.println("exiting..");
					break;
				default:
					System.out.println("invalid choice.");
					break;
				}

			} else {
				System.out.println("Seats are less..");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void bookFlightTickets(int userId) {

		try {
			viewFlightCompanies();
			if (companyList.size() == 0) {
				return;
			}
			if (flightList.size() == 0) {
				System.out.println("No Flights in the list.");
				return;
			}
			User user = getUserFromId(userId);

			System.out.println("enter sourceStation:");
			String source = sc.next();
			System.out.println("enter destinationStation:");
			String destination = sc.next();

			ArrayList<Flight> searchedFlights = searchFlight(source, destination);
			if (searchedFlights.size() == 0) {
				System.out.println("No Flights for this search.");
				return;
			}

			displaySearchedFlights(searchedFlights);

			// viewFlightCompanies();

			System.out.println("Enter CompanyId:");
			int companyId = sc.nextInt();

			Company company = getCompanyFromId(companyId);

			viewFlightListOfCompany(companyId);

			System.out.println("enter FlightId:");
			int flightId = sc.nextInt();

			Flight flight = getFlightFromCompanyWithFlightId(companyId, flightId);

			if (flight == null) {
				System.out.println("No Flights in the List.");
				return;
			}

			System.out.println("enter no.of tickets:");
			int ticketsCount = sc.nextInt();

			if (ticketsCount <= flight.getSeatsAvailable()) {

				Date reservationDate = new Date();
				Date journeyDate = new Date();

				Trip journey = new Trip();
				tripCounterId++;

				journey.setTripId(tripCounterId);
				journey.setSource(flight.getSourceStation());
				journey.setDestination(flight.getDestinationStation());
				journey.setTicketsCount(ticketsCount);
				journey.setVehicleServiceType(company.getCompanyServiceTypeId());

				System.out.println("ticketsCost:" + (ticketsCount * flight.getSeatCost()));
				System.out.println("Booking Charges:" + company.getBookingCharges());
				System.out.println("Offer:" + company.getOfferCost());
				int totalCost = (flight.getSeatCost() * ticketsCount) + company.getBookingCharges()
						- company.getOfferCost();
				journey.setTripCost(totalCost);

				journey.setBookedDate(new Date());
				journey.setJourneyDate(new Date());

				journey.setCompanyId(companyId);
				journey.setVehicleId(flight.getVehicleId());

				System.out.println("\nTickets Cost:" + totalCost);
				System.out.println("\n1.proceed booking\n2.cancel booking");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:

					flight.setSeatsAvailable(flight.getSeatsAvailable() - ticketsCount);
					flight.setSeatsFilled(flight.getSeatsFilled() + ticketsCount);

					user.getCurrentTrips().add(journey);
					user.getTripHistory().add(journey);

					if (flightList.size() == 0) {
						System.out.println("No flight in the List..");
						return;
					}

					Iterator<Flight> itr = flightList.iterator();
					while (itr.hasNext()) {
						Flight obj = itr.next();

						if (obj.getVehicleId() == flight.getVehicleId()) {

							obj.setSeatsAvailable(flight.getSeatsAvailable());
							obj.setSeatsFilled(flight.getSeatsFilled());
							break;
						}
					}
					System.out.println("Reservation Successful.");
					viewHistory(userId);

					break;
				case 2:
					System.out.println("exiting..");
					break;
				default:
					System.out.println("invalid choice.");
					break;
				}

			} else {
				System.out.println("Available Seats are less..");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void bookTrainTickets(int userId) {

		try {
			viewTrainCompanies();
			if (companyList.size() == 0) {
				return;
			}
			if (trainList.size() == 0) {
				System.out.println("No Trains in the List.");
				return;
			}

			User user = getUserFromId(userId);

			System.out.println("enter sourceStation:");
			String source = sc.next();
			System.out.println("enter destinationStation:");
			String destination = sc.next();

			ArrayList<Train> searchedTrains = searchTrain(source, destination);
			if (searchedTrains.size() == 0) {
				System.out.println("No Trains for this search.");
				return;
			}

			displaySearchedTrains(searchedTrains);

			// viewTrainCompanies();

			System.out.println("Enter CompanyId:");
			int companyId = sc.nextInt();

			Company company = getCompanyFromId(companyId);

			viewTrainListOfCompany(companyId);

			System.out.println("enter TrainId:");
			int trainId = sc.nextInt();

			Train train = getTrainFromCompanyWithTrainId(companyId, trainId);

			if (train == null) {
				System.out.println("in Null");
				System.out.println("No Trains in the List.");
				return;
			}

			System.out.println("enter no.of tickets:");
			int ticketsCount = sc.nextInt();

			if (ticketsCount <= train.getSeatsAvailable()) {

				Date reservationDate = new Date();
				Date journeyDate = new Date();

				Trip journey = new Trip();
				tripCounterId++;

				journey.setTripId(tripCounterId);
				journey.setSource(train.getSourceStation());
				journey.setDestination(train.getDestinationStation());
				journey.setTicketsCount(ticketsCount);
				journey.setVehicleServiceType(company.getCompanyServiceTypeId());

				System.out.println("ticketsCost:" + (ticketsCount * train.getSeatCost()));
				System.out.println("Booking Charges:" + company.getBookingCharges());
				System.out.println("Offer:" + company.getOfferCost());
				int totalCost = (train.getSeatCost() * ticketsCount) + company.getBookingCharges()
						- company.getOfferCost();
				journey.setTripCost(totalCost);

				journey.setBookedDate(new Date());
				journey.setJourneyDate(new Date());

				journey.setCompanyId(companyId);
				journey.setVehicleId(train.getVehicleId());

				System.out.println("\nTickets Cost:" + totalCost);
				System.out.println("\n1.proceed booking\n2.cancel booking");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:

					train.setSeatsAvailable(train.getSeatsAvailable() - ticketsCount);
					train.setSeatsFilled(train.getSeatsFilled() + ticketsCount);

					user.getCurrentTrips().add(journey);
					user.getTripHistory().add(journey);

					if (trainList.size() == 0) {
						System.out.println("No trains in the List..");
						return;
					}

					Iterator<Train> itr = trainList.iterator();

					while (itr.hasNext()) {
						Train obj = itr.next();
						if (obj.getVehicleId() == train.getVehicleId()) {

							obj.setSeatsAvailable(train.getSeatsAvailable());
							obj.setSeatsFilled(train.getSeatsFilled());
							System.out.println(obj.getSeatsAvailable() + "--->");
							break;
						}
					}

					System.out.println("Reservation Successful.");
					viewHistory(userId);

					break;
				case 2:
					System.out.println("exiting..");
					break;
				default:
					System.out.println("invalid choice.");
					break;
				}
			} else {
				System.out.println("Available Seats are less..");
				return;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewCurrentTicket() {

	}

	public void cancelTicket(int userId) {

		try {
			User user = getUserFromId(userId);

			if (user.getTripHistory().size() == 0) {
				System.out.println("No Reserved Tickets.");
				return;
			}
			viewHistory(userId);

			System.out.println("enter tripId:");
			int tripId = sc.nextInt();

			Iterator<Trip> itr = user.getTripHistory().iterator();
			Trip trip = new Trip();
			while (itr.hasNext()) {
				trip = itr.next();
				if (trip.getTripId() == tripId) {

					System.out.println("tripId:" + trip.getTripId() + "  #Tickets:" + trip.getTicketsCount() + "  cost:"
							+ trip.getTripCost() + "  service:" + trip.getVehicleServiceType() + "  journeyDate:"
							+ trip.getJourneyDate());

					int afterCancellation = 0;
					if (trip.getVehicleServiceType() == constants.FLIGHT_SERVICE_ID) {

						afterCancellation = trip.getTripCost() - cancellationCharges[0];

					} else if (trip.getVehicleServiceType() == constants.BUS_SERVICE_ID) {

						afterCancellation = trip.getTripCost() - cancellationCharges[1];
					} else if (trip.getVehicleServiceType() == constants.TRAIN_SERVICE_ID) {

						afterCancellation = trip.getTripCost() - cancellationCharges[2];
					}
					if (afterCancellation < 0) {
						afterCancellation = 0;
					}

					System.out.println("Refund amount After Cancellation:" + afterCancellation);
					System.out.println("1.proceed Cancel\n2.exit");
					int choice = sc.nextInt();

					switch (choice) {
					case 1:

						if (companyList.size() == 0) {
							System.out.println("No companies in the List..");
							return;
						}

						Iterator<Company> itr2 = companyList.iterator();
						while (itr2.hasNext()) {
							Company company = itr2.next();
							if (company.getCompanyId() == trip.getCompanyId()) {
								if (trip.getVehicleServiceType() == constants.FLIGHT_SERVICE_ID) {

									updateCancelledFlightInCompany(trip);
								} else if (trip.getVehicleServiceType() == constants.BUS_SERVICE_ID) {
									updateCancelledBusInCompany(trip);
								} else if (trip.getVehicleServiceType() == constants.TRAIN_SERVICE_ID) {

									updateCancelledTrainInCompany(trip);
								}
							}
						}

						// if (trip.getVehicleServiceType() == constants.FLIGHT_SERVICE_ID) {
						//
						// updateCancelledFlightInFlightList(trip);
						// } else if (trip.getVehicleServiceType() == constants.BUS_SERVICE_ID) {
						// updateCancelledBusInBusList(trip);
						// } else if (trip.getVehicleServiceType() == constants.TRAIN_SERVICE_ID) {
						//
						// searchTrain("v", "d");
						// updateCancelledTrainInTrainList(trip);
						// }

						user.getTripHistory().remove(trip);
						System.out.println("Cancelled Successfully.");
						break;
					case 2:
						System.out.println("exiting..");
						break;
					default:
						break;

					}
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCancelledBusInBusList(Trip trip) {
		if (busList.size() == 0) {
			System.out.println("No buses in the List..");
			return;
		}

		Iterator<Bus> itr = busList.iterator();
		while (itr.hasNext()) {
			Bus obj = itr.next();
			if (obj.getVehicleId() == trip.getVehicleId()) {
				obj.setSeatsAvailable(obj.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println("updated in busList");
				break;
			}
		}
	}

	public void updateCancelledFlightInFlightList(Trip trip) {
		if (flightList.size() == 0) {
			System.out.println("No flight in the List..");
			return;
		}

		Iterator<Flight> itr = flightList.iterator();
		while (itr.hasNext()) {
			Flight obj = itr.next();
			if (obj.getVehicleId() == trip.getVehicleId()) {
				obj.setSeatsAvailable(obj.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println("updated in flightList");
				break;
			}
		}
	}

	public void updateCancelledTrainInTrainList(Trip trip) {
		if (trainList.size() == 0) {
			System.out.println("No trains in the List..");
			return;
		}

		Iterator<Train> itr = trainList.iterator();
		while (itr.hasNext()) {
			Train obj = itr.next();
			if (obj.getVehicleId() == trip.getVehicleId()) {

				System.out.println("==>" + obj.getSeatsAvailable());
				obj.setSeatsAvailable(obj.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println("==>" + obj.getSeatsAvailable());
				System.out.println("updated in trainList");
				break;
			}
		}
	}

	public void updateCancelledFlightInCompany(Trip trip) {
		Company company = getCompanyFromId(trip.getCompanyId());

		Flight flight = new Flight();

		if (company.getOwnedFlightList().size() == 0) {
			System.out.println("No Flights in the List..");
			return;
		}

		Iterator<Flight> itr = company.getOwnedFlightList().iterator();
		while (itr.hasNext()) {
			flight = itr.next();
			if (flight.getVehicleId() == trip.getVehicleId()) {

				flight.setSeatsAvailable(flight.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println("updated in flight company");
				break;
			}
		}
	}

	public void updateCancelledBusInCompany(Trip trip) {
		Company company = getCompanyFromId(trip.getCompanyId());

		Bus bus = new Bus();

		if (company.getOwnedBusList().size() == 0) {
			System.out.println("No Buses in the List..");
			return;
		}

		Iterator<Bus> itr = company.getOwnedBusList().iterator();
		while (itr.hasNext()) {
			bus = itr.next();
			if (bus.getVehicleId() == trip.getCompanyId()) {
				bus.setSeatsAvailable(bus.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println("updated in bus company");
				break;
			}
		}

	}

	public void updateCancelledTrainInCompany(Trip trip) {
		Company company = getCompanyFromId(trip.getCompanyId());

		Train train = new Train();

		if (company.getOwnedTrainList().size() == 0) {
			System.out.println("No Trains in the List..");
			return;
		}

		Iterator<Train> itr = company.getOwnedTrainList().iterator();
		while (itr.hasNext()) {
			train = itr.next();
			if (train.getVehicleId() == trip.getVehicleId()) {

				System.out.println(">>>" + train.getSeatsAvailable());
				train.setSeatsAvailable(train.getSeatsAvailable() + trip.getTicketsCount());
				System.out.println(">>>" + train.getSeatsAvailable());
				System.out.println("updated in train company");
				break;
			}
		}
	}
}
