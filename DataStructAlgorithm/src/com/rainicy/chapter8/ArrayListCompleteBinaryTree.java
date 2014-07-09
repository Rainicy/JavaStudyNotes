/*
 * ArrayListCompleteBinaryTree.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

import com.rainicy.chapter6.arraylist.BoundaryViolationException;
import com.rainicy.chapter6.arraylist.InvalidPositionException;
import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter6.arraylist.PositionList;
import com.rainicy.chapter7.tree.EmptyTreeException;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An implementation of the CompleteBinaryTree interface using
 * Array list.
 *
 * In the array list, the position 0 is null. and the root of the
 * tree is at the position 1.
 *
 * So left(i) = 2*i, right(i) = 2*i + 1.
 *
 * @version 1.0
 * @author Rainicy
 */

public class ArrayListCompleteBinaryTree<E> implements CompleteBinaryTree<E> {

    /** indexed list of tree positions */
    protected ArrayList<BTPos<E>> T;
    /** Nested class for a index list-based complete binary tree node. */
    protected static class BTPos<E> implements Position<E> {
        E element;
        int index;

        public BTPos(E ele, int i) {
            element = ele;
            index = i;
        }

        @Override
        public E element() {
            return element;
        }

        public int index() {
            return index;
        }

        // set current element by given new element and returns the old one.
        public E setElement(E ele) {
            E temp = element;
            element = ele;
            return temp;
        }

        public String toString() {
            return ("[" + element + ", " + index + "]");
        }
    }

    /** default constructor */
    public ArrayListCompleteBinaryTree() {
        T = new ArrayList<BTPos<E>>();
        T.add(0, null);
    }

    @Override
    public Position<E> add(E element) {
        int i = size() + 1;
        BTPos<E> pos = new BTPos<E> (element, i);
        T.add(i, pos);
        return pos;
    }

    @Override
    public E remove() {
        if(isEmpty()) {
            throw new EmptyTreeException("Tree is empty.");
        }
        return T.remove(size()).element();
    }

    @Override
    public Position<E> left(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException
    {
        if (!hasLeft(v)) {
            throw new BoundaryViolationException("No left child.");
        }
        BTPos<E> pos = checkPosition(v);
        return T.get(2*pos.index());
    }

    @Override
    public Position<E> right(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException
    {
        if (!hasRight(v)) {
            throw new BoundaryViolationException("No right child");
        }
        BTPos<E> pos = checkPosition(v);
        return T.get(2*pos.index()+1);
    }

    @Override
    public boolean hasLeft(Position<E> v) throws InvalidPositionException {
        BTPos<E> pos = checkPosition(v);
        return 2*pos.index() <= size();
    }

    @Override
    public boolean hasRight(Position<E> v) throws InvalidPositionException {
        BTPos<E> pos = checkPosition(v);
        return 2*pos.index()+1 <= size();
    }

    @Override
    public int size() {
        return T.size() - 1;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    /** Returns an iterator of all elements stored at all nodes.*/
    public Iterator<E> iterator() {
        ArrayList<E> list = new ArrayList<E>();
        Iterator<BTPos<E>> iter = T.iterator();
        iter.next();
        while (iter.hasNext()) {
            list.add(iter.next().element());
        }
        return list.iterator();
    }

    @Override
    /** Returns an iterable collection of all the nodes. */
    public Iterable<Position<E>> positions() {
        ArrayList<Position<E>> P = new ArrayList<Position<E>>();
        Iterator<BTPos<E>> iter = T.iterator();
        iter.next();
        while (iter.hasNext()) {
            P.add(iter.next());
        }
        return P;
    }

    @Override
    public E replace(Position<E> v, E e) throws InvalidPositionException {
        BTPos<E> pos = checkPosition(v);
        return pos.setElement(e);
    }

    @Override
    public Position<E> root() throws EmptyTreeException {
        if (isEmpty()) {
            throw new EmptyTreeException("Tree is empty");
        }
        return T.get(1);
    }

    @Override
    public Position<E> parent(Position<E> v)
            throws InvalidPositionException, BoundaryViolationException
    {
        if (isRoot(v)) {
            throw new BoundaryViolationException("No parent for root.");
        }
        BTPos<E> pos = checkPosition(v);
        return T.get(pos.index()/2);
    }

    @Override
    public Iterable<Position<E>> children(Position<E> v)
            throws InvalidPositionException
    {
        PositionList<Position<E>> children = new NodePositionList<Position<E>>();
        if (hasLeft(v)) {
            children.addLast(left(v));
        }
        if (hasRight(v)) {
            children.addLast(right(v));
        }
        return children;
    }

    @Override
    public boolean isExternal(Position<E> v) throws InvalidPositionException {
        return !isInternal(v);
    }

    @Override
    public boolean isInternal(Position<E> v) throws InvalidPositionException {
        return hasLeft(v);
    }

    @Override
    public boolean isRoot(Position<E> v) throws InvalidPositionException {
        BTPos<E> pos = checkPosition(v);
        return pos.index() == 1;
    }

    /** Determines whether the given position is a valid node. */
    protected  BTPos<E> checkPosition(Position<E> v)
        throws  InvalidPositionException
    {
        if (v==null || !(v instanceof BTPos)) {
            throw new InvalidPositionException("Position is invalid.");
        }
        return (BTPos<E>) v;
    }

    /** Returns a String */
    public String toString() {
        return T.toString();
    }
}
