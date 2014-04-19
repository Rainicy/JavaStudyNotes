/*
 * CircleList.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Circulary linked list with nodes of type Node storing generic types.
 * 
 * @version 2.0
 * @author Rainicy
 *
 */
public class CircleList<E> {
	/** the current cursor */
	protected Node<E> cursor;
	/** the number of nodes in the list */
	protected int size;
	
	/** Constructor that creates an empty list */
	public CircleList() {
		cursor = null;
		size = 0;
	}
	
	/** Returns the size of list */
	public int size() {
		return size;
	}
	
	/** Returns the cursor */
	public Node<E> getCursor() {
		return cursor;
	}
	
	/** Moves the cursor forward */
	public void advance()
		throws IllegalStateException
	{
		if (cursor == null) {
			throw new IllegalStateException("The list is empty!");
		}
		else {
			cursor = cursor.getNext();
		}
	}
	
	/** Adds a new node after the  cursor */
	public void add (Node<E> node) {
		if (cursor == null) {
			node.setNext(node);
			cursor = node;
		}
		else {
			node.setNext(cursor.getNext());
			cursor.setNext(node);
		}
		size++;
	}
	
	/** Removes the node after the cursor and returns it. */
	public Node<E> remove() {
		if (cursor == null) {	// the list is empty
			return null;
		}
		Node<E> removeNode = cursor.getNext();
		if (removeNode == cursor) {	// only one Node in this list
			cursor = null;
		}
		else {
			cursor.setNext(removeNode.getNext());
			removeNode.setNext(null);
		}
		size--;
		return removeNode;
	}
	
	/** Returns a string representation of the list, starting from the cursor */
	public String toString() {
		if (cursor == null) {
			return "Empty list.";
		}
		String string = "[...(";
		string += cursor.getElement() + ")";
		Node<E> startNode = cursor;
		for (advance(); startNode!=cursor; advance()) {
			string += "->" + cursor.getElement();
		}
		string += "...]";
		return string;
	}
	
}
