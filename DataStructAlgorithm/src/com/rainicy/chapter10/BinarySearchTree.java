/*
 * BinarySearchTree.java
 *
 * Created on July 18, 2014.
 */
package com.rainicy.chapter10;

import com.rainicy.chapter6.arraylist.NodePositionList;
import com.rainicy.chapter6.arraylist.Position;
import com.rainicy.chapter6.arraylist.PositionList;
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
    extends LinkedBinaryTree<Entry<K, V>> implements Dictionary<K, V> {

    protected Comparator<K> C;
    // insert node or removed node's parent
    protected Position<Entry<K,V>> actionPos;
    // number of entries
    protected int numEntries = 0;

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
        numEntries++;
        return e;
    }
    /** Removes an external node and its parent. */
    protected void removeExternal(Position<Entry<K,V>> v) {
        removeAboveExternal(v);
        numEntries--;
    }

    /** Search the position by given key, use the recursive way. */
    protected Position<Entry<K,V>> treeSearch(K key, Position<Entry<K,V>> pos) {
        if (isExternal(pos)) {
            return pos;         // not found the key, return the external node
        }
        else {
            K posKey = key(pos);
            int comp = C.compare(key, posKey);
            if (comp < 0) {
                return treeSearch(key, left(pos));
            }
            else if (comp > 0) {
                return treeSearch(key, right(pos));
            }
            return pos;     // found the key and return the internal node.
        }
    }

    /** Adds all entries in the subtree rooted at v having keys equal to k. */
    protected void addAll(PositionList<Entry<K,V>> L,
                          Position<Entry<K,V>> v, K key) {
        if (isExternal(v)) {
            return;
        }
        Position<Entry<K,V>> pos = treeSearch(key, v);
        if (!isExternal(pos)) {
            addAll(L, left(pos), key);
            L.addLast(pos.element());
            addAll(L, right(pos), key);
        }
    }

    /** Returns the number of entries in the tree. */
    public int size() {
        return numEntries;
    }

    /** Returns if the tree is empty. */
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Entry find(K key) throws InvalidKeyException {
        checkKey(key);
        Position<Entry<K,V>> curPos = treeSearch(key, root());
        actionPos = curPos;
        return null;
    }

    @Override
    public Iterable<Entry<K,V>> findAll(K key) throws InvalidKeyException {
        checkKey(key);
        PositionList<Entry<K,V>> L = new NodePositionList<Entry<K,V>>();
        addAll(L, root(), key);
        return L;
    }

    @Override
    public Entry insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Position<Entry<K,V>> insertPos = treeSearch(key, root());
        while (!isExternal(insertPos)) {
            insertPos = treeSearch(key, left(insertPos));
        }
        actionPos = insertPos;
        return insertAtExternal(insertPos,
                new BSTEntry<K, V>(key, value, insertPos));
    }

    @Override
    public Entry remove(Entry entry) throws InvalidEntryException {
        return null;
    }

    @Override
    public Iterable<Entry<K,V>> entries() {
        return null;
    }
}
