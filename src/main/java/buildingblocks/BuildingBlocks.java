package main.java.buildingblocks;

import java.util.*;

public class BuildingBlocks {
    // String array
    String[] stringArr = new String[10];

    // Int array
    int[] arr = new int[10];

    // HashMap
    HashMap<String, Integer> hashMap = new HashMap<>();

    // Stack
    Stack<String> stack = new Stack<>();
    {
        stack.push("add");
        stack.pop();
        stack.peek();
        stack.empty();
    }

    // List
    List<String> list = new ArrayList<>();

    // Arrays as List
    List<String> arraysAsList = Arrays.asList("first", "second");

    // LinkedList
    LinkedList<String> linkedList = new LinkedList<>();
    {
        linkedList.addFirst("add");
        linkedList.addLast("add");
        linkedList.pollFirst();
        linkedList.pollLast();
        linkedList.poll(); // returns null if empty
        linkedList.pop(); // throws exception
        linkedList.peekFirst();
        linkedList.peekLast();
        linkedList.peek();
    }

    // Queue
    Queue<String> queue = new LinkedList<>();
    {
        queue.add("add");
        queue.poll();
        queue.peek();
    }

    // Deque
    Deque<String> deque = new LinkedList<>();
    {
        deque.addFirst("add");
        deque.addLast("add");
        deque.pollFirst();
        deque.pollLast();
        deque.poll();
        deque.pop();
        deque.peekFirst();
        deque.peekLast();
        deque.peek();
    }

    // For
    private void forLoop() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {

        }
    }

    // 2xFor
    private void doubleForLoop() {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {

            }
        }
    }

    private void loopBackWard() {
        int[] arr = new int[10];
        for (int i = arr.length - 1; i >= 0; i--) {

        }
    }

    private void countToHashMap(String key) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if(!hashMap.containsKey(key)) {
            hashMap.put(key, 0);
        }
        hashMap.put(key, hashMap.get(key) + 1);
        // OR hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
    }

    private void countToHashMapEasy(String key) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    {
        arr = Arrays.stream(arr).map(Math::abs).toArray();
        Arrays.sort(arr);
        Integer[] array = new Integer[10];
        Arrays.sort(array, Collections.reverseOrder());
    }
}
