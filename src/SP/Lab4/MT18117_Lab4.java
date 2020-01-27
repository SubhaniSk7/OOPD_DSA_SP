
//SUBHANI SHAIK

//MT18117
import java.util.Scanner;

public class MT18117_Lab4 {
	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);
		int age;
		String name, gender, city, fatherName, motherName;

		String str = sc.nextLine();

		String[] values = str.split(",");// spliting input and storing in 'values' array

		if (values.length != 6) {// when wrong number of input parameters are given then error message and exit
			System.out.println("Wrong no.of parameters.");
			System.exit(0);
		}

		name = values[0];
		age = Integer.parseInt(values[1]);
		gender = values[2];
		city = values[3];
		fatherName = values[4];
		motherName = values[5];

		Log log = new Log();

		// personal info Thread and writing personalInfo
		Thread personalThread = new Thread(() -> {
			log.writePersonalInfo(name, age, gender, city);
			log.printCompleteInfo("Personal Thread");
		});

		// family info Thread and writing familyInfo
		Thread familyThread = new Thread(() -> {
			log.writeFamilyInfo(name, fatherName, motherName, city);
			log.printCompleteInfo("Family Thread");
		});

		// Starting personalThread
		personalThread.start();

		// Starting familyThread
		familyThread.start();
	}
}

