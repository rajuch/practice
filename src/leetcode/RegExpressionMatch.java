package leetcode;

/**
 * https://leetcode.com/problems/regular-expression-matching/#/description
 * Implement regular expression matching with support for '.' and '*'.
 */
public class RegExpressionMatch {

    public static boolean isMatch(String s, String p) {
        int patternPtr = 0;
        int length = s.length();
        int pLength = p.length();
        int i = 0;
        while (i < length && patternPtr < pLength) {
            Character ch = s.charAt(i);
            Character pCh = p.charAt(patternPtr);

            if (ch == pCh || pCh == '.') {
                patternPtr++;
                i++;
            } else if (pCh == '*') {
                if (p.charAt(patternPtr - 1) == ch || p.charAt(patternPtr - 1) == '.') {
                    i++;
                } else {
                    patternPtr++;
                }
            } else {
                return false;
            }
        }
        if (i != length) {
            return false;
        }
        if (pLength == patternPtr) {
            return true;
        } else {
            if ((patternPtr + 1 == pLength && p.charAt(patternPtr) == '*')) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aabbcc", ".*"));
    }
}
