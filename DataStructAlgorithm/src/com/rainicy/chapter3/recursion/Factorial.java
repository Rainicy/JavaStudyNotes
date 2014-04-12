/*
 * Factorial.java
 * 
 * Date: April 11, 2014
 */
package com.rainicy.chapter3.recursion;


/**
 * Factorial is to implement to calculate the result of n!.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class Factorial {
	/** Recursive factorial function */
	public static int recursiveFactorial (int n) 
		throws IllegalArgumentException
	{
		if (n < 0) {
			throw new IllegalArgumentException("The input error");
		}
		if (n == 0) {
			return 1;
		}
		else {
			return n * recursiveFactorial(n-1);
		}
	}
}
