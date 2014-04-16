/*
 * Stack.java
 * 
 * Date: April 15, 2014
 */
package com.rainicy.chapter5.stack;

/**
 * Interface for a stack: a collection of objects that are inserted
 * and removed according to the last-in first-out principle. This 
 * interface includes the main methods of java.util.Stack.
 * 
 * @version 1.0
 * @author Rainicy
 * @see EmptyStackException
 */
public interface Stack<E> {
	/**
	 * Return the number of elements in the stack.
	 * 
	 * @return the number of elements in the stack.
	 */
	public int size();
	
	/**
	 * Return whether the stack is empty.
	 * 
	 * @return true if the stack is empty
	 */
	public boolean isEmpty();
	
	/**
	 * Inspect the top element in the stack.
	 * 
	 * @return top element in the stack
	 * @exception EmptyStackException if the stack is empty.
	 */
	public E top()
		throws EmptyStackException;
	
	/**
	 * Insert an element to the top of the stack.
	 * @param element to be inserted.
	 */
	public void push (E element);
	
	/**
	 * Remove an element from the top of the stack and return it.
	 * 
	 * @return element removed
	 * @exception EmptyStackException if the stack is empty.
	 */
	public E pop();
}
