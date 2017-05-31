package gfg;

import java.util.Scanner;

/**
 * Given a binary array, find the maximum number zeros in an array with one flip of a subarray allowed.
 * A flip operation switches all 0s to 1s and 1s to 0s.
 * Input :  arr[] = {0, 1, 0, 0, 1, 1, 0}
 Output : 6
 We can get 6 zeros by flipping the subarray {1, 1}
 */
public class MaxZeroFlipSubArray {

    static void countMaxZerosByFlip(int[] arr) {
        int origZeros = 0;
        int maxDiff = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            if (arr[i] == 0) {
                origZeros++;
            }
            int count1 = 0, count0 = 0;
            for (int j = i; j < length ; j++) {
                if (arr[j] == 1) {
                    count1++;
                } else {
                    count0++;
                }
                maxDiff = Math.max(maxDiff, (count1 - count0));
            }
        }
        System.out.println(origZeros + maxDiff);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        countMaxZerosByFlip(arr);
    }
}
