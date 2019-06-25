package DSA.Lab2;

import java.util.Scanner;

public class Lab2_MT18117 {

	static int top = -1;
	static int[] operand;

	public static void main(String subhani[]) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] number = str.split(" ");
		operand = new int[str.length()];

		for (String i : number) {

			if (i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/")) {

				int num2 = pop();
				int num1 = pop();

				if (i.equals("+"))
					push(num1 + num2);
				else if (i.equals("-"))
					push(num1 - num2);
				else if (i.equals("*"))
					push(num1 * num2);
				else if (i.equals("/")) {
					try {
						if (num2 == 0) {
						}
						push(num1 / num2);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} else
				push(Integer.parseInt(i));

		}
		System.out.println(top());
	}

	public static void push(int digit) {
		if (top == -1)
			top++;
		operand[top++] = digit;
	}

	public static int top() {
		return operand[top - 1];
	}

	public static int pop() {
		int value = operand[top - 1];
		top--;
		return value;
	}
}
