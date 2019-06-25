package DSA.Lab4;

import java.util.Scanner;

public class SumPairs2 {

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), k = sc.nextInt(), i, pairs = 0;
		int[] a = new int[n];
		for (i = 0; i < n; i++)
			a[i] = sc.nextInt();
		for (i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		int max = -1;

		for (i = 0; i < n; i++)
			if (max < a[i])
				max = a[i];

		int[] c = new int[max + 1];
		int[] index = new int[max + 1];

		for (i = 0; i < n; i++)
			c[a[i]] += 1;

		index[0] = 0;
		for (i = 1; i < c.length; i++) {
			index[i] = c[i] + index[i - 1];
		}

		for (i = 0; i < c.length; i++)
			System.out.print(c[i] + " ");
		System.out.println();

		for (i = 1; i < c.length; i++) {
			index[i] = c[i] + index[i - 1];
		}

		for (i = 0; i < n; i++) {
			System.out.println("-->" + a[i]);
			int rem = a[i] % k;
			if (c[rem] != 0) {
				System.out.println(a[i] + " " + rem);
				c[a[i]]--;
				a[i] = -1;
				pairs++;
			} else {
				break;
			}
			System.out.println("------");
			for (int j = 0; j < n; j++)
				System.out.print(a[j] + " ");
			System.out.println();
			System.out.println("------");
		}

		System.out.println();

		if (n % 2 != pairs) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
	}
}
