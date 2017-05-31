package gfg;

import java.util.Arrays;

public class IsUnique {

    private static boolean isUnique(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        char prev = Character.UNASSIGNED;
        for(char ch : chars) {
            if (prev == ch)
                return false;
            else {
                prev = ch;
            }
        }
        return true;
    }

    private static boolean isPermutationOf(String str1, String str2) {
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("0123"));
    }
}