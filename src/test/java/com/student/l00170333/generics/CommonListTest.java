package com.student.l00170333.generics;

import static org.junit.jupiter.api.Assertions.*;

public abstract class CommonListTest {
    protected IList<String> stringList;
    protected IList<Integer> integersList;
    protected IList<Double> doublesList;

    protected int addTestElements() {
        int size = 50;
        for (int i = 1; i <= size; i++) {
            stringList.add("String-" + i);
            integersList.add(i);
            doublesList.add(i * 1.0);
        }
        return size;
    }

    protected void add() {
        StringBuilder expectedString = new StringBuilder();
        StringBuilder expectedInt = new StringBuilder();
        StringBuilder expectedDouble = new StringBuilder();

        for (int i = 0; i < 50; i++) {
            stringList.add("Value");
            expectedString.append("Value,");

            integersList.add(i);
            expectedInt.append(i).append(",");

            doublesList.add(i * 1.0);
            expectedDouble.append(i * 1.0).append(",");
        }

        assertEquals(expectedString.toString() , stringList.toString());
        assertEquals(expectedInt.toString(), integersList.toString());
        assertEquals(expectedDouble.toString(), doublesList.toString());
    }

    protected void addByIndex() {
        int originalCountOfElements = addTestElements();

        stringList.add(1, "addByIndex");
        assertEquals("addByIndex", stringList.get(1));

        stringList.add(stringList.size(), "addByIndexSize");
        assertEquals("addByIndexSize", stringList.get(stringList.size()-1));
    }

    protected void set() {
        int originalCountOfElements = addTestElements();
        assertEquals("String-1", stringList.set(0, "replaced-"));
        assertEquals("replaced-", stringList.get(0));

        // count is 1 higher than the highest index. Let's test IndexOutOfBoundsException is thrown.
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.set(originalCountOfElements, "Out of range"));
    }

    protected void get() {
        int originalCountOfElements = addTestElements();
        assertEquals("String-1", stringList.get(0));
        assertEquals("String-2", stringList.get(1));
        assertEquals("String-3", stringList.get(2));

        // count is 1 higher than the highest index. Let's test IndexOutOfBoundsException is thrown.
        assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(originalCountOfElements));
    }

    protected void size() {
        for (int i = 0; i < 10; i++) {
            assertEquals(i, integersList.size());
            integersList.add(i);
        }
    }

    protected void remove() {
        int originalCountOfElements = addTestElements();
        assertEquals("String-1", stringList.remove(0));
        assertEquals("String-3", stringList.remove(1));
        assertEquals(originalCountOfElements - 2, stringList.size());
    }

    protected void removeElement() {
        stringList.add("Test");
        stringList.add("Test2");
        stringList.add("Test3");

        assertTrue(stringList.remove("Test2"));
        assertFalse(stringList.remove("DoesNotExist"));
        //assertThrows(IndexOutOfBoundsException.class, () -> stringList.get(2));
    }

    protected void isEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add("test");
        assertFalse(stringList.isEmpty());
    }

    protected void contains() {
        stringList.add("test");
        assertTrue(stringList.contains("test"));
        assertFalse(stringList.contains("test2"));
    }

    protected void iterator() {
        stringList.add("test0");
        stringList.add("test1");
        stringList.add("test2");

        int i = 0;
        for (String s : stringList) {
            assertEquals("test"+i, s);
            ++i;
        }
        assertEquals(3, i);
    }

    protected void rotate() {
        for (int i = 1; i <= 10; i++) {
            integersList.add(i);
        }

        // Rotate for distance of 1
        integersList.rotate(1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", integersList.toString());

        // Rotate again with a distance of 2
        integersList.rotate(2);
        assertEquals("8,9,10,1,2,3,4,5,6,7,", integersList.toString());

        // Rotate a distance of 0
        integersList.rotate(0);
        assertEquals("8,9,10,1,2,3,4,5,6,7,", integersList.toString());

        // Rotate in the opposite direction
        integersList.rotate(-3);
        assertEquals("1,2,3,4,5,6,7,8,9,10,", integersList.toString());
    }
}
