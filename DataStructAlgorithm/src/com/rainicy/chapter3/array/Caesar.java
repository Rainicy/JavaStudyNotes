/*
 * Caesar.java
 * 
 * Version: 1.0
 * 
 * Date: March 29, 2014
 */
package com.rainicy.chapter3.array;

/**
 * Caesar class is for doing encryption and decryption using the Caesar Cipher
 * 
 * @version 1.0
 * @author Rainicy
 */
public class Caesar {
	/** English alphabet size, uppercase only */ 
	public static final int ALPHABET_SIZE = 26;
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G',
		'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
		'V', 'W', 'X', 'Y', 'Z'};
	protected char[] encrypt = new char[ALPHABET_SIZE];
	protected char[] decrypt = new char[ALPHABET_SIZE];
	
	/** Constructor that initializes encryption and decryption arrays */
	public Caesar() {
		for (int i=0; i<ALPHABET_SIZE; i++) {
			encrypt[i] = ALPHABET[ (i+3) % ALPHABET_SIZE ];
		}
		for (int i=0; i<ALPHABET_SIZE; i++) {
			decrypt[encrypt[i] - 'A'] = ALPHABET[i];
		}
	}
	
	/** Encryption method */
	public String encrypt (String secret) {
		char[] message = secret.toCharArray();	// change string to array
		for (int i=0; i<message.length; i++) {
			if (Character.isUpperCase(message[i])) {
				message[i] = encrypt[message[i] - 'A'];
			}
		}
		return new String(message);
	}
	
	/** Decryption method */
	public String decrypt (String secret) {
		char[] message = secret.toCharArray(); 
		for (int i=0; i<message.length; i++) {
			if(Character.isUpperCase(message[i])) {
				message[i] = decrypt[message[i] - 'A'];
			}
		}
		return new String(message);
	}
	
	/** Simple main method for testing the Caesar Cipher */
	public static void main (String[] args) {
		Caesar caesar = new Caesar();
		System.out.println("Encription order: " + new String(caesar.encrypt));
		System.out.println("Decription order: " + new String(caesar.decrypt));
		String secret = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
		secret = caesar.encrypt(secret);
		System.out.println(secret);
		secret = caesar.decrypt(secret);
		System.out.println(secret);
	}
}
