package DSA.HW1;

import java.util.Scanner;

public class StackPermutation {

	static Queue q1;// declaring Q1
	static Queue q2;// declaring Q2
	static Stack stack;// declaring Stack

	public StackPermutation() {
		q1 = new Queue<>();
		q2 = new Queue<>();
		stack = new Stack<>();
	}

	public static void main(String subhani[]) throws EmptyQueueException {
		Scanner sc = new Scanner(System.in);
		int n, i, j;
		StackPermutation stackPer = new StackPermutation();

		System.out.println("enter n and output permutation:");
		n = sc.nextInt();

		int[] outPer = new int[n];// storing output stack permutation
		for (i = 0; i < n; i++) {
			outPer[i] = sc.nextInt();
		}

		int[] a = new int[n];
		for (i = 1; i <= n; i++) {// taking input sequence 1..n
			q1.enqueue(i);
			a[i - 1] = i;
		}
		//
		// System.out.println("Array:");
		// for (i = 0; i < n; i++) {
		// System.out.print(a[i] + " ");
		// }
		// System.out.println();

		// System.out.println("Queue:");
		// q1.display();

		// System.out.println("entered Output Seq:");
		// for (i = 0; i < n; i++) {
		// System.out.print(outPer[i] + " ");
		// }
		// System.out.println();

		for (i = 0, j = 0; i < n && j < n;) {// iterating till i<n && j<n
			// System.out.println(i + ":" + j);
			if (a[i] == outPer[j]) { // if front(Q1)==front(
				int element = q1.dequeue();
				q2.enqueue(element);
				i++;// incrementing input seq a[] index
				j++;// incrementing input outper[] index
				// System.out.println("dequeue(Q1):" + element + "\nenqueue(Q2):" + element);
				// System.out.println("Q1 size:" + q1.size() + " Q2 size:" + q2.size());
				System.out.println("enqueue(Q2, dequeue(Q1))");
				// System.out.println("in if:" + i + ":" + j);
			} else {
				if (stack.isEmpty() || stack.top() != outPer[j]) {// is stack is empty or stack top element not equal to
																	// output permutation element then deque(Q1) and
																	// push()

					int element = q1.dequeue();
					stack.push(element);
					// System.out.println("dequeue(Q1):" + element + " size:" + q1.size());
					System.out.println("push(S, dequeue(Q1))");
					i++;// incrementing input seq a[] index
					// System.out.println("in else - if:" + i + ":" + j);

				} else if (stack.top() == outPer[j]) {// if input seq and outper element are not equal & stack top is
														// equal to outperm element
					int element = stack.pop();
					q2.enqueue(element);
					// System.out.println("stack.pop()" + element);
					// System.out.println("enqueue(Q2):" + element + " size:" + q2.size());
					System.out.println("enqueue(Q2, pop(S))");
					j++;// incrementing outper[] index
					// System.out.println("in else - else if:" + i + ":" + j);
				}
			}
		}

		// System.out.println("out:" + i + ":" + j);
		int k;
		if (i >= n) {// if i>=n then all elements are in stack.
			for (k = j; k < n; k++) {
				if (stack.top() == outPer[k]) {// checking top of stack is equal to output permutation or not
					int element = stack.pop();
					q2.enqueue(element);
					// System.out.println("stack.pop()" + element);
					// System.out.println("enqueue(Q2):" + element + " Q2 size:" + q2.size());
					System.out.println("enqueue(Q2, pop(S))");
				} else {// stack top is not equal to output permutation element
					System.out.println("Not a Permutation");
					break;
				}
			}
		} else {
			System.out.println("--");
		}

	}
}
