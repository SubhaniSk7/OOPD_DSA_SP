package DSA.Lab1;

import java.util.Scanner;

public class Lab1_MT18117 {

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);

		Shape circleObj = new Circle();
		Shape elcricObj = new Elcric();

		System.out.println("Enter String:");
		String str = sc.next();
		System.out.println(circleObj.draw(str));

		System.out.println(elcricObj.draw(str));

		circleObj.delete();
		elcricObj.delete();
	}
}
