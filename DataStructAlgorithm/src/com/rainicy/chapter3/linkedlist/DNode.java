/*
 * DNode.java 
 * 
 * Version: 2.0
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter3.linkedlist;

/** 
 * Node of a double linked list contains generic type elements.
 * 
 * @version 2.0
 * @author Rainicy
 */
public class DNode<E> {
	/** Element in node */
	private E element;
	/** The previous pointer */
	private DNode<E> prev;
	/** The next pointer */
	private DNode<E> next;
	
	/** 
	 * Constructor of DNode
	 * @param element - The element in the node.
	 * @param prev - The previous pointer
	 * @param next - The next pointer
	 */
	public DNode (E element, DNode<E> prev, DNode<E> next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	/** Getter element */
	public E getElement() {
		return element;
	}
	
	/** Getter previous node */
	public DNode<E> getPrev() {
		return prev;
	}
	
	/** Getter next node */
	public DNode<E> getNext() {
		return next;
	}
	
	/** Setter element */
	public void setElement (E element) {
		this.element = element;
	}
	
	/** Setter previous node */
	public void setPrev (DNode<E> prev) {
		this.prev = prev;
	}
	
	/** Setter next node */
	public void setNext (DNode<E> next) {
		this.next = next;
	}
} 
