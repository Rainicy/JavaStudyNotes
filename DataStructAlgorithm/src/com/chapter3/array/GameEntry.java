/*
 * GameEnrty.java
 * 
 * Version: 1.0
 * 
 * Date: March 22, 2014
 * 
 */


package com.chapter3.array;

/**
 * GameEntry define the basic game entry information, 
 * including person name and score.
 * 
 * @version 1.0 March 22, 2014
 * 
 * @author Bingyu Wang
 */
public class GameEntry {
	/** name of the person earning this score */
	protected String name;
    /** the score value */
    protected int score;
    
    /** Constructor to create a game entry */
    public GameEntry (String name, int score) {
    	this.name = name;
    	this.score = score;
    }
    
    /** Retrieves the name field */
    public String getName() {
    	return this.name;
    }
    /** Retrieves the score field */
    public int getScore() {
    	return this.score;
    }
    /** 
     * Sets the name field 
     * 
     * @param {String} name - Given a person's name 
     */
    public void setName(String name) {
    	this.name = name;
    }
    /**
     * Sets the score field
     *  
     * @param {int} score - Given the score the person got
     */
    public void setScore(int score) {
    	this.score = score;
    }
    
    /** Returns a string representation of this entry */
    public String toString() {
    	String string;
    	string = "(Name: " + name + ", Socre: " + score + ")";
    	return string;
    }
    
}
