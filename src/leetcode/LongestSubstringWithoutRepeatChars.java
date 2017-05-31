package leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Given "abcabcbb", the answer is "abc", which the length is 3
 * Given "bbbbb", the answer is "b", with the length of
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */
public class LongestSubstringWithoutRepeatChars {

    public static int lengthOfLongestSubstring(String s) {
        int length;
        if (s == null || (length = s.length()) == 0) {
            return 0;
        }
        int maxLength = 1, currentLength = 1;
        String res = "" + s.charAt(0);
        for (int i = 1; i < length; i++) {
            int index;
            if ((index = res.indexOf(s.charAt(i))) > -1) {
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                res = (res.length() > 1 ? res.substring(index + 1) : "") + s.charAt(i);
                currentLength = res.length();
            } else {
                res += s.charAt(i);
                currentLength++;
            }
        }
        return currentLength > maxLength ? currentLength : maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
