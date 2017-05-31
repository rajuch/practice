package gfg.dp;

public class LongestIncreasingSubsequence {

    private static int lis(int[] arr, int index) {

        if (arr.length - 1 == index) {
            return 1;
        }

        return arr[index] < arr[index+1] ? lis(arr, index+1) + 1 : lis(arr, index+1);
    }

    private static int lisIterative(int[] arr) {
        int size = arr.length;
        int[] lis = new int[size];
         for (int i = 0; i < size; i++) {
             lis[i] = 1;
         }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if ((arr[j] < arr[i]) && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int v : lis) {
            if (v > max) {
                max = v;
            }
        }
        return max;
    }

    public static void main(String ars[]) {
        int[] arr = {8, 2, 5, 9, 6, 7};
        int count = lis(arr, 0);
        count = lisIterative(arr);
        System.out.println(count);
    }

}
