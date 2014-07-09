/*
 * DefaultComparator.java
 *
 * Created on July 9, 2014.
 */
package com.rainicy.chapter8;

import java.util.Comparator;

/**
 * Comparator based on the naturing ordering.
 *
 * @version 1.0
 * @author Rainicy
 */
public class DefaultComparator<E> implements Comparator<E> {

    /**
     * Compares two given elements.
     *
     * @param a element 1
     * @param b element 2
     * @return a negative integer if a < b;
     *          and positive integer if a > b. 0 if a = b.
     */
    public int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }
}
