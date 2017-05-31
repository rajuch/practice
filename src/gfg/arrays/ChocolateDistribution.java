package gfg.arrays;

import java.util.Arrays;

public class ChocolateDistribution {

    private static int getMinDiff(int[] arr, int m) {
        Arrays.sort(arr);

        int length = arr.length;
        int min = Integer.MAX_VALUE, temp;
        for (int i = 0; (i+m) <= length; i++) {
            if ((temp = arr[i + m - 1] - arr[i]) < min ) {
                //System.out.println("v " + arr[i + m - 1]);
                min = temp;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        System.out.println(getMinDiff(arr, 3));

        int[] arr1 = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(getMinDiff(arr1, 5));
    }
}
