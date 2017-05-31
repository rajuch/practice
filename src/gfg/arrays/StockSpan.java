package gfg.arrays;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpan {

    private static void calculate(int[] arr) {
        int length = arr.length;
        Stack<Integer> stack = new Stack();
        int[] span = new int[length];
        for (int i = length-1; i > 0; i--) {
            int count = 1;
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                int index = stack.pop();
                span[index] = count++;
            }

            stack.push(i);
        }
        int count = 1;
        while (!stack.isEmpty()) {
            span[stack.pop()] = count++;
        }
        for (int i : span) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        calculate(arr);
    }
}
