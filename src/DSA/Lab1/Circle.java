package DSA.Lab1;

public class Circle extends Shape {

	double draw(String str) {

		double diameter = str.length();
		double radius = diameter / 2;
		System.out.println(str);

		return 3.14 * radius * radius;
	}

	void delete() {
		System.out.println("Circle Deleted.");
	}

}
