/*
 * ArrayQueue.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * A queue implemented by array. Throws a FullQueueException if the 
 * queue is full. 
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ArrayQueue<E> implements Queue {
	
	public static final int CAPACITY = 10;	// default array capacity
	
	/** The capacity of this queue array */
	protected int capacity;
	
	/** Generic array used to implement the queue */
	E Q[];
	
	/** Index for the  */
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

}
