/*
 * NodePositionList.java
 * 
 * Date: April 22, 2014
 */
package com.rainicy.chapter6.arraylist;

/**
 * Implements the node list ADT using a doubly
 * linked list.
 * @author Rainicy
 */
public class NodePositionList<E> implements PositionList<E>{

	/** The number of elements in the list */
	protected int size;
	/** Header sentinel */
	protected DNode<E> header;
	/** Trailer sentinel */
	protected DNode<E> trailer;
	
	/** Default constructor creating an empty list */
	public NodePositionList() {
		size = 0;
		header = new DNode<E>(null, null, null);
		trailer = new DNode<E>(null, header, null);
		header.setNext(trailer);
	}
	
	/** 
	 * Check if position is valid fro this list and converts it to 
	 * DNode if it is valid.
	 */
	protected DNode<E> checkPosition (Position<E> p) 
		throws InvalidPositionException
	{
		if (p == null) {
			throw new InvalidPositionException
			("Null position passed to the NodeList.");
		}
		if (p == header) {
			throw new InvalidPositionException
			("The header node is not a valid position.");
		}
		if (p == trailer) {
			throw new InvalidPositionException
			("The trailer node is not a valid position.");
		}
		try {
			DNode<E> dNode = (DNode<E>) p;
			if ((dNode.getPrev() == null) || (dNode.getNext() == null)) {
				throw new InvalidPositionException
				("Position does not belong to a valid NodeList");
			}
			return dNode;
		} catch (ClassCastException e) {
			throw new InvalidPositionException
			("Position is of wrong type for this list");
		}
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return  (size == 0);
	}

	@Override
	public Position<E> first() 
		throws EmptyListException
	{
		if (isEmpty()) {
			throw new EmptyListException("List is empty.");
		}
		return header.getNext();
	}

	@Override
	public Position<E> last() {
		if (isEmpty()) {
			throw new EmptyListException("List is empty.");
		}
		return trailer.getPrev();
	}

	@Override
	public Position<E> prev(Position<E> p) 
			throws InvalidPositionException, BoundaryViolationException {
		DNode<E> dNode = checkPosition(p);
		DNode<E> prev = dNode.getPrev();
		if (prev == header) {
			throw new BoundaryViolationException
			("Cannot advance past the beginning of the list.");
		}
		return prev;
	}

	@Override
	public Position<E> next(Position<E> p) 
			throws InvalidPositionException, BoundaryViolationException {
		DNode<E> dNode = checkPosition(p);
		DNode<E> next = dNode.getNext();
		if (next == trailer) {
			throw new BoundaryViolationException
			("Cannot advance past the ending of the list.");
		}
		return next;
	}

	@Override
	public void addFirst(E e) {
		size++;
		DNode<E> newNode = new DNode<E>(e, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
	}

	@Override
	public void addLast(E e) {
		size++;
		DNode<E> newNode = new DNode<E>(e, trailer.getPrev(), trailer);
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
	}

	@Override
	public void addAfter(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> dNode = checkPosition(p);
		size++;
		DNode<E> newNode = new DNode<E>(e, dNode, dNode.getNext());
		dNode.getNext().setPrev(newNode);
		dNode.setNext(newNode);
		
	}

	@Override
	public void addBefore(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> dNode = checkPosition(p);
		size++;
		DNode<E> newNode = new DNode<E>(e, dNode.getPrev(), dNode);
		dNode.getPrev().setNext(newNode);
		dNode.setPrev(newNode);
	}

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
		DNode<E> dNode = checkPosition(p);
		size--;
		DNode<E> prev = dNode.getPrev();
		DNode<E> next = dNode.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		E element = dNode.element();
		dNode.setNext(null);
		dNode.setPrev(null);
		return element;
	}

	@Override
	public E set(Position<E> p, E e) throws InvalidPositionException {
		DNode<E> dNode = checkPosition(p);
		E element = dNode.element();
		dNode.setElement(e);
		return element;
	}
	
	/** toString method */
	public String toString() {
		String s = "[";
		DNode<E> dNode = header.getNext();
		for (int i=0; i<size(); i++) {
			s += dNode.element();
			if (i < size() - 1) {
				s += ", ";
			}
			dNode = dNode.getNext();
		}
		return s + "]";
	}
	
}
