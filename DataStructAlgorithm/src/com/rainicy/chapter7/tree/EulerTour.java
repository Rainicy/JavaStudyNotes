/*
 * Created on June 16, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.tree;

import com.rainicy.chapter7.tree.BinaryTree;
import com.rainicy.chapter6.arraylist.Position;

public abstract class EulerTour<E, R> {
    /** a Binary Tree */
    protected BinaryTree<E> tree;

    /**
     * Execution of the traversal. This abstract method must be
     * specified in a concrete subclass.
     */
    public abstract R execute(BinaryTree<E> binaryTree);

    /** Initialization of the traversal */
    protected  void init(BinaryTree<E> binaryTree) {
        tree = binaryTree;
    }

    protected R eulerTour(Position<E> v) {
        TourResult<R> result = new TourResult<R>();
        visitLeft(v, result);
        if (tree.hasLeft(v)) {
            result.left = eulerTour(tree.left(v));
        }
        visitBelow(v, result);
        if (tree.hasRight(v)) {
            result.right = eulerTour(tree.right(v));
        }
        visitRight(v, result);

        return result.out;
    }

    /** Method called for the visit on the left. */
    protected void visitLeft(Position<E> v, TourResult<R> r) {}

    /** Method called for the visit on the below. */
    protected  void visitBelow(Position<E> v, TourResult<R> r) {}

    /** Method called for the visit on the right. */
    protected  void visitRight(Position<E> v, TourResult<R> r) {}

    /**
     * Class for the tour result
     */
    public class TourResult<R> {
        public R left;
        public R right;
        public R out;
    }
}


