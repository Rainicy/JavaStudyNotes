/*
 * ArrayStack.java
 * 
 * Date: April 15, 2014
 */
package com.rainicy.chapter5.stack;

/**
 * Implementation of the stack ADT using a fixed-length array.
 * An exception is thrown if a push operation is attempted when
 * the size of the stack is equal to the length of the array. This
 * class includes the main methods of the build-in class java.util.Stack.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class ArrayStack<E> implements Stack<E> {
	/** the actual capacity of the stack array */
	protected int capacity;
	/** default capacity */
	public static final int CAPACITY = 1000;
	/** array used to implement the stack */
	protected E S[];
	/** index for the top of the stack */
	protected int top = -1;
	
	/** Defualt constructor */
	public ArrayStack() {
		this (CAPACITY);
	}
	
	/** constructor by given capacity */
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		this.capacity = capacity;
		S = (E[]) new Object[capacity];
	}

	@Override
	public int size() {
		return top + 1;
	}

	@Override
	public boolean isEmpty() {
		return (top < 0);
	}

	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException ("The stack is empty now.");
		}
		return S[top];
	}

	@Override
	public void push(E element) throws FullStackException {
		if (size() == capacity) {
			throw new FullStackException ("The stack is full now.");
		}
		S[++top] = element;
	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException ("The stack is empty now.");
		}
		E element = S[top];
		S[top--] = null;
		return element;
	}
	
	/** toString */ 
	public String toString() {
		String string;
		string = "[";
		for (int i=0; i<size(); i++) {
			 string += S[i];
			 if (i < size()-1) {
				 string += ",";
			 }
		}
		return string + "]";
	}
	
	/** print status information about a recent operation and the stack. */
	public void status (String operation, Object element) {
		System.out.print("-----> " + operation);
		System.out.println(", returns " + element);
		System.out.print("result: size = " + size() + ", isEmpty = "
				+ isEmpty());
		System.out.println(", stack: " + this);
	}
	
	/**
	 * Test for the array stack class.
	 */
	public static void main (String[] args) {
		Object object;
		ArrayStack<Integer> A = new ArrayStack<Integer>();
		A.status("New ArrayStack<Integer> A", null);
		A.push(7);
		A.status("A.push(7)", null);
		object = A.pop();
		A.status("A.pop()", object);
		
		ArrayStack<String> B = new ArrayStack<String>();
		A.status("New ArrayStack<String> B", null);
		B.push("Rain");
		B.status("B.push(\"Rain\")", null);
		B.push("Icy");
		B.status("B.push(\"Icy\")", null);
		object = B.top();
		B.status("B.top()", object);
		object = B.pop();
		B.status("B.pop()", object);
	}
}
