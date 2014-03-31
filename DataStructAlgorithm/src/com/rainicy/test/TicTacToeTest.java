/*
 * TicTacToeTest.java
 * 
 * Version: 1.0
 * 
 * Date: March 29, 2014
 */
package com.rainicy.test;

import com.rainicy.chapter3.array.TicTacToe;

/**
 * Test on TicTacToe class in com.rainicy.chapter3.array package
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class TicTacToeTest {
	public static void main (String[] args) {
		TicTacToe game = new TicTacToe();
		/* X moves */			/* O moves */
		game.putMark(1, 1); 	game.putMark(0, 2);
		game.putMark(2, 2); 	game.putMark(0, 0);
		game.putMark(0, 1); 	game.putMark(2, 1);
		game.putMark(1, 2); 	game.putMark(1, 0);
		game.putMark(2, 0);
		System.out.println(game.toString());
		int winner = game.winner();
		if (winner != 0) {
			System.out.println("Winner is: " + winner);
		}
		else {
			System.out.println("Tie");
		}
	}
	
	
	
}
