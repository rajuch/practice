package hackerrank;

import java.util.*;

public class AbsolutePermutation {
    private static void print (int n, int k) {
        int count = 1, t = 2*k;

        while (count <= n) {
            if (k == 0) {
                System.out.println(count);
            }
            else if ( k == 1) {
                System.out.print((count % 2 == 0 ? count - 1: count + 1) + " ");
            } else {
                int rem = count % t;
                if (rem == 0) {
                    System.out.print(count - k);
                } else {
                    System.out.print(rem <= k ? count + k : count - k);
                }
                System.out.print(" ");
            }
            count++;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            if (k == 0 || (n % (2*k)) == 0) {
                print(n, k);
            } else {
                System.out.println(-1);
            }
        }
    }
}
