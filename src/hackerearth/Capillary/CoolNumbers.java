package hackerearth.Capillary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CoolNumbers {

    private static Map<Integer, List<Long>> coolNumbers = new HashMap<>();
    private static void build(int l) {
        List<Long> numbers = coolNumbers.get(l - 1);
        List<Long> newNumbers = new ArrayList<>();
        int[] arr = {2, 5};
        for (int i : arr) {
            for (Long number : numbers) {
                newNumbers.add(Long.parseLong(String.valueOf(i) + number));
            }
        }
        coolNumbers.put(l, newNumbers);
    }
    private static void buildCoolNumbers() {
        List<Long> list = new ArrayList<>();
        list.add(2L);
        list.add(5L);
        coolNumbers.put(1, list);
        for (int i = 2; i <= 9; i++) {
            build(i);
        }
    }

    private static long nextNumber(long num) {
        String str = String.valueOf(num);
        int length = str.length();
        List<Long> numbers = coolNumbers.get(length);
        if (Integer.parseInt("" + str.charAt(0)) > 5) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) >= num) {
                    return numbers.get(i);
                }
            }
        }

        List<Long> numbers1 = coolNumbers.get(str.length() + 1);
        for (int i = 0; i < numbers1.size(); i++) {
            if (numbers1.get(i) >= num) {
                return numbers1.get(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        buildCoolNumbers();
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        while (tests-- > 0) {
            long[] boundaries = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
            long count = 0;
            for (long i = boundaries[0]; i <= boundaries[1]; i++) {
                count += nextNumber(i);
            }
            System.out.println(count);
        }
    }
}
