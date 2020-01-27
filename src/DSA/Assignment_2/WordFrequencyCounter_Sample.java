package DSA.HW2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordFrequencyCounter_Sample {

	public static void main(String subhani[]) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path:");
		String filePath = sc.nextLine();

		File file = new File(filePath);

		BufferedReader br = new BufferedReader(new FileReader(file));

		System.out.println("Enter Threshold:");
		int threshold = sc.nextInt();

		String str = "";
		String line = null;
		while ((line = br.readLine()) != null) {
			str += line;
		}

		int i, j, k;
		String[] ignore = { ",", "\\.", "-", ";", ":", "!", "\\?", "\\(", "\\)", "\\{", "\\}", "\\[", "\\]" };
		for (i = 0; i < ignore.length; i++) {

			str = str.replaceAll(ignore[i], "");
		}

		String[] words = str.split(" ");

		int wc = words.length;// word count
		int[] keys = new int[wc];// hash function keys stored

		int asciiSum = 0;
		for (i = 0; i < wc; i++) {
			asciiSum = 0;
			words[i] = words[i].toLowerCase();
			for (j = 0; j < words[i].length(); j++) {
				asciiSum += words[i].charAt(j);
			}
			keys[i] = asciiSum % wc;
		}

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

			} else if (counter[index] != null && counter[index].getData().equals(words[i])) {// !null && equal

				int freq = counter[index].getCount();
				counter[index].setCount(++freq);

			} else if (!counter[index].getData().equals(words[i])) {// not equal

				j = index % wc;
				while (counter[j] != null && !counter[j].getData().equals(words[i])) {
					j = (++j) % wc;
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
			}
		}
		quickSort(counter, 0, wc - 1);
		print(counter, threshold);
	}

	public static void quickSort(WordsClass[] counter, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(counter, start, end);
			quickSort(counter, start, pivotIndex - 1);
			quickSort(counter, pivotIndex + 1, end);
		}
	}

	public static int partition(WordsClass[] counter, int start, int end) {
		int i, j;
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
			if (counter[i].getData() != "" && counter[i].getCount() > threshold)
				System.out.println(counter[i].getData() + "-->" + counter[i].getCount());

			if (counter[i].getCount() == threshold)
				break;
		}
	}
}
