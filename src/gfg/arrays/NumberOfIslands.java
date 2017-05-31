package gfg.arrays;

public class NumberOfIslands {

    private static boolean isOk(int[][] arr, int rows, int cols, int rowIndex, int colIndex, boolean[][] visited) {
        return (rowIndex >= 0 && colIndex >= 0)
                && (rowIndex < rows && colIndex < cols)
                && arr[rowIndex][colIndex] > 0
                && !visited[rowIndex][colIndex];
    }
    private static int dfs(int[][] arr, int i, int j, boolean[][] visited, int rows, int cols) {
        int[] rowIndex = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colIndex = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            if (isOk(arr, rows, cols, i+rowIndex[k], j+colIndex[k], visited)) {
                dfs(arr, i+rowIndex[k], j+colIndex[k], visited, rows, cols);
            }
        }
        return 1;
    }

    private static void noOfIslands(int[][] arr, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0 && !visited[i][j]) {
                    count += dfs(arr, i, j, visited, m, n);
                }
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int mat[][] = {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        noOfIslands(mat, 5, 5);
    }
}
