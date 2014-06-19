/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.expression;

/**
 * Class for an operator of an arithmetic expression.
 *
 * @see com.rainicy.chapter7.expression.AdditionOperator
 *
 * @version 1.0
 * @author Rainicy
 */
public class ExpressionOperator extends ExpressionTerm {

    protected Integer firstOperand;
    protected Integer secondOperand;

    /** Set the operands */
    public void setOperands(Integer first, Integer second) {
        firstOperand = first;
        secondOperand = second;
    }
}
