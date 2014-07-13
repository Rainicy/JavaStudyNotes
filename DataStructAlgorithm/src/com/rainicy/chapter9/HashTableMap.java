/*
 * HashTableMap.java
 *
 * Created on July 10, 2014
 */
package com.rainicy.chapter9;


import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.PositionList;
import com.rainicy.chapter8.Entry;
import com.rainicy.chapter8.InvalidKeyException;
import sun.security.x509.AVA;

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
    /**
     *  Hash index = ( (a × hashCode + b) % p ) % N)
     *  prime stands for p, capacity stands for N
     */
    protected int prime, capacity;
    /**
     *  Hash index = ( (a × hashCode + b) % p ) % N)
     *  scale stands for a, shift stands for b.
     */
    protected long scale, shift;
    /** number of entries in the dictionary */
    protected int n = 0;

    /** Constructor of HashTableMap, with default prime factor and capacity */
    public HashTableMap() {
        this(109345121, 1000);
    }

    /** Constructor by given capacity */
    public HashTableMap(int capacity) {
        this(109345121, capacity);
    }

    /** Constructor by given prime factor and capacity */
    public HashTableMap(int prime, int capacity) {
        this.prime = prime;
        this.capacity = capacity;
        bucket = (Entry<K,V>[]) new Entry[capacity];
        java.util.Random rand = new java.util.Random();
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0);
    }

    @Override
    public V put(K key, V value) throws InvalidKeyException {
        int i = findEntry(key);
        if (i > 0) {    // the key has been in the dictionary, just update
            return ((HashEntry<K,V>) bucket[i]).setValue(value);
        }

        if (n >= capacity/2) {
            rehash();   // keep the load factor smaller than 0.5
            i = findEntry(key); //find again the appropriate spot for the entry
        }
        bucket[-i-1] = new HashEntry<K,V>(key, value);
        n++;
        return null

    }

    @Override
    public V get(K key) throws InvalidKeyException {
        int i = findEntry(key);
        if (i < 0) {
            return  null;   // no value for this key
        }
        return bucket[i].getValue();
    }

    @Override
    public V remove(K key) throws InvalidKeyException {
        int i = findEntry(key);
        if (i < 0) {
            return null;
        }
        V value = bucket[i].getValue();
        bucket[i] = AVAILABLE;
        n--;
        return value;
    }

    @Override
    public Iterable<K> keys() {
        PositionList<K> keys = new NodePositionList<K>();
        for (int i=0; i<capacity; i++) {
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) {
                keys.addLast(bucket[i].getKey());
            }
        }
        return keys;
    }

    @Override
    public Iterable<V> values() {
        PositionList<V> values = new NodePositionList<V>();
        for (int i=0; i<capacity; i++) {
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) {
                values.addLast(bucket[i].getValue());
            }
        }
        return values;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
        PositionList<Entry<K,V>> entries = new NodePositionList<Entry<K,V>>();
        for (int i=0; i<capacity; i++) {
            if ((bucket[i] != null) && (bucket[i] != AVAILABLE)) {
                entries.addLast(bucket[i]);
            }
        }
        return entries;
    }

    /** Determines whether the key is valid. */
    protected void checkKey(K key) {
        if (key == null) {
            throw new InvalidKeyException("Invalid Key: null.");
        }
    }

    /**
     * Returns the index of entry by given key or
     * failed return -(a + 1),
     * where a is the index of the first empty or available slot found.
     *
     * @param key
     * @return
     * @throws InvalidKeyException
     */
    protected int findEntry(K key) throws InvalidKeyException {
        checkKey(key);
        int avail = -1;
        int i = hashValue(key); // index by hashValue function
        int j = i;
        do {
            Entry<K,V> entry = bucket[i];
            if (entry == null) {
                if (avail < 0) {
                    avail = i;  // key is not in table
                }
                break;
            }
            if (key.equals(entry.getKey())) {
                return i;   // key is found
            }
            if (entry == AVAILABLE) {
                if (avail < 0) {
                    avail = i;
                }
            }
            i = (i+1) % capacity;
        } while (i != j);
        // first empty or available slot
        return -(avail + 1);
    }

    /** Doubles the size of the hash table and rehashes all the entries. */
    protected void reHash() {
        capacity = 2 * capacity;
        Entry<K,V>[] old = bucket;
        bucket = (Entry<K,V>[]) new Entry[capacity];
        java.util.Random rand = new java.util.Random();
        scale = rand.nextInt(prime-1) + 1;
        shift = rand.nextInt(prime);
        for (int i=0; i<old.length; i++) {
            Entry<K,V> entry = old[i];
            if ((entry != null) && (entry != AVAILABLE)) {
                int j = - 1 - findEntry(entry.getKey());
                bucket[j] = entry;
            }
        }
    }

    /**
     *  Hash function by build-in hash code function and MAD method.
     *  [Hash index = ( (a × hashCode + b) % p ) % N)]
     */
    public int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode()*scale+shift)%prime)%capacity);
    }

}
