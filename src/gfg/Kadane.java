package gfg;

import java.util.Scanner;

public class Kadane {

    static void maxSubArray(int[] arr) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        for( int val : arr) {
            maxEndingHere += val;
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        System.out.println(maxSoFar);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        maxSubArray(arr);
    }
}
