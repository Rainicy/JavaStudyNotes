/*
 * Queue.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * Queue interface.
 * 
 * @version 1.0
 * @author Rainicy
 */
public interface Queue<E> {
	/**
	 * Returns the number of elements in the queue.
	 * 
	 * @return number of elements in the queue
	 */
	public int size();
	
	/**
	 * Returns whether the queue is empty.
	 * 
	 * @return true if the queue is empty.
	 */
	public boolean isEmpty();
	
	/**
	 * Insert a new element at the rear of the queue.
	 * 
	 * @param element new element to be inserted
	 */
	public void add(E element);
	
	/**
	 * Removes the element at the front of the queue and return it.
	 * 
	 * @return element removed.
	 * @exception EmptyQueueException if the queue is empty.
	 */
	public E remove() throws EmptyQueueException;
	
	/**
	 * Inspects the element at the front of the queue.
	 * 
	 * @return element at the front of the queue.
	 * @throws EmptyQueueException if the queue is empty.
	 */
	public E peek() throws EmptyQueueException;
}
