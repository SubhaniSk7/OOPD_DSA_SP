package DSA.HW2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordFrequencyCounter {

	public static void main(String subhani[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path:");
		String filePath = sc.nextLine();

		// File file = new File("/home/subhani007/Desktop/input.txt");
		File file = new File(filePath);

		BufferedReader br = new BufferedReader(new FileReader(file));

		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// String str = br.readLine();
		System.out.println("Enter Threshold:");
		int threshold = sc.nextInt();

		String str = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			str += line;
		}

		// System.out.println("\nText:");
		// System.out.println(str);

		int i, j, k;
		String[] ignore = { ",", "\\.", "-", ";", ":", "!", "\\?", "\\(", "\\)", "\\{", "\\}", "\\[", "\\]" };
		//
		for (i = 0; i < ignore.length; i++) {

			str = str.replaceAll(ignore[i], "");
			// System.out.println(ignore[i]);
		}
		// System.out.println(str);
		//
		// System.out.println("\nAfter:");
		// System.out.println("-->" + str);

		String[] words = str.split(" ");

		int wc = words.length;// word count

		int[] keys = new int[wc];// hash function keys stored

		int asciiSum = 0;
		// System.out.println("wc:" + wc);
		for (i = 0; i < wc; i++) {
			asciiSum = 0;
			words[i] = words[i].toLowerCase();
			for (j = 0; j < words[i].length(); j++) {
				asciiSum += words[i].charAt(j);
			}
			keys[i] = asciiSum % wc;
			// System.out.println("ascii sum :" + words[i] + "-" + asciiSum + "-->" +
			// keys[i]);
		}
		// System.out.println("---------------------------------");

		WordsClass[] counter = new WordsClass[wc];

		j = 0;
		for (i = 0; i < wc; i++) {
			int index = keys[i];
			j = index;

			if (counter[index] == null) {

				WordsClass obj = new WordsClass();
				obj.count = 1;
				obj.data = words[i];

				counter[index] = obj;
				// System.out.println("in if----------------->" + counter[index].data + "-->" +
				// counter[index].count
				// + "-->index:" + index);

			} else if (counter[index] != null && counter[index].getData().equals(words[i])) {// !null && equal

				int freq = counter[index].getCount();
				counter[index].setCount(++freq);
				// System.out.println("in else if----------------->" + counter[index].data +
				// "-->" + counter[index].count
				// + "-->index:" + index);

			} else if (!counter[index].getData().equals(words[i])) {// not equal

				j = index % wc;
				while (counter[j] != null && !counter[j].getData().equals(words[i])) {
					j = (++j) % wc;
					// System.out.println("j:" + j);
				}

				if (counter[j] != null && counter[j].getData().equals(words[i])) {
					int freq = counter[j].getCount();
					counter[j].setCount(++freq);

				} else {

					WordsClass obj = new WordsClass();
					obj.count = 1;
					obj.data = words[i];

					counter[j] = obj;
				}

				// System.out.println(
				// "in else----------------->" + counter[j].data + "-->" + counter[j].count +
				// "-->index:" + j);
			}
		}

		// System.out.println("========================");
		// for (i = 0; i < counter.length; i++) {
		// if (counter[i] != null) {
		// System.out.println(counter[i].getData() + "-->" + counter[i].getCount());
		// }
		// }
		// System.out.println("------------");
		// System.out.println("going for QuickSort");

		quickSort(counter, 0, wc - 1);
		// System.out.println("------------\n");
		// System.out.println("Sorted:\n");

		// for (i = 0; i < counter.length; i++) {
		// if (counter[i].getData() != "") {
		// System.out.println(counter[i].getData() + "-->" + counter[i].getCount());
		// }
		// }

		// System.out.println("Threshold print:");
		print(counter, threshold);
	}

	public static void quickSort(WordsClass[] counter, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(counter, start, end);
			// System.out.println("pivotIndex:" + pivotIndex + "\t--start:" + start +
			// "\t--end:" + end);
			quickSort(counter, start, pivotIndex - 1);
			quickSort(counter, pivotIndex + 1, end);
		}
	}

	public static int partition(WordsClass[] counter, int start, int end) {

		int i, j;
		if (counter[end] == null) {
			WordsClass obj = new WordsClass();
			counter[end] = obj;
		}

		WordsClass pivot = counter[end], temp;
		i = start - 1;

		for (j = start; j <= end - 1; j++) {
			if (counter[j] == null) {
				WordsClass obj = new WordsClass();
				counter[j] = obj;
			}
			if (counter[j].getCount() < pivot.getCount()) {
				i++;
				temp = counter[i];
				counter[i] = counter[j];
				counter[j] = temp;
			}
		}

		temp = counter[i + 1];
		counter[i + 1] = pivot;
		counter[end] = temp;
		return i + 1;

	}

	public static void print(WordsClass[] counter, int threshold) {

		int i;
		for (i = counter.length - 1; i >= 0; i--) {

			// System.out.println("-->" + counter[i].getData() + "-->" +
			// counter[i].getCount());
			if (counter[i].getData() != "" && counter[i].getCount() > threshold) {
				System.out.println(counter[i].getData() + "-->" + counter[i].getCount());
			}

			if (counter[i].getCount() == threshold) {
				break;
			}
		}

	}
}
