package DSA.HW1;

import java.util.EmptyStackException;

public interface Stack_Interface<E> {

	public int size();

	public boolean isEmpty();

	// public E top();
	public int top();

	// public void push(E element);
	public void push(int element);

	// public E pop() throws EmptyStackException;
	public int pop() throws EmptyStackException;
}
