package hackerrank.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {

    private static void pairsCount(int[] arr, int number) {
        Map<Integer, Integer> numberBy = new HashMap<>();
        for (int i : arr) {
            numberBy.put(i, 1);
        }
        int count = 0;
        Integer temp;
        for (int i : arr) {
            if ((temp = numberBy.get(Math.abs(number - i))) != null && temp == 1) {
                count++;
                numberBy.put(Math.abs(number - i), 2);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        pairsCount(arr, tokens[1]);
    }
}
