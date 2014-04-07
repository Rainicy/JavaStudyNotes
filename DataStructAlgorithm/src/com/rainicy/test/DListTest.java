/*
 * DListTest.java
 * 
 * Version: 1.0
 * 
 * Date: April 6, 2014
 */
package com.rainicy.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rainicy.chapter3.linkedlist.DNode;
import com.rainicy.chapter3.linkedlist.DList;


/**
 * This is the testing cases for doubly linked list.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class DListTest {
	/** Operators for testing singly linked list */
	public enum Operators {
		ADDFIRST("1"), ADDLAST("2"), REMOVEFIRST("3"), REMOVELAST("4"),
		SHOW("5"), SHOWSIZE("6"), EXIT("0");
		String choice;
		Operators(String choice) {
			this.choice = choice;
		}
	}
	public static void main(String[] args)
		throws IOException
	{
		DList dList = new DList();
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
		boolean isLoop = true;
		while (isLoop) {
			print("\n1.Add First\n2.Add Last\n3.Remove First\n"
					+ "4.Remove Last\n5.Show\n6.Show size\n0.Exit\n\n");
			String choice;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				throw new IOException("Input choice!");
			}
			String element;	// Insert node's element
			DNode node;	// Insert node
			switch (choice) {
			case "1": 
				print("Insert element values: ");
				element = bufferedReader.readLine();
				node = new DNode(element, null, null);
				dList.addFirst(node);
				break;
			case "2":
				print("Insert element values: ");
				element = bufferedReader.readLine();
				node = new DNode(element, null, null);
				dList.addLast(node);
				break;
			case "3":
				print("Before remove first node:");
				print(dList.toString());
				dList.remove(dList.getNext(dList.getHeader()));
				print("After remove the first node:");
				print(dList.toString());
				break;
			case "4":
				print("Before remove first node:");
				print(dList.toString());
				dList.remove(dList.getPrev(dList.getTrailer()));
				print("After remove the last node:");
				print(dList.toString());
				break;
			case "5":
				print(dList.toString());
				break;
			case "6":
				print("List Size: " + dList.getSize());
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
