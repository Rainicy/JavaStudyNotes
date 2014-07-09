/*
 * InvalidKeyException.java
 *
 * Created on July 9, 2014
 */
package com.rainicy.chapter8;

/**
 * The running time exception, when the key is not valid.
 */
public class InvalidKeyException extends RuntimeException {

    /** Default */
    public InvalidKeyException() { super(); }

    /** Constructor by given error message */
    public InvalidKeyException( String error ) { super(error); }
}
