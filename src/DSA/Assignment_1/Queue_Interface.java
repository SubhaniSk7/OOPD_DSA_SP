package DSA.HW1;

public interface Queue_Interface<E> {
	public int size();

	public boolean isEmpty();

	// public E front() throws EmptyQueueException;
	public int front() throws EmptyQueueException;

	// public void enqueue(E element);
	public void enqueue(int element);

	// public E dequeue() throws EmptyQueueException;
	public int dequeue() throws EmptyQueueException;
}
