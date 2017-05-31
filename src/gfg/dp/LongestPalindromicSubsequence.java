package gfg.dp;

public class LongestPalindromicSubsequence {

    private static int palindrome(String str, int start, int end) {
        if (start == end) {
            return 1;
        } else if (start > end) {
            return 0;
        }

        return str.charAt(start) == str.charAt(end)
                ? 2 + palindrome(str, start + 1, end - 1)
                : Math.max(palindrome(str, start, end - 1), palindrome(str, start + 1, end));
    }

    private static int palindromeDP(String str) {
        int length = str.length();
        boolean dp[][] = new boolean[length][length];
        int maxLength = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                dp[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // length 3 and above
        for (int k = 3 ; k <= length; k++) {
            for (int i = 0; i < length - k + 1; i++) {
                int j = i + k -1;

                if (dp[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        System.out.println(maxLength);
        if (maxLength > 1) {
            System.out.println(str.substring(start, start+maxLength));
        } else {
            System.out.println(str.charAt(0));
        }

        return 0;
    }

    public static void main(String[] args) {
        //palindrome("raju", 0, 4);
        palindromeDP("forgeeksskeegfor");
    }
}
