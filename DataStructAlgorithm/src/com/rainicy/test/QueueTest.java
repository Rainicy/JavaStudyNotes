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
import com.rainicy.chapter5.queue.NodeQueue;

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
		NodeQueue<String> nodeQ = null;
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("1.New Queue\n2.Add\n"
					+ "3.Remove\n4.Show the peak\n5.Show\n0.Exit");
			String choice = null;
			choice = bufferedReader.readLine();
			switch (choice) {
			case "1":
				Q = new ArrayQueue<String>();
				nodeQ = new NodeQueue<String>();
				System.out.println("New ArrayQueue: " + Q.toString());
				System.out.println("New NodeQueue: " + nodeQ.toString());
				break;
			case "2":
				if ((Q == null) || (nodeQ == null)) {
					System.out.println("Please New Queue first");
					continue;
				}
				System.out.println("Please input an string element");
				String element = bufferedReader.readLine();
				Q.add(element);
				nodeQ.add(element);
				System.out.println("ArrayQueue: " + Q.toString());
				System.out.println("NodeQueue: "+ nodeQ.toString());
				break;
			case "3":
				if ((Q == null) || (nodeQ == null)) {
					System.out.println("Please New Queue first");
					continue;
				}
				String removedQ = Q.remove();
				String removedNodeQ = nodeQ.remove();
				System.out.println("Removed ArrayQueue element: " + removedQ);
				System.out.println("Removed NodeQueue element" + removedNodeQ);
				System.out.println("ArrayQueue: " + Q.toString());
				System.out.println("NodeQueue: "+ nodeQ.toString());
				break;
			case "4":
				if ((Q == null) || (nodeQ == null)) {
					System.out.println("Please New Queue first");
					continue;
				}
				String peek = Q.peek();
				String peekNodeQ = nodeQ.peek();
				System.out.println("Peek ArrayQueue element: " + peek);
				System.out.println("Peek NodeQueue element: " + peekNodeQ);
				break;
			case "5":
				if ((Q == null) || (nodeQ == null)) {
					System.out.println("Please New Queue first");
					continue;
				}
				System.out.println("ArrayQueue: " + Q.toString());
				System.out.println("NodeQueue: "+ nodeQ.toString());
				break;
			case "0":
				isLoop = false;
				System.out.println("Thank you!");
				break;
			}
		}
	}
}
