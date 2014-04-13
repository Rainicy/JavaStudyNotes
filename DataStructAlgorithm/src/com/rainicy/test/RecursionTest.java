/*
 * Recursion.java
 * 
 * Date: April 11, 2014
 */
package com.rainicy.test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.Arrays;

import com.rainicy.chapter3.recursion.Factorial;
import com.rainicy.chapter3.recursion.EnglishRuler;
import com.rainicy.chapter3.recursion.Array;
import com.rainicy.chapter3.recursion.Fibonacci;


/** 
 * This the class for testing Recursive function
 * @author Rainicy
 *
 */
public class RecursionTest {
	/** main function */
	public static void main (String[] args) {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		System.out.println("1.Recursive factorial\n2.Draw ruler\n"
				+ "3.Sum & Reverse\n4.Fibonacci\n0.Exit");
		String choice = null;
		try {
			choice = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (choice) {
		case "1":
			factorialTest();
			break;
		case "2":
			drawRulerTest();
			break;
		case "3":
			sumAndReverseArray();
			break;
		case "4":
			fibonacci();
			break;
		case "0":
			System.out.println("Thank you!");
			break;
		default:
			break;
		}
	}

	private static void fibonacci() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("1.Input number:\n0.Exit");
			String choice = null;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (choice) {
			case "1":
				System.out.println("Input an integer:\n");
				String string = null;
				try {
					string = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int number = Integer.parseInt(string);
				System.out.println("Fibonacci using Binary is: " + 
								Fibonacci.BinaryFib(number));
				System.out.println("Fibonacci using Linear is: " +
								Fibonacci.linearFib(number));
				break;
			case "0":
				isLoop = false;
				System.out.println("Thank you for using!");
				break;
			default:
				System.out.println("Wrong choise! Please choice again.");
				break;
			}
		}
		
	}

	private static void sumAndReverseArray() {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		System.out.println("The numbers are: " + Arrays.toString(numbers));
		int sum = Array.linearSum(numbers, numbers.length);
		System.out.println("Sum result: " + sum);
		
		String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8"};
		System.out.println("The strings are: " + Arrays.toString(strings));
		Array.reverse(strings, 0, strings.length-1);
		System.out.println("The reversed strings:" + Arrays.toString(strings));
		
	}

	private static void drawRulerTest() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("1.Draw ruler\n0.Exit");
			String choice = null;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (choice) {
			case "1":
				String stringInch = null;
				String stringLength = null;
				System.out.println("Input inches:");
				try {
					stringInch = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("Input major length:");
				try {
					stringLength = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int inch  = Integer.parseInt(stringInch);
				int length = Integer.parseInt(stringLength);
				EnglishRuler ruler = new EnglishRuler(inch, length);
				ruler.drawRuler();
				break;
			case "0":
				isLoop = false;
				System.out.println("Thank you for using Draw Ruler.");
				break;
			default: 
				System.out.println("Wrong Choice! Please input again.");
				break;
			}
		}
	}

	private static void factorialTest() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("1.Calculate factorial\n0.Exit");
			String choice = null;
			try {
				choice = bufferedReader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			switch (choice) {
			case "1":
				System.out.println("Input an integer:\n");
				String string = null;
				try {
					string = bufferedReader.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				int number = Integer.parseInt(string);
				System.out.println("Factorial of " + number + " is: " + 
								Factorial.recursiveFactorial(number));
				break;
			case "0":
				isLoop = false;
				System.out.println("Thank you for using!");
				break;
			default:
				System.out.println("Wrong choise! Please choice again.");
				break;
			}
		}
	}
}
