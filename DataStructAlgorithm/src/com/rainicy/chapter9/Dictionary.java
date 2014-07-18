/*
 * Dictionary.java
 *
 * Created on July 18, 2014.
 */
package com.rainicy.chapter9;

import com.rainicy.chapter8.Entry;
import com.rainicy.chapter8.InvalidKeyException;

/**
 * An interface for a dictionary for key-value pairs.
 */
public interface Dictionary<K, V> {

    /** Returns the number of entries in the dictionary. */
    public int size();

    /** Returns whether the dictionary is empty */
    public boolean isEmpty();

    /** Returns an entry by given key, or null if not found the key. */
    public Entry<K,V> find(K key) throws InvalidKeyException;

    /** Returns an iterator containing all the entries containing
     * the given key, or empty iterator if no such key
     */
    public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException;

    /**
     * Inserts a key-value pair to the dictionary. Returns
     * newly created entry.
     */
    public Entry<K,V> insert(K key, V value) throws InvalidKeyException;

    /**
     * Removes and returns the given entry from the dictionary.
     */
    public Entry<K,V> remove(Entry<K,V> entry) throws InvalidEntryException;

    /**
     * Returns an iterator containing all the entries in the dictionary.
     */
    public Iterable<Entry<K,V>> entries();
}
