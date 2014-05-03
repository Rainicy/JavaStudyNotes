/*
 * FavoriteList.java
 * 
 * Date: May 3, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * List of favorite elements, with their access count.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class FavoriteList<E> {
	/** List of favorite elements */
	protected PositionList<Entry<E>> fList;
	
	/** Constructor */
	public FavoriteList() {
		fList = new NodePositionList<Entry<E>>();
	}
	
	/** Returns the number of elements in the list  */
	public int size() {
		return fList.size();
	}
	
	/** Returns if the list is empty */
	public boolean isEmpty() {
		return fList.isEmpty();
	}
	
	/** Removes a gievn element, provided it is in the list */
	public void remove(E obj) {
		Position<Entry<E>> p = find(obj);
		if (p != null) {
			fList.remove(p);
		}
	}
	
	/** Increments the access count for the given element and inserts it 
	 * if it is not already present */
	public void access(E obj) {
		Position<Entry<E>> p = find(obj);
		if (p != null) { // find the position
			p.element().incrementCount();
		} else {
			fList.addLast(new Entry<E>(obj));
			p = fList.last();
		}
		moveUp(p);
	}
	
	/** Moves up an entry to its correct position in the list */
	private void moveUp(Position<Entry<E>> p) {
		Entry<E> e = p.element();
		int c = count(p);
		while (p != fList.first()) {
			Position<Entry<E>> prev = fList.prev(p);
			if (c <= count(prev)) {	// The correct position
				break;
			}
			fList.set(p, prev.element());
			p = prev;
		}
		fList.set(p, e);
	}
	
	/** Returns the top k most accessed elements */
	public Iterable<E> top (int k) {
		if (k<0 || k>size()) {
			throw new IllegalArgumentException("Invalid argument!");
		}
		PositionList<E> P = new NodePositionList<E>();	// top k list
		int i = 0;
		for (Entry<E> e : fList) {
			if (i++ >= k) {
				break;
			}
			P.addLast(e.value());
		}
		return P;
	}

	/** toString method */
	public String toString() {
		return fList.toString();
	}
	
	/** Finds the position of a given element, or returns null; */
	protected Position<Entry<E>> find(E obj) {
		for (Position<Entry<E>> p :fList.positions()){
			if (value(p).equals(obj)) {
				return p;
			}
		}
		return null;
	}

	/** Helper method that extract the value of the entry at a given position*/
	private E value(Position<Entry<E>> p) {
		return p.element().value();
	}
	
	/** Helper method that extract the counter of the entry */ 
	private int count(Position<Entry<E>> p) {
		return p.element().count();
	}

	protected static class Entry<E> {
		private E value;	// element
		private int count; 	// access count
		
		/** Constructor */
		Entry(E v) {
			count = 1;
			value = v;
		}
		
		/** Returns the element */
		public E value() {
			return value;
		}
		
		/** Returns the access count */ 
		public int count() {
			return count;
		}
		
		/** Increments the access count */
		public int incrementCount() {
			return ++count;
		}
		
		/** Stirng representation of the entry as [count, value] */
		public String toString() {
			return "[" + count + ", " + value + "]";
		}
	}
}
