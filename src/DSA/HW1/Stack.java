package DSA.HW1;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack<E> implements Stack_Interface<E> {

	private int length;
	private Node top;

	public Stack() {
		length = 0;
		top = null;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		// if (length == 0)
		// return true;
		// else
		// return false;
		return (length == 0);
	}

	@Override
	public int top() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top.getData();
	}

	@Override
	public void push(int element) {
		Node node = new Node(element);
		node.setNext(top);
		top = node;
		length++;
	}

	@Override
	public int pop() throws EmptyStackException {
		if (isEmpty()) {
			System.out.println("stack is empty");
			throw new EmptyStackException();
		}
		int element = top.getData();
		top = top.getNext();
		length--;
		return element;
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Stack is Empty.");
		} else {
			Node temp = top;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}

	public static void main(String subhani[]) {
		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		int choice;
		do {
			System.out.print("1.display\n2.size\n3.isEmpty\n4.top\n5.push\n6.pop\n7.exit");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				stack.display();
				break;
			case 2:
				System.out.println(stack.size());
				break;
			case 3:
				System.out.println(stack.isEmpty());
				break;
			case 4:
				System.out.println(stack.top());
				break;
			case 5:
				System.out.println("enter node data:");
				int element = sc.nextInt();
				stack.push(element);
				System.out.println("inserted..\n");
				break;
			case 6:
				System.out.println(stack.pop());
				System.out.println("popped..\n");
				break;
			default:
				break;
			}
		} while (choice != 7);
		System.out.println("exited..");
	}
}
