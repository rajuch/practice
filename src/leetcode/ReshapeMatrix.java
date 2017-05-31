package leetcode;

public class ReshapeMatrix {

    private int rowPtr, colPtr;
    public int getNextVal(int[][] nums, int cols) {
        if (colPtr < cols) {
            return nums[rowPtr][colPtr++];
        } else {
            colPtr = 0;
            return nums[++rowPtr][colPtr];
        }
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        int rows = nums.length;
        int cols = nums[0].length;

        if (r * c != rows * cols) {
            return nums;
        }
        rowPtr = 0;
        colPtr = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = getNextVal(nums, cols);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReshapeMatrix obj = new ReshapeMatrix();
        int nums[][] = {{1, 2}, {3,4}};
        obj.matrixReshape(nums, 1, 4);
    }
}
