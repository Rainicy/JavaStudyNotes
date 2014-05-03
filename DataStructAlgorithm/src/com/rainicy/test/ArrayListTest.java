/*
 * ArrayListTest.java
 * 
 * Date: April 20, 2014
 */
package com.rainicy.test;

import java.util.Iterator;

import com.rainicy.chapter6.arraylist.ArrayIndexList;
import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.Position;

/**
 * Testing cases for array index list.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class ArrayListTest {
	public static void main(String[] args) {
		System.out.println("Testing ArrayIndexList....");
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
		
		System.out.println("\n\nTesting NodePositionList....");
		NodePositionList<String> B = new NodePositionList<String>();
		System.out.println("Initial NodePositionList B: " + B.toString());
		B.addLast("Wo");
		System.out.println("B.addLast(Wo): " + B.toString());
		B.addLast("Bu");
		System.out.println("B.addLast(Bu): " + B.toString());
		B.addFirst("Aha");
		System.out.println("B.addFirst(Aha): " + B.toString());
		Position<String> p = B.first();
		System.out.println("p = B.first()");
		B.addAfter(p, "After_Aha");
		System.out.println("B.addAfter(p, After_Aha): " + B.toString());
		Position<String> p1 = B.next(p);
		System.out.println("p1 = B.next(p)");
		B.addBefore(p1, "Aha1");
		System.out.println("B.addBefore(p1, Aha1): " + B.toString());
		B.set(p1, "BuAha");
		System.out.println("B.set(p1, BuAha): " + B.toString());
		B.addFirst("1. ");
		System.out.println("B.addFirst(1. ): " + B.toString());
		B.set(B.last(), "BUUU");
		System.out.println("B.set(B.last(), BUUU): " + B.toString());
		B.remove(B.last());
		System.out.println("B.remove(B.last()): " + B.toString());
		
		System.out.println("\n\nTesting iterator1....");
		for (Iterator<String> it = B.iterator(); it.hasNext(); ) {
			System.out.println(it.next());
		}
		System.out.println("\n\nTesting iterator2....");
		for (String ele : B) {
			System.out.println(ele);
		}
	}
}
