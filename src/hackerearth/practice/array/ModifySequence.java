package hackerearth.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ModifySequence {

    private static void canConvertToZeros(long[] arr, int size) {
        long prevCount = arr[0];
        for (int i = 0; i < size - 1; i++) {
            if ((arr[i + 1] - prevCount) < 0) {
                System.out.println("NO");
                return;
            }
            prevCount = arr[i + 1] - prevCount;
        }
        if (prevCount == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        canConvertToZeros(arr, size);
    }
}
