/*
 * DList.java
 * 
 * Version: 1.0
 * 
 * Date: April 6, 2014
 */
package com.rainicy.chapter3.linkedlist;

/** 
 * Doubly linked list with nodes of type DNode storing strings.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class DList {
	/** Number of nodes */
	protected int size;
	/** Header in the list as a sentinel */
	protected DNode header;
	/** Trailer in the list as a sentinel */
	protected DNode trailer;
	
	/** Constructor that creates an empty */
	public DList(){
		size = 0;
		header = new DNode(null, null, null);
		trailer = new DNode(null, header, null);
		header.setNext(trailer);
	}
	
	/** Getter of the list's size */
	public int getSize() {
		return size;
	}
	
	/** Getter of the list's header */
	public DNode getHeader() {
		return header;
	}
	
	/** Getter of the list's trailer */
	public DNode getTrailer() {
		return trailer;
	}
	
	/** Returns whether the list is empty */
	public boolean isEmpty() {
		return (getSize() == 0);
	}
	
	/** Returns the first node in the list */ 
	public DNode getFirst() 
		throws IllegalStateException
	{
		if (isEmpty()) {
			throw new IllegalStateException("List is Empty");
		}
		return header.getNext();
	}
	
	/** Returns the last node in the list */
	public DNode getLast() 
		throws IllegalStateException
	{
		if (isEmpty()) {
			throw new IllegalStateException("List is Empty");
		}
		return trailer.getPrev();
	}
	
	/** 
	 * Returns the node before the given node 
	 * 
	 * @exception IllegalArgumentException if the given node is header
	 */
	public DNode getPrev (DNode dNode) 
		throws IllegalArgumentException
	{
		// the given node is header, which has no previous node
		if (dNode == getHeader()) {
			throw new IllegalArgumentException("Header has no previous node!");
		}
		return dNode.getPrev();
	}
	
	/** 
	 * Returns the node after the given node
	 * 
	 * @exception IllegalArgumentException if the given node is trailer
	 */
	public DNode getNext (DNode dNode) 
		throws IllegalArgumentException
	{
		if (dNode == getTrailer()) {
			throw new IllegalArgumentException("Trailer has no next node!");
		}
		return dNode.getNext();
	}
	
	/**
	 * Insert a new node before the given node. 
	 * 
	 * @param {DNode} node - the given node
	 * @param {DNode} newNode - the insert new node
	 * 
	 * @exception IllegalArgumentException if the given node is the header 
	 */
	public void addBefore (DNode node, DNode newNode) 
		//throws IllegalArgumentException
	{
		DNode prev = getPrev (node);	// may throw exception
		newNode.setNext(node);
		newNode.setPrev(prev);
		prev.setNext(newNode);
		node.setPrev(newNode);
		size++;
	}
	
	/**
	 * Insert a new node after the given node.
	 * 
	 * @param {DNode} node - the given node
	 * @param {DNode} newNode - the insert new node
	 * 
	 * @exception IllegalArgumentException if the given node is trailer
	 */
	public void addAfter (DNode node, DNode newNode) 
		//throws IllegalArgumentException
	{
		DNode next = getNext (node);	// may throw exception
		newNode.setNext(next);
		newNode.setPrev(node);
		node.setNext(newNode);
		next.setPrev(newNode);
		size++;
	}
	
	/**
	 * Insert a new node at the first position in the list
	 * 
	 * @param {DNode} dNode - the given new node
	 */
	public void addFirst (DNode dNode) {
		addAfter (getHeader(), dNode);
	}
	
	/**
	 * Insert a new node at the last position in the list
	 * 
	 * @param {DNode} dNode - the given new node 
	 */
	public void addLast (DNode dNode) {
		addBefore (getTrailer(), dNode);
	}
	
	/**
	 * Remove the given node
	 * 
	 * @param {DNode} dNode - the given node in the list
	 */
	public void remove (DNode dNode) 
		throws IllegalArgumentException
	{
		DNode prev = getPrev(dNode);	// may throw exception
		DNode next = getNext(dNode);	// may throw exception
		prev.setNext(next);
		next.setPrev(prev);
		dNode.setNext(null);
		dNode.setPrev(null);
		size--;
	}
}
