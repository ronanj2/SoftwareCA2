package com.student.l00170333.rotateAnalysis;

import com.student.l00170333.generics.GenericCollections;
import com.student.l00170333.generics.IList;
import java.util.concurrent.TimeUnit;

public class Analysis<T> {
    private final IList<T> list;
    private final int size;
    private long startTime;
    private long endTime;

    public Analysis(int listSize, IList<T> typedList) {
        this.size = listSize;
        this.list = typedList;
    }

    /**
     * Fill up the array with values
     */
    public long addElementsToArray() {
        Start();

        for(int i = 0; i <= size; ++i) {
            list.add(convertInstanceOfObject(i));
        }

        return ElapsedTime();
    }

    private void Start() {
        startTime = System.nanoTime();
    }

    private long ElapsedTime() {
        endTime = System.nanoTime();
        return convertToMicroSeconds(endTime - startTime);
    }

    /**
     * Measures execution time for IList rotate method
     * @return long time in micro second
     */
    public long rotate(int distance) {
        Start();
        list.rotate(distance);
        return ElapsedTime();
    }

    public long rotateCollection(int distance) {
        Start();
        GenericCollections.rotate(convertInstanceOfObject(list), 3);
        return ElapsedTime();
    }

    public static <T> T convertInstanceOfObject(Object o) {
        try {
            T rv = (T)o;
            return rv;
        } catch(java.lang.ClassCastException e) {
            return null;
        }
    }

    /**
     * This method will convert the time to microseconds
     * @param time in nanoseconds
     * @return time in microseconds
     */
    private long convertToMicroSeconds(long time) {
        return TimeUnit.MICROSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
