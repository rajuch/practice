package hackerearth.practice.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueSubArray {

    private static int count(int n) {
        int res = 0;
        int k = n;
        for (int i=1; i <= n; i++, k--) {
            res += k * i;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        while (tests-- > 0) {
            int size = scanner.nextInt();
            scanner.nextLine();
            long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            Set set = new HashSet<>();
            for (long val : arr) {
                set.add(val);
            }
            System.out.println(count(set.size()));
        }
    }
}
