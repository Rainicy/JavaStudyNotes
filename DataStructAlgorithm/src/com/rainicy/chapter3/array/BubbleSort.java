/*
 * BubbleSort.java
 * 
 * Version: 1.0
 * 
 * Date: March 23, 2014
 */
package com.rainicy.chapter3.array;

/**
 * Bubble sort is a simple sorting algorithm that works by repeatedly stepping
 * through the list to be sorted, comparing each pair of adjacent items and
 * swapping them if they are in the wrong order. The pass through the list is
 * repeated until no swaps are needed, which indicates that the list is sorted.
 * 
 * Complexity:	1) Average case: O(n^2)
 * 				2) Worst case: O(n^2)
 * 				3) Best case: O(n)
 * 
 * In-place
 * Stable: Yes
 * 
 * From: http://en.wikipedia.org/wiki/Bubble_sort
 * 
 * @version 1.0
 * @author Rainicy
 */
public class BubbleSort {
	/** Defaulted constructor */
	public BubbleSort() {
	}
	
	/** Bubble sort of an unsorted array into non-decreasing order */
	public static int[] sort (int[] unsorted) {
		int length = unsorted.length;
		for (int i=length-1; i>0; i--) {	// loop length-1 times
			for (int j=0; j<i; j++) {
				if (unsorted[j] > unsorted[j+1]) {	// move bigger one to right
					swap (j, j+1, unsorted);
				}
			}
		}
		return unsorted;
	}
	
	/** Swap two cells in an array by given two indexes */
	private static void swap (int index1, int index2, int[] unsorted) {
		int temp = unsorted[index2];
		unsorted[index2] = unsorted[index1];
		unsorted[index1] = temp;
	}
}
