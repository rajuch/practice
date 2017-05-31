package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class MillyAndRanks {

    private static void convertToDistinct(int[] arr, int size) {
        int units = 0;
        int temp;
        for (int i = 1; i < size; i++) {
            if ((arr[i] - arr[i - 1]) <= 0) {
                temp = (arr[i-1] - arr[i]) + 1;
                units += temp;
                arr[i] += temp;
            }
        }
        System.out.println(units);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        while (tests-- > 0) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            convertToDistinct(arr, n);
        }
    }
}
