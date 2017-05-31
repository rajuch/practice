package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class BiggerIsGreater {

    private static void nextGreateOf(String str) {
        int l = str.length();
        boolean found = false;
        Stack<Integer> stack = new Stack();
        StringBuffer sb = new StringBuffer(str);
        for (int i = l-1; i > 0; i--) {
            if (str.charAt(i) > str.charAt(i-1)) {
                int temp = i;
                while(!stack.isEmpty()) {
                    int top = stack.pop();
                    if (str.charAt(top) > str.charAt(i-1) && str.charAt(temp) > str.charAt(top)) {
                        temp = top;
                    }
                }
                sb.replace(i-1, i, "" + str.charAt(temp));
                sb.replace(temp, temp+1, "" + str.charAt(i-1));
                // sort the characters after we found the index
                char[] chs = sb.substring(i).toCharArray();
                Arrays.sort(chs);
                sb.replace(i,l, new String(chs));
                found = true;
                break;
            } else {
                stack.push(i);
            }
        }
        if (found) {
            System.out.println(sb);
        } else {
            System.out.println("no answer");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        while(tests-- > 0) {
            String str = scanner.nextLine();
            nextGreateOf(str);
        }
    }
}
