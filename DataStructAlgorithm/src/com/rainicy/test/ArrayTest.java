/*
 * ArrayTest.java 
 * 
 * Version: 1.0
 * 
 * Date: March 24, 2014
 */
package com.rainicy.test;

import java.text.DecimalFormat;
import java.util.Random;

import com.rainicy.chapter3.array.InsertionSort;
import com.rainicy.chapter3.array.BubbleSort;

/**
 * ArrayTest is the class for testing the classes in package
 * "com.rainicy.chapter3.array". The testing cases are for BubbleSort and
 * InsertionSort.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ArrayTest {
	
	/** The decimal format for time */
	private static final DecimalFormat FORMAT_TIME = new DecimalFormat("#.###");
	/** The size for the creating array */ 
	private static final int SIZE_ARRAY = 10000;
	/** The size for testing cases */
	private static final int SIZE_CASES = 3;
	
	/** If show the sorted results */ 
	private static final boolean IF_SHOW_RESULT = false;
	/** If show the comparison among different sorting algorithms */
	private static final boolean IF_SHOW_COMPARISON = true;
	/** If check the results after the sorting */
	private static final boolean IF_CHECK_RESULTS = true;
	
	/** 
	 * The count of insertion sorting results will be saved, 
	 * if show comparison. 
	 */
	private static int countInsertionResults = 0;
	/**
	 * The count of bubble sorting results will be saved, 
	 * if show comparison.
	 */
	private static int countBubbleResults = 0;
	/** For saving insertion running time results */
	private static final double[] insertionResults = new double[SIZE_CASES];
	/** For saving bubble running time results */
	private static final double[] bubbleResults = new double[SIZE_CASES];
	
	/** If run the insertion sorting algorithm */
	private static final boolean IF_RUN_INSERTION = true;
	/** If run the bubble sorting algorithm */
	private static final boolean IF_RUN_BUBBLE = true;
	
	/** A random int array for testing */
	private static int[] unsorted;
	/** A already sorted int array for testing */
	private static int[] sorted;
	/** A reversed int array for testing */
	private static int[] reverse;
	
	/** Main method for sorting algorithms testing */
	public static void main (String[] args) {
		
		// Generate random array for testing
		System.out.println ("Generating random array...");
		Random random = new Random();
		unsorted = new int[SIZE_ARRAY];
		for (int i=0; i<unsorted.length; ++i) {
			int randomInt = random.nextInt (unsorted.length * 10);
			unsorted[i] = randomInt;
		}
		System.out.println("Generated random array!");
		
		// Generate a sorted array
		System.out.println("Generating sorted array...");
		sorted = new int[SIZE_ARRAY];
		for (int i=0; i<sorted.length; i++) {
			sorted[i] = i;
		}
		System.out.println("Generated sorted array!");
		
		// Generated a reversed sorted array
		System.out.println("Generating reversed sorted array");
		reverse = new int[SIZE_ARRAY];
		for (int i=0; i<reverse.length; i++) {
			reverse[i] = reverse.length - i - 1;
		}
		System.out.println("Generated reversed sorted array");
		System.out.println();
		System.out.flush();
		
		// Run sorting algorithms
		System.out.println("Starting sorting...");
		System.out.println();
		System.out.flush();
		// If run insertion sorting
		if (IF_RUN_INSERTION) {
			// testing on random array 
			long startTime = System.nanoTime();
			// pass a copy of the array
			int[] result = InsertionSort.sort(unsorted.clone());
			long estimatedTime = System.nanoTime() - startTime;
			if (IF_CHECK_RESULTS) {
				System.out.println("Checking the results on insertion sort");
				if (!checkSorted(result)) {
					System.err.println("InsertionSort failed.");
				}
			}
			// Output running time 
			double timeInSecond = estimatedTime / 1000000d / 1000d;
			System.out.println ("InsertionSort on Random Array take: " + 
					FORMAT_TIME.format(timeInSecond));
			if (IF_SHOW_RESULT) {
				showResult (unsorted, result);
			}
			if (IF_SHOW_COMPARISON) {
				insertionResults[countInsertionResults] = timeInSecond;
			}
			System.gc();
		}
		
	}

	private static void showResult(int[] unsorted2, int[] result) {
		// TODO Auto-generated method stub
		
	}

	private static boolean checkSorted(int[] result) {
		// TODO Auto-generated method stub
		return false;
	}
}
