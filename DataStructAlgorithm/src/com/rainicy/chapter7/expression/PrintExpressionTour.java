/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.expression;

import  com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter7.tree.BinaryTree;
import com.rainicy.chapter7.tree.EulerTour;

/**
 * Print out the expression stored in an arithmetic expression
 * tree.
 */
public class PrintExpressionTour extends EulerTour<ExpressionTerm, String>{
    @Override
    public String execute(BinaryTree<ExpressionTerm> binaryTree) {
        init(binaryTree);
        System.out.print("Expresson: ");
        eulerTour(binaryTree.root());
        System.out.println();
        return null;
    }

    @Override
    protected void visitLeft(Position<ExpressionTerm> v, TourResult<String> r) {
        if (tree.isInternal(v)) {
            System.out.print("(");
        }
    }

    @Override
    protected void visitBelow(Position<ExpressionTerm> v, TourResult<String> r) {
        System.out.print(v.element());
    }

    @Override
    protected void visitRight(Position<ExpressionTerm> v, TourResult<String> r) {
        if (tree.isInternal(v)) {
            System.out.print(")");
        }
    }
}
