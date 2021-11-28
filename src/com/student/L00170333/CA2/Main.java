package com.student.L00170333.CA2;

public class Main {

    public static void main(String[] args) {
        IList<Integer> aList = new GenericArrayList<>();
        aList.add(5);
        aList.add(3);
        aList.add(8);
        printList("aList", aList);

        IList<String> aSecondList = new GenericArrayList<>();
        aSecondList.add("Tom");
        aSecondList.add("Dick");
        aSecondList.add("Harry");
        printList("aSecondList", aSecondList);

        IList<String> aThirdList = new GenericLinkedList<>();
        aThirdList.add("Me");
        aThirdList.add("Myself");
        aThirdList.add("I");
        printList("aThirdList", aThirdList);
    }

    private static <T> void printList(String listName, IList<T> listToPrint) {
        System.out.println(listName + " contains:");
        for(int i = 0; i < listToPrint.size(); i++)
        {
            System.out.print(listToPrint.get(i) + " ");
        }
        System.out.println();
    }
}