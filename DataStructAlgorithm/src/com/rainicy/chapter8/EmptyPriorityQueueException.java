package com.rainicy.chapter8;

/**
 * Created by Rainicy on 7/9/14.
 */
public class EmptyPriorityQueueException extends RuntimeException {

    /** Default seiral Version UID. */
    private static  final long serialVersionUID = 1L;

    /** Default Constructor. */
    public  EmptyPriorityQueueException() { super(); }

    /** Constructor by given error message */
    public EmptyPriorityQueueException (String error) { super(error); }
}
