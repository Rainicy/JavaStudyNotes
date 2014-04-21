/*
 * ArrayIndexList.java
 * 
 * Date: April 20, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Realization of an indexed list by means of an array,
 * which is doubled when the size of the inde exceeds the
 * capacity of the array.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ArrayIndexList<E> implements IndexList<E> {
	private E[] A; 	// array storing the elements of the indexed list
	private int capacity = 16;	// intial length of array A
	private int size = 0;	// the current number of elements stored
	
	/** Constructor of creating the indexed list with null parameters */
	public ArrayIndexList() {
		A = (E[]) new Object[capacity];
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
	public void add(int i, E element) throws IndexOutOfBoundsException {
		checkIndex(i, size()+1);
		if (size() == capacity) {	// double array
			capacity *= 2;
			E[] B = (E[]) new Object[capacity];
			for (int j=0; j<size(); j++) {
				B[j] = A[j];
			}
			A = B;
		}
		for (int j=size()-1; j>=i; j++) {
			A[j+1] = A[j];
		}
		A[i] = element;
		size++;
	}

	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size());
		return A[i];
	}

	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		checkIndex(i, size());
		E element = A[i];
		for(int j=i; j<size()-1; j++) {
			A[j] = A[j+1];
		}
		size--;
		return element;
	}

	@Override
	public E set(int i, E element) throws IndexOutOfBoundsException {
		checkIndex(i, size());
		E temp = A[i];
		A[i] = element;
		return temp;
	}
	
	// Check if the given index is legal or not, it will throw
	// IndexOutOfBoundsException if it is illegal. 
	private void checkIndex (int index, int size) 
		throws IndexOutOfBoundsException
	{
		if ((index<0) || (index>=size)) {
			throw new IndexOutOfBoundsException("Illegal index.");
		}
	}
}
