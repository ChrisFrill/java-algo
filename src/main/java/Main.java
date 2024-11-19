package main.java;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedList();
    }

    private static void linkedList() {
        int[] array = new int[]{};
//        array[0] = 1;
        System.out.println(Arrays.stream(array).max().orElseGet(() -> -1));

        // TODO: Check a learn transient keyword
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        System.out.println(linkedList);
        linkedList.add(3);
        System.out.println(linkedList);
        linkedList.add(2);
        System.out.println(linkedList);
    }
}
