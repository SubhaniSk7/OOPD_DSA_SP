package DSA.Lab2;

import java.util.Scanner;

class Node {
	private int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}

public class LinkedList {
	int length;
	Node head;

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Node getHead() {
		return this.head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public LinkedList() {
		setLength(0);
	}

	public static void main(String subhani[]) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		LinkedList list = new LinkedList();

		System.out.println("enter input String:");

		String input = sc.next();

		String[] num = input.split("->");
		for (String i : num) {
			if (i.equals("NULL")) {
				continue;
			} else {
				Node newNode = new Node(Integer.parseInt(i));
				list.insert(newNode);
			}
		}

		// list.display();
		// System.out.println("size:" + list.getSize());

		list.order();

		list.display();
		System.out.println();
	}

	public void insert(Node node) {
		if (this.head == null) {
			this.head = node;
			node.setNext(null);
		} else {
			Node temp = this.head;
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(null);
		}
		length++;
	}

	public int getSize() {
		return length;
	}

	public void display() {
		Node temp = this.head;
		if (this.head == null) {
			System.out.println("List is Empty.");
		} else {
			while (temp != null) {
				System.out.print(temp.getData() + "->");
				temp = temp.getNext();
			}
			System.out.print("NULL");
		}
	}

	public void order() throws InterruptedException {

		Node present = head;
		Node temp = head;
		Node prev = null;
		Node tail;

		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		tail = temp;

		while (present.getData() % 2 != 0 && present != temp) {

			// System.out.println("if all odd:");
			tail.setNext(present);
			present = present.getNext();
			tail = tail.getNext();
			tail.setNext(null);
		}

		// display();

		if (present.getData() % 2 == 0) {
			head = present;

			while (present != temp) {

				if (present.getData() % 2 == 0) {
					// System.out.println("even:" + present.getData());
					prev = present;
					present = present.getNext();
				} else {
					// System.out.println("odd:" + present.getData());

					prev.setNext(present.getNext());

					tail.setNext(present);
					present.setNext(null);
					tail = present;

					present = prev.getNext();
					// Thread.sleep(500);
				}

				// display();
			}
		} else {
			prev = present;
		}

		if (temp.getData() % 2 != 0 && prev.next != temp) {

			// System.out.println("if all odd:");
			prev.setNext(temp.getNext());
			temp.setNext(null);
			tail.setNext(temp);
			// Thread.sleep(500);
		}
	}

	// public void order() throws InterruptedException {
	// System.out.println("In Order:");
	// LinkedList even = new LinkedList();
	// LinkedList odd = new LinkedList();
	//
	// Node temp = this.head;
	//
	// while (temp != null) {
	//
	// if (temp.getData() % 2 == 0) {
	// System.out.println("in even:");
	// even.insert(temp);
	// even.display();
	// Thread.sleep(500);
	//
	// } else {
	// System.out.println("in odd:");
	// odd.insert(temp);
	// odd.display();
	// Thread.sleep(500);
	// }
	// temp = temp.getNext();
	// System.out.println("-----");
	// }
	//
	// Node evenTemp = even.head;
	// Node oddTemp = odd.head;
	// while (evenTemp != null) {
	// System.out.print(evenTemp.getData() + " ");
	// evenTemp = evenTemp.getNext();
	// }
	// System.out.println();
	// while (oddTemp != null) {
	// System.out.print(oddTemp.getData() + " ");
	// oddTemp = oddTemp.getNext();
	// }
	// }
}
