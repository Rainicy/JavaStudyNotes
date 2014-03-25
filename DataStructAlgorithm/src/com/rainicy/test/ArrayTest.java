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
	private static int countInsertionResults_ = 0;
	/**
	 * The count of bubble sorting results will be saved, 
	 * if show comparison.
	 */
	private static int countBubbleResults_ = 0;
	/** For saving insertion running time results */
	private static final double[] insertionResults = new double[SIZE_CASES];
	/** For saving bubble running time results */
	private static final double[] bubbleResults = new double[SIZE_CASES];
	
	/** If run the insertion sorting algorithm */
	private static final boolean IF_RUN_INSERTION = true;
	/** If run the bubble sorting algorithm */
	private static final boolean IF_RUN_BUBBLE = true;
	
	/** A random int array for testing */
	private static int[] unsorted_;
	/** A already sorted int array for testing */
	private static int[] sorted_;
	/** A reversed int array for testing */
	private static int[] reverse_;
	
	/** Main method for sorting algorithms testing */
	public static void main (String[] args) {
		// TODO 
	}
}
