/*
 * SinglyLinkedList.java
 * 
 * Version: 1.0
 * 
 * Date: March 31, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Singly linked list.
 *
 * @version 1.0
 * @author Rainicy
 * 
 */
public class SinglyLinkedList {
	/** Head of the linked list */
	protected Node head;
	/** Number of nodes in the list */
	protected long size;
	
	/** Default constructor that creates an empty list */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
}
