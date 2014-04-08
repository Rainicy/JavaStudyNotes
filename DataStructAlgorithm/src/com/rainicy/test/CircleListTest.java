/*
 * CircleList.java
 * 
 * Date: April 7, 2014
 */
package com.rainicy.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rainicy.chapter3.linkedlist.Node;
import com.rainicy.chapter3.linkedlist.CircleList;


/**
 * This is the testing cases for circle list class, implemented by
 * very simple UI. 
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class CircleListTest {
	/** Operators for testing singly linked list */
	public enum Operators {
		ADD("1"), REMOVE("2"), ADVANCE("3"), SHOW("4"),
		SHOWSIZE("5"), EXIT("0");
		String choice;
		Operators(String choice) {
			this.choice = choice;
		}
	}
	public static void main(String[] args)
		throws IOException
	{
		CircleList circleList = new CircleList();
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
		boolean isLoop = true;
		while (isLoop) {
			print("1.Add\n2.Remove\n3.Anvance\n4.Show\n5.Show size\n0.Exit\n");
			String choice;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				throw new IOException("Input choice!");
			}
			String element;	// Insert node's element
			Node node;	// Insert node
			switch (choice) {
			case "1": 
				print("Insert element values: ");
				element = bufferedReader.readLine();
				node = new Node(element, null);
				circleList.add(node);
				break;
			case "2":
				print("Before remove first node:");
				print(circleList.toString());
				circleList.remove();
				print("After remove the first node:");
				print(circleList.toString());
				break;
			case "3":
				print("Before advance:");
				print(circleList.toString());
				circleList.advance();
				print("After advance:");
				print(circleList.toString());
				break;
			case "4":
				print(circleList.toString());
				break;
			case "5":
				print("List Size: " + circleList.size());
				break;
			case "0":
				isLoop = false;
				print("Thank you!");
				break;
			default:
				print("Wrong choice!");
				break;
			}
		}
	}
	
	
	public static void print (String string) {
		System.out.println(string);
	}
}
