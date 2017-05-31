package gfg.arrays;

public class LargestContiguousSubArrSum {

    private static void kadaneSum(int[] arr) {
        int maxSoFar = 0, sum = 0;
        for (int i : arr) {
            sum += i;
            if (sum > maxSoFar) {
                maxSoFar = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(maxSoFar);
    }

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, 2, 1, 5, -3};
        kadaneSum(arr);
    }
}
