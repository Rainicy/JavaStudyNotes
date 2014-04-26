/*
 * ElementIterator.java
 * 
 * Date: April 26, 2014
 */
package com.rainicy.chapter6.arraylist;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implements an iterator for a PositionList.
 * 
 * @version	1.0
 * @author Rainicy
 */
public class ElementIterator<E> implements Iterator<E> {
	/** The underlying list */
	protected PositionList<E> list; 
	/** The next position */
	protected Position<E> cursor;
	
	/** Constructor to create an element iterator over the given list. */
	public ElementIterator (PositionList<E> L) {
		list = L;
		cursor = (list.isEmpty())? null : list.first();
	}

	@Override
	public boolean hasNext() {
		return (cursor != null);
	}

	@Override
	public E next() throws NoSuchElementException {
		if (cursor == null) {
			throw new NoSuchElementException("No next element!");
		}
		E element = cursor.element();
		cursor = (cursor == list.last())? null : list.next(cursor);
		return element;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
