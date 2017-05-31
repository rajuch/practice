package leetcode;

/**
 * https://leetcode.com/problems/permutation-in-string/#/description
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Input s1 = "ab" s2 = "eidbaooo"
 * output true
 *
 * s1= "ab" s2 = "eidboaoo"
 * output false
 */
public class PermutationInString {

    private static boolean allZeros(int[] count) {
        for (int val : count) {
            if (val > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        int count[] = new int[26];
        int len1 = s1.length();
        int len2 = s2.length();

        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZeros(count)) {
            return true;
        }
        for (int i=len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i-len1) - 'a']++;
            if(allZeros(count)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("dcaa", "abcdea"));
    }
}
