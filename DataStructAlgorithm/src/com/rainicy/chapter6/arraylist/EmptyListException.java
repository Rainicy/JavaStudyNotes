/*
 * EmptyListException.java
 * 
 * Date: April 22, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Throws a RuntimeException if the list is empty.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class EmptyListException extends RuntimeException {

	/** Default serial version UID */
	private static final long serialVersionUID = 1L;
	
	/** Constructor without error message */
	public EmptyListException() {
		super();
	}
	
	/** Constructor with error message */
	public EmptyListException (String error) {
		super(error);
	}
}
