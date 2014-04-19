/*
 * SinglyLinkedList.java
 * 
 * Date: March 31, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Singly linked list with generic types.
 *
 * @version 2.0
 * @author Rainicy
 * 
 */
public class SinglyLinkedList<E> {
	/** Head of the linked list */
	protected Node<E> head;
	/** Number of nodes in the list */
	protected int size;
	
	/** Default constructor that creates an empty list */
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	/** Get the list size */
	public int getSize(){
		return size;
	}
	
	/** Get the head in the linked list */
	public Node<E> getHead(){
		return head;
	}
	
	// Update and search methods are here
	/** Add a new node at the beginning of a singly linked list */
	public void addFirst (Node<E> node) {
		node.setNext(head);
		head = node;
		size++;
	}
	
	/** Add a new node at the end of a singly linked list */
	public void addLast(Node<E> node) {
		node.setNext(null);
		Node<E> tail = head;
		if (tail == null) {
			head = node;
		}
		else {
			while (tail.getNext() != null) {
				tail = tail.getNext();
			}
			tail.setNext(node);
		}
		size++;
	}
	
	/** Remove the first node of a singly linked list */
	public void removeFirst() {
		if (head == null) {
			System.err.println("The list is empty, cannot remove node");
			return;
		}
		Node<E> templeHead = head;
		head = head.getNext();
		templeHead.setNext(null);
		size--;
	}
	
	/** toString */
	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		Node<E> node = this.head;
		if (node == null) {
			stringBuffer.append("Empty List!");
		}
		else {
			while (node != null) {
				stringBuffer.append(node.getElement());
				node = node.getNext();
				if (node != null) {
					stringBuffer.append("->");
				}
			}
		}
		return stringBuffer.toString();
	}
}
