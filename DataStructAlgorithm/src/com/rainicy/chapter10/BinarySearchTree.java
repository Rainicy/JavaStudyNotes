/*
 * BinarySearchTree.java
 *
 * Created on July 18, 2014.
 */
package com.rainicy.chapter10;

import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter7.tree.LinkedBinaryTree;
import com.rainicy.chapter8.DefaultComparator;
import com.rainicy.chapter8.Entry;
import com.rainicy.chapter8.InvalidKeyException;
import com.rainicy.chapter9.Dictionary;
import com.rainicy.chapter9.InvalidEntryException;

import java.util.Comparator;

/**
 * A binary search tree class.
 *
 */
public class BinarySearchTree<K,V>
    extends LinkedBinaryTree<Entry<K, V>> implements Dictionary{

    protected Comparator<K> C;
    // insert node or removed node's parent
    protected Position<Entry<K,V>> actionPos;
    // number of entries
    protected int size = 0;

    /** Creates a BinarySearchTree with a default comparator. */
    public BinarySearchTree() {
        C = new DefaultComparator<>();
        addRoot(null);
    }

    /** Nested class for location aware binary search tree entries */
    protected static class BSTEntry<K,V> implements Entry<K,V> {

        protected K key;
        protected V value;
        protected Position<Entry<K,V>> pos;

        BSTEntry() {
            this(null,null,null);
        }
        BSTEntry(K key, V value, Position<Entry<K,V>> pos) {
            this.key = key;
            this.value = value;
            this.pos = pos;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }
    }

    // Auxiliary methods:
    /** Extracts the key of the entry at a given node of the tree. */
    protected K key(Position<Entry<K,V>> position) {
        return position.element().getKey();
    }
    /** Extracts the value by given position. */
    protected V value(Position<Entry<K,V>> position) {
        return position.element().getValue();
    }
    /** Extracts the entry */
    protected Entry<K,V> entry(Position<Entry<K,V>> position) {
        return position.element();
    }
    /** Replaces an entry with a new entry */
    protected void replaceEntry(Position<Entry<K,V>> pos, Entry<K,V> e) {
        ((BSTEntry<K,V>) e).pos = pos;
        replace(pos, e);
    }
    /** Checks whether a given key is valid */
    protected void checkKey(K key) throws InvalidKeyException {
        if (key == null) {
            throw new InvalidKeyException("null key");
        }
    }
    /** Checks whether a given entry is valid. */
    protected void checkEntry(Entry<K,V> entry) throws InvalidEntryException {
        if (entry == null || !(entry instanceof BSTEntry)) {
            throw new InvalidEntryException("invalid entry");
        }
    }
    /** inserts an entry at the external node. */
    protected Entry<K,V> insertAtExternal(Position<Entry<K,V>> v, Entry<K,V> e) {
        expandExternal(v, null, null);
        replace(v, e);
        size++;
        return e;
    }

    @Override
    public Entry find(Object key) throws InvalidKeyException {
        return null;
    }

    @Override
    public Iterable<Entry> findAll(Object key) throws InvalidKeyException {
        return null;
    }

    @Override
    public Entry insert(Object key, Object value) throws InvalidKeyException {
        return null;
    }

    @Override
    public Entry remove(Entry entry) throws InvalidEntryException {
        return null;
    }

    @Override
    public Iterable<Entry> entries() {
        return null;
    }
}
