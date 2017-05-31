package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {



    private static boolean isAnagram(String str1, String str2) {
        Math.pow(10, 2);
        int length1 = str1.length();
        int length2 = str2.length();

        if (length1 != length2) {
            return false;
        }
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < length1; i++) {
            Integer count = charCount.get(str1.charAt(i));
            charCount.put(str1.charAt(i), count == null ? 1 : ++count);
        }
        for (int i = 0; i < length2; i++) {
            Character ch = str2.charAt(i);
            Integer count = charCount.get(ch);
            if (count == null || count <= 0) {
                return false;
            }
            charCount.put(ch, --count);
        }
        return true;
    }

    private static List<List<String>> group(String[] strings) {
        Set<String> finished = new HashSet<>();
        int noOfStrings = strings.length;
        List<List<String>> anagrams = new ArrayList<>();
        for (int i = 0; i < noOfStrings; i++) {
            if (finished.contains(strings[i])) {
                continue;
            }
            List<String> subAnagrams = new ArrayList<>();
            subAnagrams.add(strings[i]);
            for (int j = i + 1; j < noOfStrings; j++) {
                if (isAnagram(strings[i], strings[j])) {
                    finished.add(strings[j]);
                    subAnagrams.add(strings[j]);
                }
            }
            anagrams.add(subAnagrams);
        }
        return anagrams;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("read", "dear"));
        String[] strings = {"read", "dear", "ader", "ther", "rthe"};
        group(strings);
    }
}
