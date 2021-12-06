package com.student.l00170333.generics;

import java.util.Iterator;

public interface IList <T> extends Iterable<T> {
    /**
     * Add an element to the end of the list
     * @param elem element to be added
     */
    void add(T elem); //add to the end of the list
    /**
     * Inserts the specified element at the specified position in this list
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, T element);//throws an IndexOutOfBounds exception where appropriate
    /**
     * Replaces the element at the specified position in this list with the specified element
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    T set(int index, T element);//throws an IndexOutOfBounds exception where appropriate
    /**
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    T get(int index);//throws an IndexOutOfBounds exception where appropriate
    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    int size();
    /**
     * @param index is the index or position of the element to remove.
     * @return the element removed from the list.
     */
    T remove(int index);//throws an IndexOutOfBounds exception where appropriate
    /**
     *
     * @param elem the element to remove.
     * @return whether the element was removed or not.
     */
    boolean remove(T elem);//throws an IndexOutOfBounds exception where appropriate
    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    boolean isEmpty();
    /**
     * This is new (to the interface) but should be straightforward to implement.
     * @param element the element to search found.
     * @return whether the element was found or not.
     */
    boolean contains(T element);
    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * Specified by:
     * iterator in interface Iterable<T>.
     * @return an iterator over the elements in this list in proper sequence.
     */
    Iterator<T> iterator();

    /**
     * Rotates the elements in the specified list by the specified distance.
     * @param distance to be rotated.
     */
    void rotate(int distance);
}