/*
 * SortedListAdaptablePriorityQueue.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

import com.rainicy.chapter6.arraylist.PositionList;
import com.rainicy.chapter6.arraylist.Position;

import javax.xml.stream.Location;
import java.util.Comparator;

/**
 * Implements an adaptable priority queue by means of a sorted list.
 *
 * @version 1.0
 * @author Rainicy
 */
public class SortedListAdaptablePriorityQueue<K, V>
    extends SortedListPriorityQueue<K, V>
    implements AdaptablePriorityQueue<K, V> {

    /** Constructor by default comparator. */
    public SortedListAdaptablePriorityQueue() {
        super();
    }

    /** Constructor by given comparator. */
    public SortedListAdaptablePriorityQueue(Comparator<K> comparator) {
        super(comparator);
    }

    /** Constructor by given list and comparator. */
    public SortedListAdaptablePriorityQueue(PositionList<Entry<K, V>> list,
                                            Comparator<K> comparator) {
        super(list, comparator);
    }

    /** Inner class for a location-aware entry */
    protected static class LocationAwareEntry<K, V>
        extends MyEntry<K, V> implements Entry<K, V> {
        /** position info where the entry is stored. */
        private Position<Entry<K, V>> loc;

        public LocationAwareEntry(K key, V value) {
            super(key, value);
        }

        public LocationAwareEntry(K key, V value, Position<Entry<K,V>> pos) {
            super(key, value);
            loc = pos;
        }

        protected Position<Entry<K, V>> location() {
            return loc;
        }

        protected Position<Entry<K, V>> setLocation(Position<Entry<K, V>> pos) {
            Position<Entry<K, V>> oldPos = location();
            loc = pos;
            return oldPos;
        }

        protected K setKey(K key) {
            K oldKey = getKey();
            this.key = key;
            return oldKey;
        }

        protected V setValue(V value) {
            V oldValue = getValue();
            this.value = value;
            return oldValue;
        }
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> entry) {
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K,V>) entry;
        Position<Entry<K, V>> p = e.location();
        entries.remove(p);
        e.setLocation(null);
        return e;
    }

    @Override
    public K replaceKey(Entry<K, V> entry, K key) {
        checkKey(key);
        checkEntry(entry);
        LocationAwareEntry<K, V> e = (LocationAwareEntry<K,V>) remove(entry);
        K oldKey = e.setKey(key);
        insertEntry(e);
        e.setLocation(actionPos);
        return oldKey;
    }

    @Override
    public V replaceValue(Entry<K, V> entry, V value) {
        checkEntry(entry);
        V oldValue = ((LocationAwareEntry<K,V>) entry).setValue(value);
        return oldValue;
    }

    /** Determines whether a given entry is valid. */
    protected void checkEntry(Entry<K, V> entry)
        throws InvalidKeyException {
        if (entry == null || !(entry instanceof LocationAwareEntry)) {
            throw new InvalidKeyException("Invalid entry.");
        }
    }
}
