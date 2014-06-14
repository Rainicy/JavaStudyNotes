/*
 * LinkedBinaryTree.java
 * 
 * Created on June 13, 2014
 * 
 * @author
 */
package com.rainicy.chapter7.tree;

import java.util.Iterator;

import com.rainicy.chapter6.arraylist.BoundaryViolationException;
import com.rainicy.chapter6.arraylist.InvalidPositionException;
import com.rainicy.chapter6.arraylist.Position;

/**
 * Implementation of the BinryTree interface by means of a linked 
 * structure. 
 * 
 * @version 1.0
 * @author Rainicy
 */
public class LinkedBinaryTree<E> implements BinaryTree<E> {
	/** The root node of the tree. */
	protected BTPosition<E> root;
	
	/** Number of nodes in the tree. */
	protected int size;
	
	/** Default constructor without parameters. */
	public LinkedBinaryTree() {
		root = null;
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
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		// TODO Auto-generated method stub
		return false;
	}
}
