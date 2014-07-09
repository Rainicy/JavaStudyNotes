/*
 * AdaptablePriorityQueue.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

/**
 * Interface for adaptable priority queue.
 *
 * @version 1.0
 * @author Rainicy
 */
public interface AdaptablePriorityQueue<K, V> extends PriorityQueue<K, V> {
    /** Removes and returns an entry from the priority queue. */
    public Entry<K, V> remove(Entry<K, V> entry);

    /** Replaces the key and return the old key. */
    public K replaceKey(Entry<K, V> entry, K key);

    /** Replaces the value and return the old value. */
    public V replaceValue(Entry<K, V> entry, V value);

}
