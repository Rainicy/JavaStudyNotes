/*
 * Created on June 19, 2014
 *
 * @author Rainicy
 */
package com.rainicy.chapter7.expression;

/**
 * Class for a variable of an arithmetic expression.
 *
 * @version 1.0
 * @author Rainicy
 */
public class ExpressionVariable extends ExpressionTerm {
    protected Integer variable;

    /** Constructor */
    public ExpressionVariable(Integer var) {
        variable = var;
    }

    /** Set value for variable. */
    public void setVariable(Integer var) {
        variable = var;
    }

    /** Get value */
    public Integer getVariable() {
        return variable;
    }

    /** toString */
    public String toString() {
        return variable.toString();
    }
}
