/*
 * Power.java
 * 
 * Date: April 13
 */
package com.rainicy.chapter3.recursion;



/**
 * Using recursive function to calculate power.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class Power {
	/**
	 * O(N) recursive function
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double linearPower (double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		else {
			return base * linearPower(base, exponent-1);
		}
	}
	
	/**
	 * O(logN) recursive function
	 * @param base
	 * @param exponent
	 * @return
	 */
	public static double logarithmPower (double base, int exponent) {
		if (exponent == 0) {
			return 1;
		}
		else if ((exponent%2) == 1) {	// exponent is odd
			double temp = logarithmPower (base, exponent/2);
			return base * temp * temp;
		}
		else {	// exponent is even
			double temp = logarithmPower (base, exponent/2);
			return temp * temp;
		}
	}
}
