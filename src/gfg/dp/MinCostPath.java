package gfg.dp;

public class MinCostPath {

    private static int minCost(int[][] matrix, int m, int n, int size1, int size2) {
        if (m == size1 - 1 && n == size2 - 1) {
            return matrix[m][n];
        }

        if (m == size1 - 1) {
            return matrix[m][n] + minCost(matrix, m, n+1, size1, size2);
        }
        if (n == size2 - 1) {
            return matrix[m][n] + minCost(matrix, m+1, n, size1, size2);
        }

        return matrix[m][n] + Math.min(
                minCost(matrix, m, n+1, size1, size2),
                Math.min(minCost(matrix, m+1, n, size1, size2), minCost(matrix, m+1, n+1, size1, size2)));
    }

    private static int minCostDP(int[][] matrix, int size1, int size2) {
        int[][] cost = new int[size1+1][size2+1];
        cost[0][0] = 0;
        for (int i = 1; i <= size1; i++) {
            cost[i][0] = cost[i-1][0] + matrix[i-1][0];
        }
        for (int i = 1; i <= size2; i++) {
            cost[0][i] = cost[0][i-1] + matrix[0][i-1];
        }
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                    cost[i][j] = matrix[i-1][j-1] + Math.min(cost[i-1][j], Math.min(cost[i][j-1], cost[i-1][j-1]));
            }
        }
        return cost[size1][size2];
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 8, 2}, {1, 5, 3}};
        System.out.println(minCost(matrix, 0, 0, 3, 3));
        System.out.println(minCostDP(matrix, 3, 3));
    }
}
