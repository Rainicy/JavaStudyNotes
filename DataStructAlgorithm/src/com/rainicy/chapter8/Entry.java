/*
 * Entry.java
 *
 * Created on July 9, 2014
 */
package com.rainicy.chapter8;

/**
 * Interface for a key-value pair entry.
 *
 * @version 1.0
 * @author rainicy
 */
public interface Entry<K, V> {
    /** Returns the key stored in the entry. */
    public K getKey();

    /** Returns the value stored in the entry. */
    public V getValue();
}
