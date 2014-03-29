/*
 * RandomTest.java
 * 
 * Version: 1.0
 * 
 * Date: March 29, 2014
 */
package com.rainicy.test;

import java.util.Arrays;
import java.util.Random;

/**
 * Program show some array and random uses.
 * 
 * @version 1.0
 * 
 * @author Rainicy
 */
public class RandomTest {
	public static void main (String[] args) {
		int[] number = new int[10];
		Random random = new Random();	// a pseudo-random number generator
		random.setSeed(System.currentTimeMillis());
		// fill the number array with pseudo-random numbers
		for (int i=0; i<number.length; i++) {
			number[i] = random.nextInt(100);
		}
		int[] unsorted = number.clone();
		System.out.println("arrays equal before sort: "
				+ Arrays.equals(number, unsorted));
		Arrays.sort(number);
		System.out.println("arrays equal after sort: " 
				+ Arrays.equals(number, unsorted));
		System.out.println("unsorted = " + Arrays.toString(unsorted));
		System.out.println("sorted   = " + Arrays.toString(number));
	}
}
