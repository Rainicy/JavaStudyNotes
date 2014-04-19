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
public class ArrayQueue<E> implements Queue<E> {
	
	public static final int CAPACITY = 10;	// default array capacity
	/** The capacity of this queue array */
	protected int capacity;
	/** Generic array used to implement the queue */
	E Q[];
	/** Index for the front of the queue */
	protected int front;
	/** Index for the rear of the queue */
	protected int rear;
	
	/** Constructor of no arguments */
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	/** Constructor by given capacity */
	@SuppressWarnings("unchecked")
	public ArrayQueue (int capacity) {
		this.capacity = capacity;
		Q = (E[]) new Object[capacity];
		front = 0;
		rear = 0;
	}
	
	
	@Override
	public int size() {
		return ((rear - front + capacity) % capacity);
	}

	@Override
	public boolean isEmpty() {
		return (rear == front);
	}

	@Override
	public void add(E element) throws FullQueueException {
		if (size() == (capacity-1)) {	// left one empty cell
			throw new FullQueueException("Queue is full now");
		}
		Q[rear] = element;
		rear = (rear+1) % capacity;
	}

	@Override
	public E remove() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty now");
		}
		E temp = Q[front];
		Q[front] = null;
		front = (front+1) % capacity;
		return temp;
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty now");
		}
		return Q[front];
	}
	
	/** ToString function */
	public String toString() {
		String string = "[";
		for (int i=0; i<size(); i++) {
			string += Q[(front+i)%capacity];
			if (i < (size()-1)) {
				string += ", ";
			}
		}
		string += "]";
		return string;
	}
}
