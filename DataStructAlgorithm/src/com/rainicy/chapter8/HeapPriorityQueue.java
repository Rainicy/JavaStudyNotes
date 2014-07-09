/*
 * HeapPriorityQueue.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

import com.rainicy.chapter6.arraylist.Position;

import java.util.Comparator;

/**
 * Implementation of a priority queue by means of a heap.
 * A complete binary tree realized by means of an array list is used
 * to represent the heap.
 */
public class HeapPriorityQueue<K, V> implements PriorityQueue<K,V> {
    protected CompleteBinaryTree<Entry<K, V>> heap;
    protected Comparator<K> comparator;

    /** inner class for heap entries */
    protected static class MyEntry<K, V> implements Entry<K,V> {
        protected K key;
        protected V value;
        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }

    /** Constructor by default comparator. */
    public HeapPriorityQueue() {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
        comparator = new DefaultComparator<K>();
    }

    /** Constructor by a given comparator */
    public HeapPriorityQueue(Comparator<K> c) {
        heap = new ArrayListCompleteBinaryTree<Entry<K, V>>();
        comparator = c;
    }

    /**
     *  Sets the comparator using in the heap.
     *
     *  @throws java.lang.IllegalStateException if priority queue is not empty.
     */
    public void setComparator(Comparator<K> c)
            throws IllegalStateException
    {
        if (!isEmpty()) {
            throw new IllegalStateException("Priority queue is empty.");
        }
        comparator = c;
    }


    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.size() == 0;
    }

    @Override
    public Entry<K, V> min() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Priority queue is empty.");
        }
        return heap.root().element();
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
        checkKey(key);
        Entry<K, V> entry = new MyEntry<K, V>(key, value);
        upHeap(heap.add(entry));
        return entry;
    }

    @Override
    public Entry<K, V> removeMin() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException("Priority queue is empty.");
        }
        Entry<K, V> entry = heap.root().element();
        if (size() == 1) {
            heap.remove();
        }
        else {
            heap.replace(heap.root(), heap.remove());
            downHeap(heap.root());
        }
        return entry;
    }

    /** Determines whether a given key is valid. */
    protected void checkKey(K key) throws InvalidKeyException {
        try {
            comparator.compare(key, key);
        }
        catch(Exception e) {
            throw new InvalidKeyException("Invalid key.");
        }
    }

    /** Up-heap bubbling */
    protected void upHeap(Position<Entry<K, V>> v ) {
        Position<Entry<K, V>> u;
        while (!heap.isRoot(v)) {
            u = heap.parent(v);
            // u <= v; parent <= child
            if (comparator.compare(u.element().getKey(), v.element().getKey())
                    <= 0 ) {
                break;
            }
            swap(u, v);
            v = u;
        }
    }

    /** Down-Heap bubbling */
    protected void downHeap(Position<Entry<K, V>> v) {
        while (heap.isInternal(v)) {
            Position<Entry<K,V>> s; // position of smaller child
            if (!heap.hasRight(v)) {
                s = heap.left(v);
            }
            else if (comparator.compare(heap.left(v).element().getKey(),
                    heap.right(v).element().getKey()) <= 0) {
                s = heap.left(v);
            }
            else {
                s = heap.right(v);
            }
            if (comparator.compare(s.element().getKey(), v.element().getKey())
                    < 0) {
                swap(v, s);
                v = s;
            }
            else {
                break;
            }
        }
    }

    /** Swaps the entries by given two positions */
    protected void swap(Position<Entry<K, V>> p1, Position<Entry<K,V>> p2) {
        Entry<K, V> temp = p1.element();
        heap.replace(p1, p2.element());
        heap.replace(p2, temp);
    }

    /** toString */
    public String toString() {
        return heap.toString();
    }
}
