/*
 * HashTableMap.java
 *
 * Created on July 10, 2014
 */
package com.rainicy.chapter9;


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
}
