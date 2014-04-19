/*
 * NodeQueue.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

import com.rainicy.chapter3.linkedlist.Node;

/**
 * Implement a queue by a singly linked list. And set a
 * front and a rear in this queue. Insert new element at the rear,
 * remove from the header.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class NodeQueue<E> implements Queue<E> {
	/** The front sentinel at the header of the queue. */
	protected Node<E> front;
	/** The rear sentinel at the end of the queue. */
	protected Node<E> rear;
	/** The number of elements in this queue */
	protected int size;
	
	/** Default constructor */
	public NodeQueue() {
		front = null;
		rear = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public void add(E element) {
		Node<E> node = new Node<E>(element, null);
		if (size == 0) {	// the first element to be inserted.
			front = node;
		}
		else {
			rear.setNext(node);
		}
		rear = node;
		size++;
	}

	@Override
	public E remove() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty!");
		}
		E element = front.getElement();
		front = front.getNext();
		size--;
		if (size == 0) {
			rear = null;
		}
		return element;
	}

	@Override
	public E peek() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Queue is empty");
		}
		E element = front.getElement();
		return element;
	}
	
	/** toString override */
	public String toString() {
		String string = "[";
		Node<E> node = front;
		for (int i=0; i<size(); i++) {
			string += node.getElement();
			if (i < size() - 1) {
				string += ", ";
			}
			node = node.getNext();
		}
		string += "]";
		return string;
	}
}
