package com.rainicy.chapter7.tree;

public class NonEmptyTreeException extends RuntimeException {

	/** Default seiral Version UID */
	private static final long serialVersionUID = 1L;
	
	/** Default constructor */
	public NonEmptyTreeException() {
		super();
	}
	
	/** Constructor by given error message */
	public NonEmptyTreeException (String error) {
		super(error);
	}
}
