/*
 * NodeDeque.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

import com.rainicy.chapter3.linkedlist.DNode;

/**
 * A Deque class implemented by doubly linked list.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class NodeDeque<E> implements Deque<E> {
	/** The sentinels for the header and trailer in the deque. */
	protected DNode<E> header, trailer;
	/** The number of elements in the deque. */
	protected int size;
	
	/** Default constructor. */
	public NodeDeque() {
		header = new DNode<E>();
		trailer = new DNode<E>();
		header.setNext(trailer);
		trailer.setPrev(header);
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
	public E getFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty!");
		}
		return header.getNext().getElement();
	}

	@Override
	public E getLast() throws EmptyQueueException {
		if (isEmpty()){
			throw new EmptyQueueException("Deque is empty");
		}
		return trailer.getPrev().getElement();
	}

	@Override
	public void addFirst(E element) {
		DNode<E> second = header.getNext();
		DNode<E> first = new DNode<E>(element, header, second);
		header.setNext(first);
		second.setPrev(first);
		size++;
	}

	@Override
	public void addLast(E element) {
		DNode<E> secondLast = trailer.getPrev();
		DNode<E> last = new DNode<E>(element, secondLast, trailer);
		secondLast.setNext(last);
		trailer.setPrev(last);
		size--;
	}

	@Override
	public E removeFirst() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty!");
		}
		DNode<E> first = header.getNext();
		E element = first.getElement();
		DNode<E> second = first.getNext();
		header.setNext(second);
		second.setPrev(header);
		size--;
		return element;
	}

	@Override
	public E removeLast() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Deque is empty!");
		}
		DNode<E> last = trailer.getPrev();
		E element = last.getElement();
		DNode<E> secondLast = last.getPrev();
		trailer.setPrev(secondLast);
		secondLast.setNext(trailer);
		size--;	
		return element;
	}

}
