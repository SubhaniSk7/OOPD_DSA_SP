package DSA.Lab1;

public class Elcric extends Shape {

	double draw(String str) {

		int i;
		String rev = "";
		for (i = str.length() - 1; i >= 0; i--)
			rev = rev + str.charAt(i);
		rev = rev.substring(1, rev.length());

		System.out.println(rev);
		double l = rev.length();

		return l * l;
	}

}
