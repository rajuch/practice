package gfg.arrays;

public class RotateMatrix {

    private static void transpose(int[][] matrix, int m, int n) {
        for (int  i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private static void reverseColumns(int[][] matrix, int m, int n) {
        for (int  i = 0; i < m; i++) {
            for (int j = 0, k=n-1; j < k; j++, k--) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[k][i];
                matrix[k][i] = temp;
            }
        }
    }

    private static void print(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        transpose(matrix, 4, 4);
        reverseColumns(matrix, 4, 4);
        print(matrix, 4, 4);

    }
}
