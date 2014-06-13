/*
 * BinaryTree.java
 * 
 * Date: June 13, 2014
 * 
 * @author Rainicy
 */
package com.rainicy.chapter7.tree;

import com.rainicy.chapter6.arraylist.BoundaryViolationException;
import com.rainicy.chapter6.arraylist.InvalidPositionException;
import com.rainicy.chapter6.arraylist.Position;

/**
 * An interface for a binary tree, which has 0, 1 or 2 children.
 * 
 * @version 1.0
 * 
 * @author Rainicy
 */
public interface BinaryTree<E> extends Tree<E> {
	/** Returns the left child of the given node. */
	public Position<E> left (Position<E> v) 
		throws InvalidPositionException, BoundaryViolationException;
	
	/** Returns the right child of the given node. */
	public Position<E> right (Position<E> v)
		throws InvalidPositionException, BoundaryViolationException;
	
	/** Returns weather the given node has left child. */
	public boolean hasLeft (Position<E> v)
		throws InvalidPositionException;
	
	/** Returns weather the given node has right child. */
	public boolean hasRight (Position<E> v)
		throws InvalidPositionException;
}

