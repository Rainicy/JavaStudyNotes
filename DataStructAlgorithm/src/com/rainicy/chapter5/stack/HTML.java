/*
 * HTML.java
 * 
 * Date: April 18, 2014
 */
package com.rainicy.chapter5.stack;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Simplified test of matching tags in an HTML document.
 * 
 * @version 1.0
 * @author Rainicy
 */
public class HTML {
	/** Strip the first and the end characters off a <tag> string */
	public static String stripEnds(String tag) {
		if (tag.length() <= 2) {
			return null;
		}
		return tag.substring(1, tag.length()-1);
	}
	
	/** Test if a stripped tag string is empty or a true opening tag */
	public static boolean isOpeningTag (String tag) {
		return (tag.length() == 0) || (tag.charAt(0) != '/');
	}
	
	/** Test if stripped tag1 matches closing tag2[first character is '/'] */
	public static boolean areMatchingTags (String tag1, String tag2) {
		return tag1.equals(tag2.substring(1)); // test against name after '/'
	}
	
	/** Test if every opening tag has a matching closing tag. */
	public static boolean isHTMLMatched (String[] tag){
		Stack<String> stack = new NodeStack<String>();
		for (int i=0; (i<tag.length)&&(tag[i]!=null); i++) {
			if (isOpeningTag(tag[i])) {
				stack.push(tag[i]);
			}
			else {
				if (stack.isEmpty()) {
					return false;
				}
				if (!areMatchingTags(stack.pop(), tag[i])) {
					return false;
				}
			}
		}
		if (stack.isEmpty()) {	// match everything
			return true;
		}
		return false;
	}
	
	public final static int CAPACITY = 1000;	// tags size
	/* Parse an HTML document into an array of html tags */
	public static String[] parseHTML (Scanner scanner) {
		String[] tags = new String[CAPACITY];
		int count = 0;
		String token;
		while (scanner.hasNextLine()) {
			while ((token = scanner.findInLine("<[^>]*>")) != null) {
				tags[count++] = stripEnds(token); 
			}
			scanner.nextLine();
		}
		return tags;
	}
	
	public static void main (String[] args) 
		throws IOException {
		Scanner inFile = new Scanner(new FileReader("/Users/Rainicy/Desktop/test.rtf"));
		if (isHTMLMatched(parseHTML(inFile))) {
			System.out.println("Matched!");
		}
		else {
			System.out.println("Not Matched!");
		}
	}
	
}
