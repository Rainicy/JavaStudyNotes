/*
 * SortedListPriorityQueue.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter6.arraylist.PositionList;

import java.util.Comparator;

/**
 * A Priority Queue implemented by a sorted double linked list, by
 * non-decreasing order.
 *
 * @version 1.0
 * @author Rainicy
 */
public class SortedListPriorityQueue<K, V> implements PriorityQueue<K, V> {
    /** Entries */
    protected PositionList<Entry<K, V>> entries;
    /** Comparator */
    protected Comparator<K> c;
    /** Variable used by subclass */
    protected Position<Entry<K, V>> actionPos;

    /** Inner class for entries, implementing the Entry interface */
    protected static class MyEntry<K, V> implements Entry<K, V> {
        protected K key;
        protected V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    /** Constructor for the priority queue with default comparator. */
    public SortedListPriorityQueue() {
        entries = new NodePositionList<Entry<K, V>>();
        c = new DefaultComparator<K>();
    }

    /** Constructor for the priority queue with given comparator. */
    public SortedListPriorityQueue(Comparator<K> comparator) {
        entries = new NodePositionList<Entry<K, V>>();
        c = comparator;
    }

    /** Constructor for the priority queue with given comparator and list */
    public SortedListPriorityQueue(PositionList<Entry<K, V>> list,
                                   Comparator<K> comparator) {
        entries = list;
        c = comparator;
    }

    /**
     * Sets the comparator for the priority queue.
     *
     * @throws  java.lang.IllegalStateException if the priority queue is not
     *          empty.
     */
    public void setComparator(Comparator<K> comparator)
        throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Priority queue is not empty.");
        }
        c = comparator;
    }

    @Override
    public int size() {
        return entries.size();
    }

    @Override
    public boolean isEmpty() {
        return entries.isEmpty();
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Priority is empty.");
        }
        else {
            return entries.first().element();
        }
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Entry<K, V> entry = new MyEntry<K, V>(key, value);
        insertEntry(entry);
        return entry;
    }

    /** Inserts an entry. */
    public void insertEntry(Entry<K, V> entry) {
        // empty just inserts the new entry
        if (entries.isEmpty()) {
            entries.addFirst(entry);
            actionPos = entries.first();    // insertion position
        }
        else if (c.compare(entry.getKey(), entries.last().element().getKey())
                > 0) {
            entries.addLast(entry);
            actionPos = entries.last(); // insertion position
        }
        else {
            Position<Entry<K, V>> curr = entries.first();
            while (c.compare(entry.getKey(), curr.element().getKey()) > 0) {
                curr = entries.next(curr);
            }
            entries.addBefore(curr, entry);
            actionPos = entries.prev(curr); // insertion position
        }
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Priority queue is empty.");
        }
        else {
            return entries.remove(entries.first());
        }
    }

    /** Determines whether the key is valid */
    protected boolean checkKey(K key) throws InvalidKeyException {
        boolean result;
        try {
            result = (c.compare(key, key) == 0);
        }
        catch (ClassCastException e) {
            throw new InvalidKeyException("key is not valid.");
        }
        return result;
    }

    public String toString() {
        return entries.toString();
    }
}
