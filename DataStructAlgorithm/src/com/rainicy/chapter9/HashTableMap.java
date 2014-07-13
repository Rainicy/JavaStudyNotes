/*
 * HashTableMap.java
 *
 * Created on July 10, 2014
 */
package com.rainicy.chapter9;


import com.rainicy.chapter8.Entry;
import com.rainicy.chapter8.InvalidKeyException;

/**
 * A hash table data structure.
 * The Hash Code function uses the build-in hashCode method.
 * The compression function uses the multiply-add-and-divide(MAD)
 * method.( Hash index = ( (a × hashCode + b) % p ) % N).
 * And the load factor (n/N) is always kept less than or equal to 0.5.
 * Once the load factor reaches 0.5, the entries are rehashed into
 * a new bucket array with twice the capacity.
 *
 * @version 1.0
 * @author Rainicy
 */
public class HashTableMap<K, V> implements Map<K,V> {
    /** Nested class for an entry in a hash table. */
    public  static class HashEntry<K, V> implements Entry<K,V> {
        protected K key;
        protected V value;

        public HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {
            HashEntry<K, V> entry;
            try {
                entry = (HashEntry<K, V>) o;
            }
            catch (ClassCastException e) {
               return false;
            }
            return (entry.getKey() == key) && (entry.getValue() == value);
        }
        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }

    /** Sentinel for a maker for deactivated entries. */
    protected Entry<K,V> AVAILABLE = new HashEntry<K,V>(null, null);
    /** bucket array. */
    protected Entry<K,V>[] bucket;
    protected int prime, capacity;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException {
        return null;
    }

    @Override
    public V get(K key) throws InvalidKeyException {
        return null;
    }

    @Override
    public V remove(K key) throws InvalidKeyException {
        return null;
    }

    @Override
    public Iterable<K> keys() {
        return null;
    }

    @Override
    public Iterable<V> values() {
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        return null;
    }
}
