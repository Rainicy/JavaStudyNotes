/*
 * SinglyLinkedListTest.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.test;

import com.rainicy.chapter3.linkedlist.Node;
import com.rainicy.chapter3.linkedlist.SinglyLinkedList;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/**
 * This class for testing singly linked list. Implement basic 
 * UI functions.
 * 
 * @version 2.0
 * @author Rainicy
 *
 */
public class SinglyLinkedListTest {
	/** Operators for testing singly linked list */
	public enum Operators {
		ADDFIRST("1"), ADDLAST("2"), REMOVEFIRST("3"), SHOW("4"),
		SHOWSIZE("5"), EXIT("0");
		String choice;
		Operators(String choice) {
			this.choice = choice;
		}
	}
	public static void main(String[] args)
		throws IOException
	{
		SinglyLinkedList<String> singlyLinkedList = new 
													SinglyLinkedList<String>();
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader (inputStreamReader);
		boolean isLoop = true;
		while (isLoop) {
			print("1.Add First\n2.Add Last\n3.Remove First\n4.Show\n"
					+ "5.Show size\n0.Exit\n");
			String choice;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				throw new IOException("Input choice!");
			}
			String element;	// Insert node's element
			Node<String> node;	// Insert node
			switch (choice) {
			case "1": 
				print("Insert element values: ");
				element = bufferedReader.readLine();
				node = new Node<String>(element, null);
				singlyLinkedList.addFirst(node);
				break;
			case "2":
				print("Insert element values: ");
				element = bufferedReader.readLine();
				node = new Node<String>(element, null);
				singlyLinkedList.addLast(node);
				break;
			case "3":
				print("Before remove first node:");
				print(singlyLinkedList.toString());
				singlyLinkedList.removeFirst();
				print("After remove the first node:");
				print(singlyLinkedList.toString());
				break;
			case "4":
				print(singlyLinkedList.toString());
				break;
			case "5":
				print("List Size: " + singlyLinkedList.getSize());
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

