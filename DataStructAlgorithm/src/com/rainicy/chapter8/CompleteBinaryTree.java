/*
 * CompleteBinaryTree.java
 *
 * Created on July 8, 2014.
 */
package com.rainicy.chapter8;

import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter7.tree.BinaryTree;

/**
 * An interface for a complete binary tree.
 *
 * Description on:
 * http://en.wikipedia.org/wiki/Binary_tree
 *
 * @version 1.0
 * @author Rainicy
 *
 */
public interface CompleteBinaryTree<E> extends BinaryTree<E> {

    /**
     * Adds an element to the tree just after the last node.
     * Returns the newly created position.
     */
    public Position<E> add(E element);

    /**
     * Removes and returns the element stored in the last node
     * of the tree.
     */
    public E remove();
}
