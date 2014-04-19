/*
 * QueueTest.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rainicy.chapter5.queue.ArrayQueue;

/**
 * The testing cases for testing Queue class.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class QueueTest {
	public static void main(String[] args) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		ArrayQueue<String> Q = null;
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("1.New Queue\n2.Add\n"
					+ "3.Remove\n4.Show the peak\n5.Show\n0.Exit");
			String choice = null;
			choice = bufferedReader.readLine();
			switch (choice) {
			case "1":
				Q = new ArrayQueue<String> ();
				System.out.println("New Queue: " + Q.toString());
				break;
			case "2":
				if (Q == null) {
					System.out.println("Please new a queue first");
					continue;
				}
				System.out.println("Please input an string element");
				String element = bufferedReader.readLine();
				Q.add(element);
				System.out.println(Q.toString());
				break;
			case "3":
				if (Q == null) {
					System.out.println("Please new a queue first");
					continue;
				}
				String removed = Q.remove();
				System.out.println("The removed element: " + removed);
				System.out.println(Q.toString());
				break;
			case "4":
				if (Q == null) {
					System.out.println("Please new a queue first");
					continue;
				}
				String peek = Q.peek();
				System.out.println("The peek element: " + peek);
				break;
			case "5":
				if (Q == null) {
					System.out.println("Please new a queue first");
					continue;
				}
				System.out.println(Q.toString());
				break;
			case "0":
				isLoop = false;
				System.out.println("Thank you!");
				break;
			}
		}
	}
}
