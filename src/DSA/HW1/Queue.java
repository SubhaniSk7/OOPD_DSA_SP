package DSA.HW1;

import java.util.Scanner;

public class Queue<E> implements Queue_Interface<E> {

	private int length;
	private Node front, rear;

	public Queue() {
		length = 0;
		front = null;
		rear = null;
	}

	@Override
	public int size() {
		return length;
	}

	@Override
	public boolean isEmpty() {
		return (length == 0);
	}

	@Override
	public int front() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();

		return front.getData();
	}

	@Override
	public void enqueue(int element) {
		Node node = new Node(element);
		if (isEmpty()) {
			front = node;
		} else {
			rear.setNext(node);
		}
		rear = node;
		length++;
	}

	@Override
	public int dequeue() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		int element = front.getData();
		front = front.getNext();
		length--;
		if (isEmpty()) {
			front = null;
			rear = null;
		}
		return element;
	}

	public void display() {

		if (isEmpty()) {
			System.out.println("Queue is Empty.");
		}
		Node temp = front;
		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public static void main(String subhani[]) throws EmptyQueueException {
		Scanner sc = new Scanner(System.in);
		Queue queue = new Queue();
		int choice;
		do {
			System.out.println("\n1.display\n2.size\n3.isEmpty\n4.front\n5.enqueue\n6.dequeue\n7.exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				queue.display();
				break;
			case 2:
				System.out.println(queue.size());
				break;
			case 3:
				System.out.println(queue.isEmpty());
				break;
			case 4:
				System.out.println("Front of the Queue:" + queue.front());
				break;
			case 5:
				System.out.println("enter node data:");
				int element = sc.nextInt();
				queue.enqueue(element);
				System.out.println("inserted..\n");
				break;
			case 6:
				System.out.println(queue.dequeue());
				System.out.println("dequeued..\n");
				break;
			default:
				break;
			}
		} while (choice != 7);
		System.out.println("Exited..");
	}

}
