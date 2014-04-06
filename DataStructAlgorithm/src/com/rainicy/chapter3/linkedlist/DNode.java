/*
 * DNode.java 
 * 
 * Version: 1.0
 * 
 * Date: April 5, 2014
 */
package com.rainicy.chapter3.linkedlist;

/** 
 * Node of a double linked list.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class DNode {
	/** Element in node */
	private String element;
	/** The previous pointer */
	private DNode prev;
	/** The next pointer */
	private DNode next;
	
	/** 
	 * Constructor of DNode
	 * @param {String} element - The element in the node.
	 * @param {DNode} prev - The previous pointer
	 * @param {DNode} next - The next pointer
	 */
	public DNode (String element, DNode prev, DNode next) {
		this.element = element;
		this.prev = prev;
		this.next = next;
	}
	
	/** Getter element */
	public String getElement() {
		return element;
	}
	
	/** Getter previous node */
	public DNode getPrev() {
		return prev;
	}
	
	/** Getter next node */
	public DNode getNext() {
		return next;
	}
	
	/** Setter element */
	public void setElement (String element) {
		this.element = element;
	}
	
	/** Setter previous node */
	public void setPrev (DNode prev) {
		this.prev = prev;
	}
	
	/** Setter next node */
	public void setNext (DNode next) {
		this.next = next;
	}
} 
