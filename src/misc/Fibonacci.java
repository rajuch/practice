package misc;

public class Fibonacci {

    private static int printFib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return printFib(n) + printFib(n-1);
    }

    private static void printFibIter(int n) {
        int prev1 = 0, prev2 = 1;
        int sum;
        System.out.println(prev1);
        System.out.println(prev2);
        while (n-- > 2) {
            System.out.println(prev1 + prev2);
            sum = prev1 + prev2;
            prev1 = prev2;
            prev2 = sum;
        }
    }

    public static void main(String[] args) {
        //printFib(5);
        printFibIter(10);
    }
}
