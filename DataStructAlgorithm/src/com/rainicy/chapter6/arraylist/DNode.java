/*
 * DNode.java
 * 
 * Date: April 21, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Doubly node implements the position interface.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class DNode<E> implements Position<E>{

	private DNode<E> prev, next;	// Reference to the nodes before and after
	private E element;
	
	/** Constructor without detail parameters */
	public DNode() {
		this(null, null, null);
	}
	
	/** Constructor with detail information */
	public DNode (E element, DNode<E> prev, DNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	@Override
	public E element() throws InvalidPositionException {
		if ((prev == null) && (next == null)) {
			throw new InvalidPositionException("Position is not in a list!");
		}
		return element;
	}
	
	/** Gets the next node */
	public DNode<E> getNext() {
		return next;
	}
	
	/** Gets the previous node */
	public DNode<E> getPrev() {
		return prev;
	}
	
	/** Sets the element */
	public void setElement (E element) {
		this.element = element;
	}
	
	/** Sets the next node */
	public void setNext (DNode<E> next) {
		this.next = next;
	}
	
	/** Sets the previous node */
	public void setPrev(DNode<E> prev) {
		this.prev = prev;
	}

}
