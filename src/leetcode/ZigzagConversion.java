package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ZigzagConversion {

    private String test(String s, int rowNumber, int nRows, Set<String> visited) {
        String res = "";
        for (int i=rowNumber; i < s.length(); ) {
            res += s.charAt(i);
           // i +=
        }
        return res;
    }

    private static String convert(String s, int nRows) {
        String res = "";
        Set<String> visited = new HashSet<>();

        for (int i=1; i <= nRows; i++) {
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
