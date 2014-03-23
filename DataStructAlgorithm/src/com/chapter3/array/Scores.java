/*
 * Scores.java
 * 
 * Version: 1.0
 * 
 * Date: March 23, 2014
 */

package com.chapter3.array;

/**
 * Scores class is defined for maintaining a set of scores as GameEntry objects,
 * which is for storing high scores in an array in non-increasing order.
 * 
 * @version 1.0 March 23, 2014
 * @author Rainicy
 */
public class Scores {
	/** max number of high scores we can keeping */
	public static final int MAX_ENTRIES = 10;
	/** actual number of scores we keep so far */
	public int nEntries;
	/** array of game entries (GameEntry) */
	public GameEntry[] gameEntries;

	/** Default constructor */
	public Scores() {
		gameEntries = new GameEntry[MAX_ENTRIES];
		nEntries = 0;
	}

	/** Returns a string representation of the high scores list */
	public String toString() {
		String string = "{";
		for (int i = 0; i < nEntries; i++) {
			if (i > 0) {
				string += ","; // separate entries by commas;
			}
			string += gameEntries[i];
		}
		return string;
	}

	/** Attempt to add a new game entry to the high scores list */
	public void addGameEntry(GameEntry gameEntry) {
		int newScore = gameEntry.getScore();

		// if the score list is full
		if (nEntries == MAX_ENTRIES) {
			if (gameEntries[nEntries - 1].getScore() >= newScore) {
				return;
			}
		} else { // the score list is not full
			nEntries++;
		}

		// insert the new game entry into the right location in the list.
		int i = nEntries - 1;
		while ((i > 0) && (gameEntries[i - 1].getScore() < newScore)) {
			gameEntries[i] = gameEntries[i - 1];
			i--;
		}
		// insert the new score
		gameEntries[i] = gameEntry;
	}

	/**
	 * Attempt to remove a game entry and return it based the given index
	 * 
	 * @param {int} index - the range of given index should be between 0 to
	 *        actual number of game entries minus 1.
	 * 
	 * @exception IndexOutOfBoundsException
	 *                - if the given index is not in the range
	 * 
	 * @return GameEntry - return the removed game entry
	 */
	public GameEntry removeGameEntry(int index)
			throws IndexOutOfBoundsException {
		if ((index < 0) || (index >= nEntries)) {
			throw new IndexOutOfBoundsException("Invalid index"
					+ Integer.toString(index));
		}
		GameEntry gameEntry = gameEntries[index];
		for (int i = index; i < nEntries - 1; i++) {
			gameEntries[i] = gameEntries[i + 1]; // move one cell to left
		}
		gameEntries[nEntries - 1] = null; // set the last one null
		nEntries--;

		return gameEntry;
	}
}
