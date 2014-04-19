/*
 * FullQueueException.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * Runtime exception throw when tries to perform to add a new
 * element to a full queue.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class FullQueueException extends RuntimeException {

	/** A default seiral Version UID */
	private static final long serialVersionUID = 1L;
	
	/** Constructor by error information */
	public FullQueueException (String error) {
		super (error);
	}
}
