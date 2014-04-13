/*
 * SumArray.java
 * 
 * Date: April 12, 2014
 */
package com.rainicy.chapter3.recursion;

/**
 * Uses recursion to handle array.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class Array {
	/**
	 * Use linear recursion to sum an array. 
	 * 
	 * @param array int type
	 * @param n sum until the n index
	 * 
	 * @return int sum result
	 */
	public static int linearSum(int[] array, int n) {
		if (n == 1) {
			return array[0];
		}
		else {
			return linearSum(array, n-1) + array[n-1];
		}
	}
	
	/** 
	 * Use linear to reverse an array
	 * 
	 * @param strings An array string
	 * @param i starting reverse position
	 * @param j ending reverse position
	 */
	public static void reverse(String[] strings, int i, int j) 
		throws IllegalArgumentException
	{
		if (i < 0 || j >= strings.length) {
			throw new IllegalArgumentException("Invalid start or end index.");
		}
		if (i < j) {
			String temp = strings[i];
			strings[i] = strings[j];
			strings[j] = temp;
			reverse(strings, i+1, j-1);
		}
	}
}
