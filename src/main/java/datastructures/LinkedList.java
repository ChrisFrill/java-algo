package main.java.datastructures;

public class LinkedList {
    // First node
    Node head;

    // Node class
    class Node {
        int data;
        // Next element in list
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    void sortedInsert(Node newNode) {
        Node current;

        // If list is empty or all elements larger than new node data
        if (head == null || head.data >= newNode.data) {
            newNode.next = head;
            head = newNode;
        } else  {
            current = head;
            // Iterate over elements until the next elements data is larger that the new nodes data
            // Or till there is no more elements left
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            // Insert the new node
            // List: 1 3
            // Current node: data = 1, next = 3
            // New node : data = 2, next = null
            newNode.next = current.next;
            // List: 1 3
            // Current node: data = 1, next = 3
            // New node : data = 2, next = 3
            current.next = newNode;
            // List: 1 2 3
            // Current node: data = 1, next = 2
            // New node : data = 2, next = 3
        }
    }
}
//ArrayList vs	LinkedList
// https://www.javatpoint.com/difference-between-arraylist-and-linkedlist
//   ArrayList internally uses a dynamic array to store the elements.
//   LinkedList internally uses a doubly linked list to store the elements.

//   Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the bits are shifted in memory.
//   Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.

//   An ArrayList class can act as a list only because it implements List only.
//   LinkedList class can act as a list and queue both because it implements List and Deque interfaces.

//   ArrayList is better for storing and accessing data.
//   LinkedList is better for manipulating data.