/*
 * EmptyQueueException.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * Runtime exception throw when tries to perform operation to
 * remove or peek in an empty queue. 
 * 
 * @version 1.0
 * @author Rainicy
 */
public class EmptyQueueException extends RuntimeException{

	/** A default serial version UID */
	private static final long serialVersionUID = 1L;

	/** Constructor by super class */
	public EmptyQueueException(String error) {
		super(error);
	}
}
