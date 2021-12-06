package com.student.l00170333.generics;

import com.student.l00170333.shared.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericCollectionsTest {

    private final GenericArrayList<Person> people = new GenericArrayList<>();
    private final GenericArrayList<Integer> integerList = new GenericArrayList<>();

    @BeforeEach
    void setUp() {
        people.add(new Person(20, "Hegarty", "Dermot"));
        people.add(new Person(23, "Minchin", "Tim"));
        people.add(new Person(19, "DiCamillo", "Kate"));
        people.add(new Person(28, "Hardinge", "Frances"));
        people.add(new Person(24, "Bryson", "Bill"));
        people.add(new Person(26, "Ness", "Patrick")); // 16

        for (int i = 1; i <= 10; i++) {
            integerList.add(i);
        }
    }

    @Test
    void sort() {
        GenericCollections.sort(people);
        assertEquals(19, people.get(0).getAge());
        assertEquals(28, people.get(people.size() - 1).getAge());
    }

    @Test
    void max() {
        Person oldest = GenericCollections.max(people);
        assertEquals(28, oldest.getAge());
    }

    @Test
    void maxOnEmptyList() {
        GenericArrayList<Integer> emptyList = new GenericArrayList<>();
        assertThrows(NoSuchElementException.class, () -> GenericCollections.max(emptyList));
    }

    @Test
    void rotateByOne() {
        GenericCollections.rotate(integerList, 1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", integerList.toString());
    }

    @Test
    void rotateByTwo() {
        GenericCollections.rotate(integerList, 2);
        assertEquals("9,10,1,2,3,4,5,6,7,8,", integerList.toString());
    }

    @Test
    void rotateByFive() {
        GenericCollections.rotate(integerList, 5);
        assertEquals("6,7,8,9,10,1,2,3,4,5,", integerList.toString());
    }

    @Test
    void rotateWithNegative() {
        GenericCollections.rotate(integerList, -5);
        assertEquals("6,7,8,9,10,1,2,3,4,5,", integerList.toString());
    }

    @Test
    void rotatePersonByTwo() {
        GenericCollections.rotate(people, 2);
        assertEquals("Bill", people.get(0).getFirstname());
        assertEquals("Patrick", people.get(1).getFirstname());
        assertEquals("Dermot", people.get(2).getFirstname());
    }

    @Test
    void rotate2() {
        GenericCollections.rotate2(integerList, 1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", integerList.toString());
    }

    @Test
    void rotate2WithLinkedList() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        GenericCollections.rotate(list, 1);
        assertEquals("10,1,2,3,4,5,6,7,8,9,", list.toString());
    }
}