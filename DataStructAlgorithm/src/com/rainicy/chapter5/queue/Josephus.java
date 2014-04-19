/*
 * Josephus.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.chapter5.queue;

/**
 * Playing a Josephus Game, with starting N people,
 * and eliminate every k-th one. Until the last one survivor. 
 * 
 * @version 1.0
 * @author Rainicy
 */
public class Josephus {
	/** Solution of the Josephus problem using a queue */
	public static <E> E Josephus(Queue<E> Q, int k) {
		if (Q.isEmpty()) {
			return null;
		}
		int count = 1;
		while (Q.size() > 1) {
			System.out.println("Queue: " + Q + " K = " + k);
			for (int i=0; i<k; i++) {
				Q.add(Q.remove());
			}
			E e = Q.remove();
			System.out.println((count++) + ". " + e + "\tis out!");
		}
		return Q.remove();
	}
	
	/** Build a queue from an array of objects */
	public static <E> Queue<E> buildQueue(E array[]) {
		Queue<E> Q = new NodeQueue<E>();
		for (int i=0; i<array.length; i++) {
			Q.add(array[i]);
		}
		return Q;
	}
	
	/** Tester method */
	public static void main(String[] args) {
		String[] s1 = {"Wo", "Zhen", "Bu", "Zhi", "Dao", "A", "!"};
		String[] s2 = {"Mike", "Robert"};
		System.out.println("Winner is " + Josephus(buildQueue(s1), 3));
		System.out.println("Winner is " + Josephus(buildQueue(s2), 7));
	}
}
