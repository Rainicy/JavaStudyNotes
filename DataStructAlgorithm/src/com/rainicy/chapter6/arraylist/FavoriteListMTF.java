/*
 * FavoriteListMTF.java
 * 
 * Date: May 3, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Modified original one Favorite List class.
 * 
 * @version
 * @author Rainicy
 *
 */
public class FavoriteListMTF<E> extends FavoriteList<E>{
	/** Default constructor */
	public FavoriteListMTF() {}
	
	/** Moves up an entry to the fist position */
	protected void moveUp(Position<Entry<E>> pos) {
		fList.addFirst(fList.remove(pos));
	}
	
	/** Returns the top k most accessed elements */
	public Iterable<E> top (int k) {
		if (k<0 || k>size()) {
			throw new IllegalArgumentException("Invalid argument");
		}
		PositionList<E> P = new NodePositionList<E>();	 // top k list
		if (!isEmpty()) {
			PositionList<Entry<E>> C = new NodePositionList<Entry<E>>();
			for (Entry<E> e : fList) {
				C.addLast(e);
			}
			for  (int i=0; i<k; i++) {
				Position<Entry<E>> maxPos = null;
				int maxCount = -1;
				for (Position<Entry<E>> p : C.positions()) {
					int c = count(p);
					if (c > maxCount) {
						maxCount = c;
						maxPos = p;
					}
				}
				P.addLast(value(maxPos));
				C.remove(maxPos);
			}
		}
		return P;
	}
}
