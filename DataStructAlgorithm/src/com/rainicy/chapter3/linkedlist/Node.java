/*
 * Node.java
 * 
 * Version: 2.0	
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Generic Node of a singly linked list of generic type.
 * 
 * @version 2.0
 * @author Rainicy
 *
 */
public class Node<E> {
	/** We assume element generic type */
	private E element;
	/** The next pointer */
	private Node<E> next;
	
	/** Constructor with null element and next node */
	public Node() {
		this(null, null);
	}
	
	/** 
	 * Constructor. Creates a node with the given element and next node
	 * 
	 * @param the element 
	 * @param the next node
	 */
	public Node (E element, Node<E> node) {
		this.element = element;
		next = node;
	}
	
	/** Returns the element of this node */
	public E getElement() {
		return element;
	}
	
	/** Returns the next of this node */
	public Node<E> getNext() {
		return next;
	}
	
	/** Sets the element of this node */
	public void setElement (E element) {
		this.element = element;
	}
	
	/** Sets the next node of this node */
	public void setNext (Node<E> node) {
		this.next = node;
	}
	
}

