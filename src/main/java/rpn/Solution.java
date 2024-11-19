import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        solution();
    }

    private static void solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                rpn(s);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }


    public static void rpn(String input) {
        Stack<Integer> stack = new Stack<>();
        boolean failed = false;
        for (String character : input.split("\\s+")) {
            if (character.equals("+")) {
                if (stack.empty() || stack.size() != 2) {
                    failed = true;
                    break;
                }
                int x = stack.pop();
                int y = stack.pop();
                stack.push(x + y);
            } else if (character.equals("-")) {
                if (stack.empty() || stack.size() != 2) {
                    failed = true;
                    break;
                }
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y - x);
            } else if (character.equals("*")) {
                if (stack.empty() || stack.size() != 2) {
                    failed = true;
                    break;
                }
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y * x);
            } else if (character.equals("/")) {
                if (stack.empty() || stack.size() != 2) {
                    failed = true;
                    break;
                }
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y / x);
            } else if (character.equals("x")) {
                if (stack.empty() || stack.size() != 2) {
                    failed = true;
                    break;
                }
                stack.push(stack.pop() + (int) Math.pow(stack.pop(), 2));
            } else if (character.equals("y")) {
                if (stack.empty()) {
                    failed = true;
                    break;
                }
                stack.push(stack.pop() * 2 + 1);
            } else if (character.equals("z")) {
                if (stack.empty() || stack.size() != 3) {
                    failed = true;
                    break;
                }
                stack.push(stack.pop() * 3 + stack.pop() * 2 + stack.pop());
            } else {
                stack.push(Integer.parseInt(character));
            }
        }
        if (stack.size() == 1 && !failed){
            System.out.println(stack.pop());
        } else {
            System.out.println("NO");
        }
    }

}