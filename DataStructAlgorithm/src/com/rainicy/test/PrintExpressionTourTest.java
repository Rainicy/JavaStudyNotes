/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.test;

import com.rainicy.chapter7.expression.*;
import com.rainicy.chapter7.tree.BTNode;
import com.rainicy.chapter7.tree.BinaryTree;
import com.rainicy.chapter7.tree.LinkedBinaryTree;

/**
 * Testing cases for PrintExpressionTour class.
 *
 * @author Rainicy
 */
public class PrintExpressionTourTest {

    public static void main(String args[]) {
        // Build a linked binary tree.
        LinkedBinaryTree<ExpressionTerm> binaryTree = new LinkedBinaryTree<ExpressionTerm>();
        // 3 + 5
        // Initialize terms
        ExpressionTerm firstTerm = new ExpressionVariable(new Integer(3));
        ExpressionTerm secondTerm = new ExpressionVariable(new Integer(5));
        ExpressionOperator opTerm = new AdditionOperator();
//        opTerm.setOperands(firstTerm.getValue(), secondTerm.getValue());
        // build binary tree
        binaryTree.addRoot(opTerm);
        binaryTree.insertLeft(binaryTree.root(), firstTerm);
        binaryTree.insertRight(binaryTree.root(), secondTerm);

        // Initialize a printer
        PrintExpressionTour printer = new PrintExpressionTour();
        printer.execute(binaryTree);
        EvaluateExpressionTour calculator = new EvaluateExpressionTour();
        System.out.println(calculator.execute(binaryTree));
    }
}
