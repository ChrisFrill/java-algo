package main.java;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedList();
    }

    private static void linkedList() {
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
