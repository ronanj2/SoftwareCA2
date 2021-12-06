package com.student.l00170333.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericArrayListTest extends CommonListTest {

    @BeforeEach
    void setUp() {
        stringList = new GenericArrayList<>();
        integersList = new GenericArrayList<>();
        doublesList = new GenericArrayList<>();
    }

    @Test
    protected void add() {
        super.add();
    }

    @Test
    protected void set() { super.set(); }

    @Test
    protected void get() { super.get(); }

    @Test
    protected void size() {
        super.size();
    }

    @Test
    protected void remove() { super.remove(); }

    @Test
    protected void removeElement() {
        super.removeElement();
    }

    @Test
    protected void isEmpty() {
        super.isEmpty();
    }

    @Test
    protected void contains() {
        super.contains();
    }

    @Test
    protected void iterator() {
        super.iterator();
    }

    @Test
    protected void rotate() {
        super.rotate();
    }
}