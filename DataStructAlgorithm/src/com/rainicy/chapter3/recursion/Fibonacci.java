/*
 * Fibonacci.java
 * 
 * Date: April 12, 2014
 */
package com.rainicy.chapter3.recursion;

/**
 * Fibonacci class implemented by different algorithms.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class Fibonacci {
	/**
	 * Binary recursion to implement.
	 * 
	 * @param n
	 * @return
	 */
	public static int BinaryFib (int n) {
		if (n <= 1) {
			return n;
		}
		else {
			return BinaryFib(n-1) + BinaryFib(n-2);
		}
	}
	
	/**
	 * Using linear recursion.
	 * @param n
	 * @return
	 */
	public static int linearFib (int n) {
		return linearFib(n, 1, 0);
	}
	
	public static int linearFib (int n, int value, int prev) {
		if (n == 0) {
			return prev;
		}
		else if (n ==1) {
			return value;
		}
		else {
			return linearFib(n-1, value+prev, value);
		}
	}
}
