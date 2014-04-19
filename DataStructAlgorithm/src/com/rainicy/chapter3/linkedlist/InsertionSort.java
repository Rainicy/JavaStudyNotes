/*
 * InsertionSort.java
 *	
 * Version: 2.0
 * 
 * Date: March 23, 2014
 */
package com.rainicy.chapter3.linkedlist;

/**
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
 * @version 2.0
 * @author Rainicy
 */
public class InsertionSort {
	/** Default Constructor */
	public InsertionSort() {	
	}
	
	/** Insertion sort of an Doubly Linked List into non-decreasing order */
	public static <E extends Comparable<E>> void sort (DList<E> dList) {
		if (dList.getSize() <= 1) {
			return;
		}
		DNode<E> endNode = dList.getFirst();
		DNode<E> pivotNode;
		DNode<E> insertNode;
		while (endNode != dList.getLast()) {
			pivotNode = endNode.getNext();	// Put pivot node to the left
			dList.remove(pivotNode);	// Remove it in the list
			insertNode = endNode;
			while (insertNode != dList.getHeader() &&
				insertNode.getElement().compareTo(pivotNode.getElement())>0) {
				insertNode = insertNode.getPrev();
			}
			dList.addAfter(insertNode, pivotNode);
			// if the pivot position is not changed
			if (insertNode == endNode) {
				endNode = endNode.getNext();
			}
		}
	}

}

