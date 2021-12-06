package com.student.l00170333.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericLinkedListTest extends CommonListTest {

    @BeforeEach
    void setUp() {
        stringList = new GenericLinkedList<>();
        integersList = new GenericLinkedList<>();
        doublesList = new GenericLinkedList<>();
    }

    @Test
    protected void add() {
        super.add();
    }

    @Test
    protected void addByIndex() {
        super.addByIndex();
    }

    @Test
    protected void addToStart() {
        GenericLinkedList<String> linkedList = new GenericLinkedList<>();
        linkedList.addToStart("FirstValue");
        assertEquals("FirstValue", linkedList.get(0));
    }

    @Test
    protected void set() { super.set(); }

    @Test
    protected void get() { super.get(); }

    @Test
    protected void size() { super.size(); }

    @Test
    protected void remove() { super.remove(); }

    @Test
    protected void isEmpty() { super.isEmpty(); }

    @Test
    protected void contains() { super.contains(); }

    @Test
    protected void iterator() { super.iterator(); }

    @Test
    protected void rotate() { super.rotate(); }
}