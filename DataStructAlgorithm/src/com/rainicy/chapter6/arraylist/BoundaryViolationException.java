/*
 * BoundaryVoilationException.java
 * 
 * Date: April 21, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Thrown if an attempt is made at accessing an element whose
 * position is outside the range of positions of the list.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class BoundaryViolationException extends RuntimeException{
	
	/** Default serial version UID */
	private static final long serialVersionUID = 1L;

	/** Default constructor without detail error message */
	public BoundaryViolationException() {
		super();
	}
	
	/** Constructor with error message */
	public BoundaryViolationException (String error) {
		super(error);
	}
}
