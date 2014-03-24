/*
 * InsertionSort.java
 *	
 * Version: 1.0
 *
 * Insertion sort is a simple sorting algorithm that builds the final sorted
 * array (or list) one item at a time. It is much less efficient on large lists
 * than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * 
 * Complexity:	1) Average case: O(n^2)	comparisons, swaps
 * 				2) Worst case: O(n^2)	comparisons, swaps
 * 				3) Best case: O(n) comparisons, O(1) swaps
 * 
 * In-place: only requires a constant amount O(1) of additional memory space
 * Stable: Yes
 * 
 * From: http://en.wikipedia.org/wiki/Insertion_sort
 * 
 * Date: March 23, 2014
 */
package com.chapter3.array;

/**
 * InsertionSort class will use insertion sort algorithm to sort an unsorted
 * int array.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class InsertionSort {
	/** Default Constructor */
	public InsertionSort() {	
	}
	
	/** Insertion sort of an array of int into non-decreasing order */
	public static int[] sort (int[] unsorted) {
		int length = unsorted.length;
		for (int i=1; i<length; i++) {	// index from the second character
			sort (i, unsorted);
		}
		return unsorted;
	}

	/** Insert the given index i to the left of sorted array */
	private static void sort(int i, int[] unsorted) {
		int insertInt = unsorted[i];	// the int to be inserted
		int j = i - 1;	// start comparing with cell left of i
		while ((j > 0) && (insertInt < unsorted[j])) {
			unsorted[j+1] = unsorted[j--];	// move cell right and decrement j 
		}
		unsorted[j+1] = insertInt;

	}

}
