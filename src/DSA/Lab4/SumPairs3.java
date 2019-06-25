package DSA.Lab4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SumPairs3 {

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(), k = sc.nextInt(), i, pairs = 0;
		int[] a = new int[n];
		for (i = 0; i < n; i++)
			a[i] = sc.nextInt();
		for (i = 0; i < n; i++)
			System.out.print(a[i] + " ");
		System.out.println();

		HashMap<Integer, Integer> count = new HashMap<>();
		int value = 0;
		for (i = 0; i < n; i++) {
			if (count.containsKey(a[i])) {
				value = count.get(a[i]);
				count.put(a[i], ++value);
			} else {
				count.put(a[i], 1);
			}
		}

		Iterator it = count.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry me2 = (Map.Entry) it.next();
			System.out.println("Key: " + me2.getKey() + " & Value: " + me2.getValue());
		}

		for (i = 0; i < n; i++) {

			if (count.containsKey(a[i] % k)) {
				System.out.println("---");
				value = count.get(a[i]);
				count.put(a[i], --value);
				pairs++;
			} else {
				break;
			}
		}

		Iterator it2 = count.entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry me2 = (Map.Entry) it2.next();
			System.out.println("Key: " + me2.getKey() + " & Value: " + me2.getValue());
		}

		if (n % 2 != pairs) {
			System.out.println("False");
		} else {
			System.out.println("True");
		}
	}
}
