/*
 * EmptyStackException.java
 * 
 * Date: April 15, 2014
 */
package com.rainicy.chapter5.stack;

/**
 * Runtime exception throw when one tries to perform operation to 
 * pop or top on an empty stack.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class EmptyStackException extends RuntimeException {
	/** The default serial version UID */
	private static final long serialVersionUID = 1L;

	/** Constructor */
	public EmptyStackException(String error) {
		super (error);
	}
}
