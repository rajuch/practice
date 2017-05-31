package gfg.arrays;

public class LargestNonContiguousArrSum {

    private static void sum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            if (i > 0 ) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {

    }
}
