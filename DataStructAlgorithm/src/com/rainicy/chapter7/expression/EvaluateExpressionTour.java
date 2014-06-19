/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.expression;

import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter7.tree.BinaryTree;
import com.rainicy.chapter7.tree.EulerTour;
import com.sun.tools.internal.xjc.reader.gbind.Expression;

/**
 * Computing the value of the expression, extends from EulerTour.
 *
 * @see com.rainicy.chapter7.tree.EulerTour
 *
 * @version 1.0
 * @author Rainicy
 */
public class EvaluateExpressionTour extends EulerTour<ExpressionTerm, Integer>{

    @Override
    public Integer execute(BinaryTree<ExpressionTerm> binaryTree) {
        init(binaryTree);
        return eulerTour(tree.root());
    }

    @Override
    public void visitRight(Position<ExpressionTerm> v, TourResult<Integer> r) {
        ExpressionTerm term = v.element();

        if (tree.isInternal(v)) {
            ExpressionOperator op = (ExpressionOperator) term;
            op.setOperands(r.left, r.right);
        }
        r.out = term.getValue();
    }
}
