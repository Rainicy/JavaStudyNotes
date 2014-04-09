/*
 * ListInsertionSortTest.java
 * 
 * Date: April 8, 2014
 */
package com.rainicy.test;

import com.rainicy.chapter3.linkedlist.DNode;
import com.rainicy.chapter3.linkedlist.DList;
import com.rainicy.chapter3.linkedlist.InsertionSort;

/**
 * This class for testing doubly linked list class.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ListInsertionSortTest {
	public static void main(String[] args) {
		String[] strings = {"wo", "zhen", "bu", "zhi", "dao", "!"};
		DList dList = new DList();
		for (String string : strings) {
			DNode dNode = new DNode(string, null, null);
			dList.addLast(dNode);
		}
		System.out.println("The unsorted list:\n" + dList.toString());
		InsertionSort.sort(dList);
		System.out.println("The sorted list:\n" + dList.toString());
	}
}
