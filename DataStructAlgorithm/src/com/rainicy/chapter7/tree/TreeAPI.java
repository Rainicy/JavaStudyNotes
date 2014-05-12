/*
 * TreeAPI.java
 * 
 * Date: May 11, 2014
 */
package com.rainicy.chapter7.tree;

import com.rainicy.chapter6.arraylist.Position;
/**
 * Implements some easy api for Tree ADT. 
 * 
 * @version 1.0
 * @author Rainicy
 */
public class TreeAPI<E> {
	/**
	 * Given a tree and a node, returns the depth of this node 
	 * in the tree. The root's depth equals 0.
	 * 
	 * @param Tree<E>
	 * @param Position<E>
	 * 
	 * @return Depth
	 */
	public static <E> int depth (Tree<E> T, Position<E> v) {
		if (T.isRoot(v)) {
			return 0;
		}
		else {
			return 1 + depth(T, T.parent(v));
		}
	}
	
	/**
	 * Returns the given Tree's height. The root's height equals 0.
	 * 
	 * @param Tree<E>
	 * @return height
	 */
	public static <E> int height_depth (Tree<E> T) {
		int h = 0;
		for (Position<E> v : T.positions()){
			if (T.isExternal(v)) {
				h = Math.max(h, depth(T, v));
			}
		}
		return h;
	}
	
	/**
	 * Returns the given node's height in the Tree. This function implemented
	 * by Recursion. 
	 * 
	 * @param Tree<E>
	 * @param Position<E>
	 * @return height
	 */
	public static <E> int height_recursion (Tree<E> T, Position<E> v) {
		if (T.isExternal(v)) {
			return 0;
		}
		int h = 0;
		for (Position<E> p : T.children(v)) {
			h = Math.max(h, height_recursion(T, p));
		}
		return h + 1;
	}
	
	/**
	 * toString function for Tree, using Pre order sequence. 
	 * 
	 * @param Tree<E>
	 * @param Position<E>
	 * @return String
	 */
	public static <E> String toStringPreorder (Tree<E> T, Position<E> v) {
		String s = v.element().toString();
		for (Position<E> p : T.children(v)) {
			s += "," + toStringPreorder(T, p);
		}
		return s;
	}
	
	/**
	 * toString function for Tree, using Post order sequence.
	 * 
	 * @param Tree<E>
	 * @param Position<E>
	 * @return String
	 */
	public static <E> String toStringPostorder (Tree<E> T, Position<E> v) {
		String s = "";
		for (Position<E> p: T.children(v)) {
			s += toStringPostorder(T, p) + ",";
		}
		s += v.element().toString();
		return s;
	}
	
	/**
	 * Representation of a Tree by parenthetic, if the node is a 
	 * internal. 
	 * 
	 * @param Tree<E>
	 * @param Position<E>
	 * @return String
	 */
	public static <E> String parentheticRepresentation 
		(Tree<E> T, Position<E> v) {
		String s = v.element().toString();
		if (T.isInternal(v)) {
			boolean firstFlag = true;
			for (Position<E> p : T.children(v)) {
				if (firstFlag) {
					s += "(" + parentheticRepresentation(T, p);
					firstFlag = false;
				}
				else {
					s += parentheticRepresentation(T, p);
				}
			}
			s += ")";
		}
		return s;
	}
}
