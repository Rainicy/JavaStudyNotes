/*
 * ListInsertionSortTest.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.test;

import com.rainicy.chapter3.linkedlist.DNode;
import com.rainicy.chapter3.linkedlist.DList;
import com.rainicy.chapter3.linkedlist.InsertionSort;

/**
 * This class for testing doubly linked list class with generic types
 * 
 * @version 2.0
 * @author Rainicy
 */
public class ListInsertionSortTest {
	public static void main(String[] args) {
		String[] strings = {"wo", "zhen", "bu", "zhi", "dao", "!"};
		DList<String> dList = new DList<String>();
		for (String string : strings) {
			DNode<String> dNode = new DNode<String>(string, null, null);
			dList.addLast(dNode);
		}
		System.out.println("The unsorted list:\n" + dList.toString());
		InsertionSort.sort(dList);
		System.out.println("The sorted list:\n" + dList.toString());
	}
}
