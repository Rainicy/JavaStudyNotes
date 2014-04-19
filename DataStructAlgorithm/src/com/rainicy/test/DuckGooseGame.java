/*
 * DuckGooseGame.java
 * 
 * Date: April 19, 2014
 */
package com.rainicy.test;

import java.util.Random;

import com.rainicy.chapter3.linkedlist.Node;
import com.rainicy.chapter3.linkedlist.CircleList;


/**
 * DuckGoose game is using CircleList to implement it. 
 * 
 * @version 2.0
 * @author Rainicy
 *
 */
public class DuckGooseGame {
	/**
	 * Main function for game starting. The players include one "it", 
	 * one "goose" and some ducks. 
	 * 
	 * @param args
	 */
	public static void main (String[] args) {
		CircleList<String> circleList = new CircleList<String>();
		Node<String> it;
		Node<String> goose;
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		// players
		String[] players = {"A", "B", "C", "D", "E", "F", "G", "H"};
		// "it" starting with the first player in the players list
		for (int i=0; i<players.length; i++) {
			circleList.add(new Node<String>(players[i], null));
			circleList.advance();
		}
		
		// begin to play the game. 
		final int playTimes = 10;
		for (int i=0; i<playTimes; i++) {
			System.out.println("Players: " + circleList.toString());
			it = circleList.remove();
			System.out.println("it is [" + it.getElement() + "]");
			// it Start to find the goose
			while (random.nextBoolean() || random.nextBoolean()) {
				circleList.advance();
				Node<String> duck = circleList.getCursor();
				System.out.println("[" + duck.getElement() + "] is a Duck");
			}
			goose = circleList.remove();
			System.out.println("[" + goose.getElement() + "] is a Goose");
			// it wins
			if (random.nextBoolean()){
				System.out.println("[" + it.getElement() + "] wins");
				circleList.add(it);
				circleList.advance();
				circleList.add(goose);
			}
			else {
				System.out.println("[" + goose.getElement() + "] wins ");
				circleList.add(goose);
				circleList.advance();
				circleList.add(it);
			}
		}
		System.out.println("Final circle players are " + circleList.toString());
	}
}
