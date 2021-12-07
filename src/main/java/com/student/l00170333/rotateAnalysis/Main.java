package com.student.l00170333.rotateAnalysis;

import com.student.l00170333.generics.GenericArrayList;
import com.student.l00170333.generics.GenericLinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("**addElementsToArray comparisons**");

        Analysis<String> arrayListAnalysis = null;
        Analysis<String> linkedListAnalysis = null;
        long timeTaken;
        int arraySize = 5000;
        int rotateDistance = 10;

        // GenericArrayList adding
        for (int i=1; i<= 50; ++i) {
            arrayListAnalysis = new Analysis<>(arraySize, new GenericArrayList<>());
            timeTaken = arrayListAnalysis.addElementsToArray();
            System.out.println(String.format("GenericArrayList:addElementsToArray() - run %s " +
                    "- time taken: %s microseconds.", i, timeTaken));
        }

        System.out.println("");
        System.out.println("");

        // GenericLinkedList adding
        for (int i=1; i<= 50; ++i) {
            linkedListAnalysis = new Analysis<>(arraySize, new GenericLinkedList<>());
            timeTaken = linkedListAnalysis.addElementsToArray();
            System.out.println(String.format("LinkedList:addElementsToArray()  - run %s " +
                    "- time taken: %s microseconds.", i, timeTaken));
        }

        System.out.println("");
        System.out.println("**rotate comparisons**");

        // GenericArrayList rotate
        for (int i=1; i<= 50; ++i) {
            timeTaken = arrayListAnalysis.rotate(rotateDistance);
            System.out.println(String.format("GenericArrayList:rotate(%s)  - run %s " +
                    "- time taken: %s microseconds.", rotateDistance, i, timeTaken));
        }

        System.out.println("");
        System.out.println("");

        // GenericLinkedList rotate
        for (int i=1; i<= 50; ++i) {
            timeTaken = linkedListAnalysis.rotate(rotateDistance);
            System.out.println(String.format("GenericLinkedList:rotate(%s)  - run %s " +
                    "- time taken: %s microseconds.", rotateDistance, i, timeTaken));
        }

        System.out.println("");
        System.out.println("**collection rotate**");

        // GenericArrayList rotate
        for (int i=1; i<= 50; ++i) {
            timeTaken = arrayListAnalysis.rotateCollection(2);
            System.out.println(String.format("GenericArrayList:rotateCollection(%s)  - run %s " +
                    "- time taken: %s microseconds.", rotateDistance, i, timeTaken));
        }

        System.out.println("");
        System.out.println("");

        // GenericLinkedList rotate
        for (int i=1; i<= 50; ++i) {
            timeTaken = linkedListAnalysis.rotateCollection(2);
            System.out.println(String.format("GenericLinkedList:rotateCollection(%s)  - run %s " +
                    "- time taken: %s microseconds.", rotateDistance, i, timeTaken));
        }
    }
}
