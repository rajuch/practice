package hackerearth.practice.array;

import java.util.Scanner;
import java.util.Stack;

public class NiceArches {

    private static boolean isBubbly(String word) {
        Stack<Character> stack = new Stack();
        int size = word.length();
        for (int i = 0; i < size; i++) {
            if (stack.size() == 0) {
                stack.add(word.charAt(i));
                continue;
            }
            char ch = stack.peek();
            if (ch == word.charAt(i)) {
                stack.pop();
            } else {
                stack.add(word.charAt(i));
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfWords = scanner.nextInt();
        scanner.nextLine();
        int bubblyCount = 0;
        for (int i = 0; i < noOfWords; i++) {
            String word = scanner.nextLine();
            if (isBubbly(word)) {
                bubblyCount++;
            } else {
                System.out.println(word);
            }
        }
        System.out.println(bubblyCount);
    }
}
