package gfg.dp;

public class EditDistance {

    private static int editDistance(String str1, String str2, int l1, int l2) {
        if (l1 == 0) {
            return l2;
        }
        if (l2 == 0) {
            return l1;
        }
        if (str1.charAt(l1 - 1) == str2.charAt(l2 - 1)) {
            return editDistance(str1, str2, l1 - 1, l2 - 1);
        } else {
            return 1 +  Math.min(editDistance(str1, str2, l1 - 1, l2),
                    Math.min(editDistance(str1, str2, l1, l2 - 1), editDistance(str1, str2, l1 - 1, l2 - 1)));
        }
    }

    private static int editDistanceDP(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dis = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dis[i][j] = j;
                } else if (j == 0) {
                    dis[i][j] = i;
                } else {
                    if (str1.charAt(i-1) == str2.charAt(j-1)) {
                        dis[i][j] = dis[i-1][j-1];
                    } else {
                        dis[i][j] = 1 + Math.min(dis[i-1][j-1], Math.min(dis[i-1][j], dis[i][j-1]));
                    }
                }
            }
        }
        return dis[m][n];
    }

    public static void main(String args[]) {
        String str1 = "abcd";
        String str2 = "xayz";
        System.out.println(editDistance(str1, str2, str1.length(), str2.length()));
    }
}
