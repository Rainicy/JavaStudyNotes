/*
 * InvalidPositionException.java
 * 
 * Date: April 21, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * InvalidPositionException thrown if a position provided as
 * argument is not valid. 
 * @author Rainicy
 *
 */
public class InvalidPositionException extends RuntimeException {
	
	/** Default serial version UID */
	private static final long serialVersionUID = 1L;

	/** Default constructor without error message */
	public InvalidPositionException() {
		super();
	}
	
	/** Constructor with error message */
	public InvalidPositionException (String error) {
		super(error);
	}
}
