package leetcode;

/**
 * https://leetcode.com/problems/friend-circles/#/description
 *
 * Pending
 *
 */
public class FriendCircles {

    private static void count(int[][] M, boolean[][] visited, int rows, int cols, int row, int col) {
        int i = row;
        for (int j = col; j < cols; j++) {
            if ( i != j && !visited[i][j] && M[i][j] == 1) {
                visited[i][j] = visited[j][i] = true;
                count(M, visited, rows, cols, j, j);
            }
        }
    }
    public static int findCircleNum(int[][] M) {
        int rows = M.length;
        int cols = M[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int circleCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < rows-1; i++) {
            for (int j = i + 1; j < cols; j++) {
                if ( i != j && !visited[i][j] && M[i][j] == 1) {
                    visited[i][j] = true;
                    count(M, visited, rows, cols, j, j);
                    circleCount++;
                }
            }
        }

        return circleCount;
    }
}
