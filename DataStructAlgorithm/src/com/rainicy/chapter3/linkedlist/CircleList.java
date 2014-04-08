/*
 * CircleList.java
 * 
 * Version: 1.0
 * 
 * Date: April 7, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
 * Circulary linked list with nodes of type Node storing strings.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class CircleList {
	/** the current cursor */
	protected Node cursor;
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
	public Node getCursor() {
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
	public void add (Node node) {
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
	public Node remove() {
		if (cursor == null) {	// the list is empty
			return null;
		}
		Node removeNode = cursor.getNext();
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
		Node startNode = cursor;
		for (advance(); startNode!=cursor; advance()) {
			string += "->" + cursor.getElement();
		}
		string += "...]";
		return string;
	}
	
}
