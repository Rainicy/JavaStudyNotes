/*
 * InvalidEntryException.java
 *
 * Created on July 18, 2014
 */
package com.rainicy.chapter9;

/**
 * An RuntimeException by an invalid entry.
 */
public class InvalidEntryException extends RuntimeException {
    public InvalidEntryException(String error) {
        super(error);
    }
}
