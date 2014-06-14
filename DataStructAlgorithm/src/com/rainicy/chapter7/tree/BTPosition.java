/*
 * BTPosition.java
 * 
 * Created on June 13, 2014
 * 
 * @author Rainicy
 */
package com.rainicy.chapter7.tree;

import com.rainicy.chapter6.arraylist.Position;

/**
 * Interface for a node of a binary tree. It maintains an 
 * element, a parent node, a left node and a right node.
 * 
 * @version 1.0
 * 
 * @author Rainicy
 */
public interface BTPosition<E> extends Position<E> {
	/** Set the element stored at this position. */
	public void setElement(E e);
	
	/** Get the left child's position of this position. */
	public BTPosition <E> getLeft();
	
	/** Set the left child of this position. */
	public void setLeft(BTPosition<E> v);
	
	/** Get the right child's position of this position. */
	public BTPosition <E> getRight();
	
	/** Set the right child of this position. */
	public void setRight(BTPosition<E> v);
	
	/** Get the parent's position of this position. */
	public BTPosition <E> getParent();
	
	/** Set the parent of this position. */
	public void setParent(BTPosition<E> v);
}
