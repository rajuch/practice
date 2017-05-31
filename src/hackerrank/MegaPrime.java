package hackerrank;
//https://www.hackerrank.com/contests/w29/challenges/megaprime-numbers

import java.util.Arrays;
import java.util.function.IntPredicate;

public class MegaPrime {

    private static int getNumber(int[] arr, double s, int k) {
        return Arrays.stream(arr).filter(i ->  i > 0 && i >= k).findFirst().getAsInt();
    }

    static IntPredicate predicate = new IntPredicate() {
        @Override
        public boolean test(int integer) {
            String str = String.valueOf(integer);
            return !("0".indexOf(str) > -1 || "4".indexOf(str) > -1|| "6".indexOf(str) > -1 || "8".indexOf(str) > -1);
        }
    };

    private void filter() {
    }

    private static void printMegaPrimes(int start, int end) {
        int arr[] = new int[end];
        for(int i = 1; i <= end; i++) {
            arr[i-1] = i;
        }
        arr[0] = 0;
        double s = Math.sqrt(end);
        for (int i=2; i < s; i++) {
            int num = getNumber(arr, s, i);
            System.out.println(num);
            for (int j = num; j < end; j++) {
                arr[j] = (arr[j] % num == 0) ? 0 : arr[j];
            }
        }
        int res[] = Arrays.stream(arr).filter(predicate).toArray();
        for (int i : res) {
            //System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printMegaPrimes(1, 100);
    }
}
