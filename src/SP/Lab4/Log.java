package SP.Lab4;
//	SUBHANI SHAIK

//	MT18117

public class Log extends Thread {

	PersonalInfo personalInfo = new PersonalInfo();
	FamilyInfo familyInfo = new FamilyInfo();

	public void writePersonalInfo(String name, int age, String gender, String city) {// Initializing Personal Info

		personalInfo.setName(name);
		personalInfo.setAge(age);
		personalInfo.setGender(gender);
		personalInfo.setCity(city);
	}

	public void writeFamilyInfo(String name, String fatherName, String motherName, String city) {// initializing Family
																									// info

		familyInfo.setName(name);
		familyInfo.setFatherName(fatherName);
		familyInfo.setMotherName(motherName);
		familyInfo.setCity(city);
	}

	public synchronized void printCompleteInfo(String threadName) {// printing info

		System.out
				.println("\n----------------------------------------------------------\nCalling Thread:" + threadName);
		System.out.println("---------------------------Info---------------------------");
		System.out.println("Personal Info\nName:" + personalInfo.getName() + "\nAge:" + personalInfo.getAge()
				+ "\nGender:" + personalInfo.getGender() + "\nCity:" + personalInfo.getCity()
				+ "\n----------------------------------------------------------");

		System.out.println("Family Info\nName:" + familyInfo.getName() + "\nFather's Name:" + familyInfo.getFatherName()
				+ "\nMother's Name:" + familyInfo.getMotherName() + "\nCity:" + familyInfo.getCity()
				+ "\n----------------------------------------------------------");
	}
}
