package com.student.L00170333.CA2;

public class GenericLinkedList<T> implements IGenericList<T> {
    private int counter;
    private Node head;

    public void addToStart(T val)
    {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    // appends the specified element to the end of this list.
    public void add(T elem) {
        // Initialize Node only in case of 1st element
        if (head == null) {
            head = new Node(elem);
        }

        Node temp = new Node(elem);
        Node current = head;

        // Let's check for null before iterate over current
        if (current != null) {
            // starting at the head node, crawl to the end of the list and then add element after last node
            while (current.getNext() != null) {
                current = current.getNext();
            }

            // the last node's "next" reference set to our new node
            current.setNext(temp);
        }

        // increment the number of elements variable
        incrementCounter();
    }

    public T get(int index) {
        // returns the element at the specified position in this list.
        // index must be 1 or higher
        if (index < 0)
            return null;
        Node current = null;
        if (head != null) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    break;

                current = current.getNext();
            }
            return current.getData();
        }
        return null;
    }

    // removes the element at the specified position in this list.
    public boolean remove(int index) {
        // if the index is out of range, exit
        if (index < 1 || index > size())
            return false;

        Node current = head;
        if (head != null) {
            for (int i = 0; i < index; i++) {
                if (current.getNext() == null)
                    return false;

                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());

            // decrement the number of elements variable
            decrementCounter();
            return true;
        }
        return false;
    }

    public int size() {
        return counter;
    }

    private void incrementCounter() {
        counter++;
    }

    private void decrementCounter() {
        counter--;
    }

    /* Linked list Node*/
    private class Node {
        // reference to the next node in the chain, or null if there isn't one.
        Node next;

        // data carried by this node. could be of any type you need.
        T data;

        // Node constructor
        public Node(T dataValue) {
            next = null;
            data = dataValue;
        }

        // another Node constructor if we want to specify the node to point to.
        public Node(T dataValue, Node nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public T getData() {
            return data;
        }

        @SuppressWarnings("unused")
        public void setData(T dataValue) {
            data = dataValue;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node nextValue) {
            next = nextValue;
        }
    }
}
