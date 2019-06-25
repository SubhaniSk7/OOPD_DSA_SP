package DSA.Lab4;

import java.util.Scanner;

public class SumPairs {

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), k = sc.nextInt(), i;
		int[] a = new int[n];
		for (i = 0; i < n; i++)
			a[i] = sc.nextInt();

		// for (i = 0; i < n; i++)
		// System.out.print(a[i] + " ");
		// System.out.println();

		if (n % 2 == 0) {
			int sum = 0;
			for (i = 0; i < n; i++)
				sum += a[i] % k;
			System.out.println("sum:" + sum);
			if (sum % k == 0) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		} else {
			System.out.println("False");
		}
	}
}
