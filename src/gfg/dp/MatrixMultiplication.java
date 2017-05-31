package gfg.dp;

public class MatrixMultiplication {

    private static int matrixChainOrder(int[] arr, int from, int to) {
        if (from == to) {
            return 0;
        }
        int minCount = Integer.MAX_VALUE;
        for (int k = from; k < to; k++) {
            int count = matrixChainOrder(arr, from, k) +
                    matrixChainOrder(arr, k+1, to) +
                    arr[from -1] * arr[k] * arr[to];
            if (count < minCount) {
                minCount = count;
            }
        }
        return minCount;
    }
    public static void main(String[] args) {
        int arr[] = {40, 20, 30, 10, 30};
        matrixChainOrder(arr, 1, 4);
    }
}
