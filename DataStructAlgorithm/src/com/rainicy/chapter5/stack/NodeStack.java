/*
 * NodeStack.java
 * 
 * Date: April 18, 2014
 */
package com.rainicy.chapter5.stack;

import com.rainicy.chapter3.linkedlist.Node;

/**
 * Implementation of the stack ADT using generic Node structure.
 * This class includes the main methods of the build-in class java.util.Stack.
 * 
 * @author Rainicy
 */
public class NodeStack<E> implements Stack<E> {
	/** reference the top node */
	protected Node<E> top;
	/** the stack current size */
	protected int size;
	
	/** Constructor for initializing a new stack */
	public NodeStack() {
		top = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException ("Stack is empty!");
		}
		return top.getElement();
	}

	@Override
	public void push(E element) {
		Node<E> node = new Node<E>(element, top);
		top = node;
		size++;
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException ("Stack is empty");
		}
		E element = top.getElement();
		top = top.getNext();
		size--;
		return element;
	}
}
