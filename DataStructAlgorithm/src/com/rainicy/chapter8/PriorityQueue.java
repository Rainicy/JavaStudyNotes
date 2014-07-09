/*
 * PriorityQueue.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

/**
 * Interface for Priority Queue ADT.
 *
 * @version 1.0
 * @author Rainicy
 */
public interface PriorityQueue<K, V> {
    /** Returns the number of entries in this Priority Queue. */
    public int size();

    /** Returns if the Priority Queue is empty or not */
    public boolean isEmpty();

    /** Returns the entry with the minimum key. */
    public Entry<K, V> min() throws EmptyPriorityQueueException;

    /** Inserts an new entry by given key and value pair. And return the entry
     */
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException;

    /** Removes the entry with minimum key, and returns it. */
    public Entry<K, V> removeMin() throws  EmptyPriorityQueueException;

}
