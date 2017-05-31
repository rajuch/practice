package hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class OneSizedGame {

    private static void game(long[] arr, int size) {
        int len = length(arr);
        if (len == 1) {
            System.out.println("Ladia");
            return;
        }
        if (len == 0) {
            System.out.println("Kushagra");
            return;
        }
        int minIndex = getMin(arr, size);
        subtract(arr, minIndex, size);
        game(arr, size);
    }

    private static void subtract(long[] arr, int val, int size) {
        for (int i = 0; i < size; i++) {
            arr[i] -= val;
        }
    }
    private static int length(long[] arr) {
        int length = 0;
        for (long v : arr) {
            if (v > -1) {
                length++;
            }
        }
        return length;
    }

    private static int getMin(long[] arr, int size) {
        long min = Long.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) {
                index--;
            }
            if (arr[i] >= 0 && arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index + 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < tests; i++) {
            int size = Integer.parseInt(scanner.nextLine());
            long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            game(arr, size);
        }
    }
}
