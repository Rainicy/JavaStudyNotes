/*
 * WordCount.java
 *
 * Created on July 13, 2014.
 */
package com.rainicy.test;

import com.rainicy.chapter8.Entry;
import com.rainicy.chapter9.HashTableMap;

import java.io.IOException;
import java.util.Scanner;

/**
 * Testing on HashTableMap class.
 */
public class WordCount {
    public static void main(String[] args) throws IOException {
        Scanner doc = new Scanner(System.in);
        doc.useDelimiter("[^a-zA-Z]");

        HashTableMap<String, Integer> H = new HashTableMap<String, Integer>();
        String word;
        Integer count;
        while (doc.hasNext()) {
            word = doc.next();
            if (word.equals("")) {
                continue;
            }
            word = word.toLowerCase();
            count = H.get(word);
            if (count == null) {
                H.put(word, 1);
            }
            else {
                H.put(word, ++count);
            }
        }

        int maxCount = 0;
        String maxWord = "no word";
        for (Entry<String, Integer> ent: H.entries()) {
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.print("The most frequent word is \"" + maxWord);
        System.out.println(",\" with word count = " + maxCount + ".");
    }
}
