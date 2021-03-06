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
import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter6.arraylist.PositionList;

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
		Iterable<Position<E>> positions = positions();
		PositionList<E> elements = new NodePositionList<E>(); 
		for (Position<E> pos : positions) {
			elements.addLast(pos.element());
		}
		return elements.iterator();
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> pL = new NodePositionList<Position<E>>();
		if (size != 0) {
			preorderPositions(root(), pL);
		}
		return pL;
	}

	@Override
	public E replace(Position<E> v, E e) throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		E temp = v.element();
		btV.setElement(e);
		return temp;
	}

	@Override
	public Position<E> root() throws EmptyTreeException {
		if (root == null){
			throw new EmptyTreeException("The tree is empty.");
		}
		return root;
	}

	@Override
	public Position<E> parent(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		BTPosition<E> btV = checkPosition(v);
		Position<E> p = btV.getParent();
		if (p == null) {
			throw new BoundaryViolationException("No parent.");
		}
		return p;
	}

	@Override
	public Iterable<Position<E>> children(Position<E> v)
			throws InvalidPositionException {
		PositionList<Position<E>> pL = new NodePositionList<Position<E>>();
		if (hasLeft(v)) {
			pL.addLast(left(v));
		}
		if (hasRight(v)) {
			pL.addLast(right(v));
		}
		return pL;
	}

	@Override
	public boolean isExternal(Position<E> v) throws InvalidPositionException {
		return !isInternal(v);
	}

	@Override
	public boolean isInternal(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (hasLeft(v) || hasRight(v));
	}

	@Override
	public boolean isRoot(Position<E> v) throws InvalidPositionException {
		checkPosition(v);
		return (v == root);
	}

	@Override
	public Position<E> left(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		BTPosition<E> btV = checkPosition(v);
		Position<E> p = btV.getLeft();
		if (p == null) {
			throw new BoundaryViolationException("No left child.");
		}
		return p;
	}

	@Override
	public Position<E> right(Position<E> v) throws InvalidPositionException,
			BoundaryViolationException {
		BTPosition<E> btV = checkPosition(v);
		Position<E> p = btV.getRight();
		if (p == null) {
			throw new BoundaryViolationException("No right child.");
		}
		return p;
	}

	@Override
	public boolean hasLeft(Position<E> v) throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		return (btV.getLeft() != null);
	}

	@Override
	public boolean hasRight(Position<E> v) throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		return (btV.getRight() != null);
	}
	
	/**
	 * Return the sibling of the given node
	 */
	public Position<E> sibling (Position<E> v) 
		throws InvalidPositionException, BoundaryViolationException {
		BTPosition<E> btV = checkPosition(v);
		BTPosition<E> parent = btV.getParent();
		
		if (parent != null) {
			BTPosition<E> sibling;
			BTPosition<E> left = parent.getLeft();
			if (left == btV) {
				sibling = parent.getRight();
			}
			else {
				sibling = parent.getLeft();
			}
			if (sibling != null) {
				return sibling;
			}
		}
		throw new BoundaryViolationException ("No sibling.");	
	}
	
	/** Add a root node to the empty tree. */
	public Position<E> addRoot(E e) throws NonEmptyTreeException {
		if (!isEmpty()) {
			throw new NonEmptyTreeException("Tree already has a root.");
		}
		size = 1;
		root = new BTNode<E>(e, null, null, null);
		return root;
	}
	
	/** Inserts a left child by given node. */
	public Position<E> insertLeft(Position<E> v, E e) 
			throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		Position<E> left  = btV.getLeft();
		if (left != null) {
			throw new InvalidPositionException("Node already has left child.");
		}
		BTPosition<E> newLeft = new BTNode<E>(e, btV, null, null);
		btV.setLeft(newLeft);
		size++;
		return newLeft;
	}
	
	/** Inserts a right child by given node. */
	public Position<E> insertRight(Position<E> v, E e) 
			throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		Position<E> right  = btV.getRight();
		if (right != null) {
			throw new InvalidPositionException("Node already has left child.");
		}
		BTPosition<E> newRight = new BTNode<E>(e, btV, null, null);
		btV.setRight(newRight);
		size++;
		return newRight;
	}
	
	/** Remove a node with 0 or 1 child. 
	 * Don't remove the node with two children 
	 */
	public E remove(Position<E> v) 
		throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		BTPosition<E> left = btV.getLeft();
		BTPosition<E> right = btV.getRight();
		// if get two children
		if ((left != null) && (right != null)) {
			throw new InvalidPositionException("Cannot remove the node "
					+ "with two children");
		}
		// if 0 or 1 child
		BTPosition<E> newV = null;
		if (left != null) {
			newV = left;
		}
		else if (right != null) {
			newV = right;
		}
		else {
			newV = null;
		}
		// if the removing node is root
		if (btV == root()) {
			if (newV != null) {
				newV.setParent(null);
			}
			root = newV;
		}
		// the removing node is not root
		else {
			BTPosition<E> parent = btV.getParent();
			if (newV != null) {
				newV.setParent(parent);
			}
			// the removing node is the left child
			if (btV == parent.getLeft()) {
				parent.setLeft(newV);
			}
			else {
				parent.setRight(newV);
			}
		}
		size--;
		return btV.element();
	}
	
	/** Attaches two trees to be subtrees of an external node */
	public void attach (Position<E> v, BinaryTree<E> leftTree, BinaryTree<E> rightTree)
		throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		if (isInternal(btV)) {
			throw new InvalidPositionException("Cannot attach from "
					+ "an internal node.");
		}
		// check left tree and right tree
		if (!leftTree.isEmpty()) {
			BTPosition<E> leftNode = checkPosition(leftTree.root());
			btV.setLeft(leftNode);
			leftNode.setParent(btV);
		}
		if (!rightTree.isEmpty()) {
			BTPosition<E> rightNode = checkPosition(rightTree.root());
			btV.setRight(rightNode);
			rightNode.setParent(btV);
		}
	}
	
	/** Swap two elements between two nodes */
	public void swapElements (Position<E> v1, Position<E> v2) {
		BTPosition<E> btV1 = checkPosition(v1);
		BTPosition<E> btV2 = checkPosition(v2);
		// swap
		E temp = btV1.element();
		btV1.setElement(btV2.element());
		btV2.setElement(temp);
	}
	
	/** Expand an external node into an internal node with two external 
	 *  node children.
	 */
	public void expandExternal (Position<E> v, E left, E right) 
		throws InvalidPositionException {
		BTPosition<E> btV = checkPosition(v);
		if (!isExternal(btV)) {
			throw new InvalidPositionException("Node should be an external");
		}
		insertLeft(btV, left);
		insertRight(btV, right);
	}

    /** Remove an external node v and replace its parent with v's sibling */
    public void removeAboveExternal(Position<E> v)
            throws InvalidPositionException
    {
        if (!isExternal(v)) {
            throw new InvalidPositionException("Node should be external.");
        }
        if (isRoot(v)) {
            remove(v);
        }
        else {
            Position<E> p = parent(v);
            remove(v);
            remove(p);
        }
    }
	
	
	/** If given v is a good tree node, cast to BTPosition, otherwise
	 *  throw exception 
	 */
	protected BTPosition<E> checkPosition (Position<E> v)
		throws InvalidPositionException {
		if (v == null || !(v instanceof BTPosition)) {
			throw new InvalidPositionException("The position is invalid.");
		}
		return (BTPosition<E>) v;
	}
		
	/**
	 * Creates a list storing the nodes in the subtree of a node,
	 * ordered according to the preorder traversal of the subtree.
	 */
	protected void preorderPositions (Position<E> v, PositionList<Position<E>> pL) 
		throws InvalidPositionException {
		pL.addLast(v);
		if (hasLeft(v)) {
			preorderPositions(left(v), pL);
		}
		if (hasRight(v)) {
			preorderPositions(right(v), pL);
		}
	}		
}
