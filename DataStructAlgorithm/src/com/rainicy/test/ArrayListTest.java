/*
 * ArrayListTest.java
 * 
 * Date: April 20, 2014
 */
package com.rainicy.test;

import com.rainicy.chapter6.arraylist.ArrayIndexList;

/**
 * Testing cases for array index list.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ArrayListTest {
	public static void main(String[] args) {
		ArrayIndexList<String> A = new ArrayIndexList<String>();
		System.out.println("Initial A: " + A.toString());
		A.add(0, "Wo");
		System.out.println("A.add(0,Wo): " + A.toString());
		A.add(0, "Women"); 
		System.out.println("A.add(0,Women): " + A.toString());
		A.add(1, "Bu");
		System.out.println("A.add(1,Bu): " + A.toString());
		A.add(3, "Zhi");
		System.out.println("A.add(3,Zhi): " + A.toString());
		String s = A.get(2);
		System.out.println("A.get(2): " + s + "\t" + A.toString());
		s = A.remove(2);
		System.out.println("A.remove(2): " + s + "\t" + A.toString());
		A.add(3, "Dao");
		A.add(4, "!");
		A.set(3, "dao");
		System.out.println(A.toString());
	}
}
