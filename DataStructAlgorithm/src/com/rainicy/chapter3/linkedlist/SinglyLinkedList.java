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
	protected int size;
	
	/** Default constructor that creates an empty list */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	// Update and search methods are here
	/** Add a new node at the beginning of a singly linked list */
	public void addFirst (Node node) {
		node.setNext(head);
		head = node;
		size++;
	}
	
	/** Add a new node at the end of a singly linked list */
	public void addLast(Node node) {
		node.setNext(null);
		Node tail = head;
		if (tail == null) {
			head = node;
			return;
		}
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(node);
		size++;
	}
	
	/** Remove the first node of a singly linked list */
	public void removeFirst() {
		if (head == null) {
			System.err.println("The list is empty, cannot remove node");
			return;
		}
		Node templeHead = head;
		head = head.getNext();
		templeHead.setNext(null);
		size--;
	}
}
