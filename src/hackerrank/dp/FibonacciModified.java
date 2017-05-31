package hackerrank.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    private static void printFiboOf(int n, BigInteger t1, BigInteger t2) {
        int i=3;
        BigInteger fib = null;

        while(i++ <= n) {
            fib = t1.add(t2.pow(2));
            t1 = t2;
            t2 = fib;
        }
        System.out.println(fib);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger t1 = new BigInteger(scanner.next());
        BigInteger t2 = new BigInteger(scanner.next());
        int n = scanner.nextInt();
        printFiboOf(n, t1, t2);

    }
}
