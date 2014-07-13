/*
 * Map.java
 *
 * Created on July 10, 2014.
 */
package com.rainicy.chapter9;

import com.rainicy.chapter8.Entry;

import com.rainicy.chapter8.InvalidKeyException;

import java.util.Iterator;

/**
 * An interface for map, which binds a key uniquely to a value.
 *
 * @version 1.0
 * @author Rainicy
 */
public interface Map<K, V> {
    /** Returns the number of entries in the map. */
    public int size();

    /** Returns whether the map is empty or not. */
    public boolean isEmpty();

    /**
     * Puts a given key and value pair into the map, replaces the previous
     * one, if exits. And returns the old value, if exits, otherwise returns
     * null.
     *
     * @throws com.rainicy.chapter8.InvalidKeyException if the key is invalid.
     */
    public V put(K key, V value) throws InvalidKeyException;

    /**
     * Gets the value by given key.
     * If the key cannot be found, return null.
     *
     * @throws com.rainicy.chapter8.InvalidKeyException if the key is invalid.
     */
    public V get(K key) throws InvalidKeyException;

    /**
     * Removes the key-value pair by given key.
     * Returns the value if found the key, otherwise return null.
     *
     * @throws com.rainicy.chapter8.InvalidKeyException if the key is invalid.
     */
    public V remove(K key) throws InvalidKeyException;

    /**
     * Returns iterable object containing all the keys in the map.
     */
    public Iterable<K> keys();

    /**
     * Returns iterable object containing all the values in the map.
     */
    public Iterable<V> values();

    /**
     * Returns iterable object containing all the entries in the map.
     */
    public Iterable<Entry<K, V>> entries();
}
