package hackerearth.janEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NotSoSimple {

    private static int noOfQueries;
    private static List<Long> queries = new ArrayList<>();
    private static List<Integer> counts ;

    private static long gcd(long n1, long n2) {
        long r;
        while(n2 != 0)
        {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }

    private static long[][] calculate(long[] arr, int size) {
        long[][] gcd = new long[size+1][size+1];
        for (int i=1; i <= size; i++) {
            for (int j=i; j <= size; j++) {
                if (i == j) {
                    gcd[i][j] = arr[i-1];
                } else {
                    gcd[i][j] = gcd(arr[j-1], gcd[i][j-1]);
                }
            }
        }
        return gcd;
    }

    private static void calculateGCD(int index, long[] arr, int size) {
        long prev = arr[index-1];
        for (int i=index; i <= size; i++) {
            prev = gcd(prev, arr[i-1]);
            count(prev);
        }
    }

    private static void count(long val) {
        for (int i = 0; i < noOfQueries; i++) {
            if (queries.get(2*i) <= val && queries.get(2*i+1) >= val) {
                System.out.println(i + " " + counts.get(i));
                counts.set(i, counts.get(i)+1);
            }
        }
    }

    private static void countSubArraysBetween(long min, long max, long gcd[][], int size) {
        int count = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (gcd[i][j] >= min && gcd[i][j] <= max) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine(); // eat the line
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
       // long[][] gcd = calculate(arr, size);
        noOfQueries = scanner.nextInt();
        counts = new ArrayList<>(noOfQueries);
        int temp = noOfQueries;
        scanner.nextLine(); // eat the line
        while (temp-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            queries.add(Long.parseLong(tokens[0]));
            queries.add(Long.parseLong(tokens[1]));
            counts.add(0);
        }
        for (int i=0; i<size; i++) {
            calculateGCD(i+1, arr, size);
        }
        for (int val : counts) {
            System.out.println(val);
        }
    }
}
