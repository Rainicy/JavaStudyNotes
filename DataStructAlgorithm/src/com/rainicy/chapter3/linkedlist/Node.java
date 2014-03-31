/*
 * Node.java
 * 
 * Version: 1.0	
 * 
 * Date: March 30, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Node of a singly linked list of strings.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class Node {
	/** We assume elements are character strings */
	private String element;
	/** The next pointer */
	private Node next;
	
	/** 
	 * Constructor. Creates a node with the given element and next node
	 * 
	 * @param {String} string - the element 
	 * @param {Node} node - the next node
	 */
	public Node(String string, Node node) {
		element = string;
		next = node;
	}
	
	/** Returns the element of this node */
	public String getElement() {
		return element;
	}
	
	/** Returns the next of this node */
	public Node getNext() {
		return next;
	}
	
	/** Sets the element of this node */
	public void setElement (String element) {
		this.element = element;
	}
	
	/** Sets the next node of this node */
	public void setNext(Node node) {
		this.next = node;
	}
}

