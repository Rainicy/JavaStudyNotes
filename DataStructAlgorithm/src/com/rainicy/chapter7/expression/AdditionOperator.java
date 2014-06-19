/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.expression;

/**
 * Class for addition operator in an arithmetic expression.
 */
public class AdditionOperator extends ExpressionOperator {

    /** Get value */
    public Integer getValue() {
        // unboxing and then autoboxing
        return (firstOperand + secondOperand);
    }

    public String toString() {
        return new String("+");
    }
}
