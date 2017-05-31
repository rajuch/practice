package gfg.arrays;

import java.util.Stack;

public class CelebrityProblem {

    static int matrix[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    private static boolean knows(int a, int b) {
        return matrix[a][b] > 0;
    }

    private static void celebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while ( i < n) {
            stack.push(i);
            i++;
        }
        int t = stack.pop();
        while (!stack.isEmpty()) {
            int k = stack.pop();
            if (knows(t, k)) {
                t = k;
            }
        }
        for (int j = 0; j < n; j++) {
            if (j!=t && !knows(j, t)) {
                return;
            }
        }
        System.out.println(t);
    }
    public static void main(String args[]) {
        celebrity(4);
    }
}
