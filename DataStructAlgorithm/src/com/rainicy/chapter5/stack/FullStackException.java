/*
 * FullStackException.java
 * 
 * Date: April 15, 2014
 */
package com.rainicy.chapter5.stack;

/**
 * Runtime exception throw when one tries to push on a 
 * full array stack.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class FullStackException extends RuntimeException{
	/** Random serial version UID */
	private static final long serialVersionUID = -4937214769029783503L;

	/** Constructor */
	public FullStackException(String error) {
		super (error);
	}
}
