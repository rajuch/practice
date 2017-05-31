package gfg.dp;

/**
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily
 * contiguous.
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */

public class LongestCommonSubSequence {

    private static int lcs(String str1, String str2, int index1, int index2) {
        if (index1 == 0 || index2 == 0) {
            return 0;
        }
        if (str1.charAt(index1-1) == str2.charAt(index2-1)) {
            return 1 + lcs(str1, str2, index1-1, index2-1);
        }
        return Math.max(lcs(str1, str2, index1-1, index2), lcs(str1, str2, index1, index2-1));
    }

    private static int lcs(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        int[][] lcs = new int[length1+1][length2+1];
        for (int i=0; i<=length1; i++) {
            for (int j=0; j<=length2; j++) {
                lcs[i][j] = 0;
            }
        }
        for (int i=1; i<=length1; i++) {
            for (int j=1; j<=length2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        return lcs[length1][length2];
    }

    public static void main(String[] args) {
        String str1 = "AAAAA";
        String str2 = "AAAA";
        System.out.println(lcs(str1, str2));
    }
}
