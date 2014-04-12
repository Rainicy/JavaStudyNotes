/*
 * EnlishRuler.java
 * 
 * Date: April 11, 2014
 */
package com.rainicy.chapter3.recursion;

/**
 * This is the class for english ruler.
 * 
 * @version	1.0
 * @author Rainicy
 *
 */
public class EnglishRuler {
	private int inch;	// How long of the ruler
	private int majorLength;	// The longest length of the tick
	
	/** Constructor by default setting */
	public EnglishRuler() {
		this.inch = 0;
		this.majorLength = 0;
	}
	
	/** Constructor */
	public EnglishRuler(int inch, int length) {
		this.inch = inch;
		this.majorLength = length;
	}
	
	/** Get inch */
	public int getInch() {
		return inch;
	}
	
	/** Get major length */
	public int getMajorLength() {
		return majorLength;
	}
	
	/** Set inch */
	public void setInch(int inch) {
		this.inch = inch;
	}
	
	/** Set major length */
	public void setMajorLength(int majorLength) {
		this.majorLength = majorLength;
	}
	
	/** Draw the ruler by given inch and major length */
	public void drawRuler() {
		drawOneTick(getMajorLength(), 0);
		for (int i=1; i<=getInch(); i++) {
			drawTicks (getMajorLength()-1);
			drawOneTick(getMajorLength(), i);
		}
	}

	private void drawTicks(int length) {
		if (length > 0) {
			drawTicks(length - 1);	// recursively draw the left ticks
			drawOneTick(length, -1);	// draw center tick
			drawTicks(length - 1);	// recursively draw the right ticks
		}
		
	}

	// Draw one tick by given length and label
	private void drawOneTick(int length, int label) {
		for (int i=0; i<length; i++) {
			System.out.print("-");
		}
		if (label >= 0) {
			System.out.print(" " + label);
		}
		System.out.println();
	}
	
	
}
