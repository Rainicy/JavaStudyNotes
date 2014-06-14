/*
 * BTNode.java
 * 
 * Created on June 13, 2014.
 * 
 * @author Rainicy
 */
package com.rainicy.chapter7.tree;

/**
 * Binary Tree Node class by storing an element,
 * a parent node, a left node and a right node.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class BTNode<E> implements BTPosition<E> {

	/* Element stored in this node. */
	private E element;
	/* Parent node. */
	private BTPosition<E> parent;
	/* Left node. */
	private BTPosition<E> left;
	/* right node. */ 
	private BTPosition<E> right;
	
	/** Default constructor without parameters. */
	public BTNode() {
		this (null, null, null, null);
	}
	
	/** Constructor with parameters. */
	public BTNode(E element, BTPosition<E> parent, 
			BTPosition<E> left, BTPosition<E> right) {
		setElement(element);
		setParent(parent);
		setLeft(left);
		setRight(right);
	}
	
	
	@Override
	public E element() {
		return element;
	}

	@Override
	public void setElement(E e) {
		element = e;
	}

	@Override
	public BTPosition<E> getLeft() {
		return left;
	}

	@Override
	public void setLeft(BTPosition<E> v) {
		left = v;
	}

	@Override
	public BTPosition<E> getRight() {
		return right;
	}

	@Override
	public void setRight(BTPosition<E> v) {
		right = v;
	}

	@Override
	public BTPosition<E> getParent() {
		return parent;
	}

	@Override
	public void setParent(BTPosition<E> v) {
		parent = v;
	}
	
}
