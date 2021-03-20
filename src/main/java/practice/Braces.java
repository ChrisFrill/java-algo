package main.java.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Braces {
    public static void main(String[] args) {
        String braces = "{asd(wasd)}";
        System.out.println(isBalancedDeque(null));
        System.out.println(isBalancedDeque("asd"));
        System.out.println(isBalancedDeque("{asd(wasd)}"));
        System.out.println(isBalancedDeque("{}"));
        System.out.println(isBalancedDeque("()"));
        System.out.println(isBalancedDeque("{()}"));
        System.out.println(isBalancedDeque("{(}{}"));

    }

    public static boolean isBalanced(String string) {
        if (string == null || (string.length() % 2) != 0) {
            return false;
        } else {
            char[] chars = string.toCharArray();
            for (char character : chars) {
                if (!(character == '{' || character == '}' || character == '[' || character == ']' || character == '(' || character == ')')) {
                    return false;
                }
            }
            while (string.contains("{}") || string.contains("[]") || string.contains("()")) {
                string = string.replaceAll("\\{}", "")
                        .replaceAll("\\[]", "")
                        .replaceAll("\\(\\)", "");
            }
            return (string.length() == 0);
        }
    }

    public static boolean isBalancedDeque(String string) {
        System.out.println("---------------");
        Deque<Character> deque = new LinkedList<>();
        if (string == null ) {
            return false;
        } else {
            for (char character : string.toCharArray()) {
                if (character == '{' || character == '[' || character == '(') {
                    deque.addFirst(character);
                } else if (!deque.isEmpty() &&
                        ((deque.peekFirst() == '{' && character == '}')
                                || (deque.peekFirst() == '[' && character == ']')
                                || (deque.peekFirst() == '(' && character == ')'))) {
                    System.out.println("---");
                    System.out.println("Peek: " + deque.peek());
                    System.out.println("Peek first: " + deque.peekFirst());
                    System.out.println(character);
                    deque.removeFirst();
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}

