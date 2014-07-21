/*
 * TicTacToe.java
 * 
 * Version: 1.0
 * 
 * Date: March 29, 2014
 */
package com.rainicy.chapter3.array;

/**
 * Simulation of Tic-Tac-Toe games without strategy.
 * 
 * @version 1.0
 * @author Rainicy
 *
 */
public class TicTacToe {
	private static final int NUMBER_ROWS = 3;
	private static final int NUMBER_COLUMNS = 3;
	/** The number in a line can win */
	private static final int WIN_SIZE = 3;
	/** Two different players, X and O */
	protected static final int X = 1, O = -1;
	/** Empty cell */
	protected static final int EMPTY = 0;
	/** Game board */
	protected int board[][] = new int[NUMBER_ROWS][NUMBER_COLUMNS];
	/** Current player, starting with X */
	protected int player;
	
	/** Constructor */
	public TicTacToe() {
		clearBoard();
	}
	
	/** Clear the game board */
	public void clearBoard() {
		for (int i=0; i<NUMBER_ROWS; i++) {
			for (int j=0; j<NUMBER_COLUMNS; j++) {
				board[i][j] = EMPTY;
			}
		}
		player = X;	// Starting with X
	}
	
	/** 
	 * Put X or O on the board, by given position x, y.
	 * 
	 * @param {int} x - position in row
	 * @param {int} y - position in column
	 * @return void
	 */ 
	public void putMark (int x, int y) 
		throws IllegalArgumentException
	{
		if ((x<0) || (x>=NUMBER_ROWS) || (y<0) || (y>NUMBER_COLUMNS)) {
			throw new IllegalArgumentException("Invalid board position");
		}
		if (board[x][y] != EMPTY) {
			throw new IllegalArgumentException("Board position occupied");
		}
		board[x][y] = player;	// place the mark for the current player
		player = - player;	// switch player
	}
	
	/** Check if the given player win or not */
	public boolean isWin (int player) {
		// check the rows 
		for (int i=0; i<NUMBER_ROWS; i++) {
			int scores = 0;
			for (int j=0; j<NUMBER_COLUMNS; j++) {
				scores += board[i][j];
			}
			if (scores == player * WIN_SIZE) {
				return true;
			}
		}
		// check the columns
		for (int j=0; j<NUMBER_COLUMNS; j++) {
			int scores = 0;
			for (int i=0; i<NUMBER_ROWS; i++) {
				scores += board[i][j];
			}
			if (scores == player * WIN_SIZE) {
				return true;
			}
		}
		// check the diagonal
		int scores = 0;
		for (int i=0,j=0; (i<NUMBER_ROWS) && (j<NUMBER_COLUMNS); i++, j++) {
			scores += board[i][j];
		}
		if (scores == player * WIN_SIZE)	{
			return true;
		}
		scores = 0;
		for (int i=0,j=NUMBER_COLUMNS-1; (i<NUMBER_ROWS) && (j>0); i++, j--) {
			scores += board[i][j];
		}
		if (scores == player * WIN_SIZE) {
			return true;
		}
		
		return false;	// This player does not win
	}
	
	/** 
	 * Return the winning player or 0 indicate a tie
	 * 
	 * @return int : 1 means X, -1 means O
	 */
	public int winner() {
		if (isWin(X)) {
			return X;
		}
		else if (isWin(O)) {
			return O;
		}
		else {
			return 0;
		}
	}
	
	/** Returns a simple character string showing the current board */
	public String toString() {
		String string = "";
		for (int i=0; i<NUMBER_ROWS; i++) {
			for (int j=0; j<NUMBER_COLUMNS; j++) {
				switch (board[i][j]) {
				case X: string += "X"; break;
				case O: string += "O"; break;
				case EMPTY: string += " "; break;
				}
				if (j < NUMBER_COLUMNS-1) {
					string += "|";
				}
			}
			if (i < NUMBER_ROWS-1) {
				string += "\n";
			}
		}
		return string;
	}
	
}
