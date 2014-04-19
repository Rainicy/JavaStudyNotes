/*
 * Deque.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * Interface for a deque a collection of objects that are inserted and 
 * removed at both ends; A subset of java.util.LinkedList methods.
 * 
 * @version 1.0
 * @author Rainicy
 */
public interface Deque<E> {
	/** Returns the number of elements in the deque. */
	public int size();
	
	/** Returns whether the deque is empty. */
	public boolean isEmpty();
	
	/** 
	 * Returns the first element in the deque.
	 * 
	 * @return element the first element in the deque.
	 * @exception EmptyQueueException if the deque is empty.
	 */
	public E getFirst() throws EmptyQueueException;
	
	/**
	 * Returns the last element in the deque.
	 * 
	 * @return element the last element in the deque.
	 * @throws EmptyQueueException if the deque is empty.
	 */
	public E getLast() throws EmptyQueueException;
	
	/**
	 * Inserts a new element to be the first one in the deque.
	 * 
	 * @param element to be inserted.
	 */
	public void addFirst(E element);
	
	/**
	 * Inserts a new element to be the last one in the deque.
	 * 
	 * @param element to be inserted.
	 */
	public void addLast(E element);
	
	/**
	 * Removes the first element in the deque and returns it.
	 * 
	 * @return element removed.
	 * @throws EmptyQueueException if the deque is empty.
	 */
	public E removeFirst() throws EmptyQueueException;
	
	/** 
	 * Removes the last element in the deque and returns it.
	 * 
	 * @return element removed.
	 * @throws EmptyQueueException if the deque is empty.
	 */
	public E removeLast() throws EmptyQueueException;
}
