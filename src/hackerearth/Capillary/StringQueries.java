package hackerearth.Capillary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a
 1
 1-indexed String
 S
 S of length
 N
 N, consisting of lowercase English alphabets, you need to answer queries based on the properties of this string.

 You shall be given
 Q
 Q queries to answer. In each query you shall be given
 2
 2 integers
 L
 L and
 R
 R. Now , you need to report the minimum number of String elements you need to delete in the substring of String
 S
 S ranging from
 L
 L to
 R
 R inclusive, so that each distinct character occurring in the range occurs equal number of times.

 For example, consider the String
 "
 a
 b
 c
 d
 a
 b
 "
 "abcdab" . Here, the characters occurring in this String are
 ′
 a
 ′
 ′a′.
 ′
 b
 ′
 ′b′,
 ′
 c
 ′
 ′c′ and
 ′
 d
 ′
 ′d′. On deleting one occurrence of
 ′
 a
 ′
 ′a′ as well as
 ′
 b
 ′
 ′b′ one of the possible Strings is
 a
 b
 c
 d
 abcd. Each character occuring in the range now occurs equal number of times. So, the minimum number of deletions is two.

 Note that we need to equalize the count of only characters that occur in the range, and not of characters that do not. It is allowed to delete all occurences of a character, so that it no longer occurs in the range at all
 */
public class StringQueries {

    private static int makeSame(String str, long length, int start, int end) {
        Map<Character, Integer> count = new HashMap<>();

        for (int i = start -1; i < end; i++) {
            Character ch = str.charAt(i);
            Integer c = count.get(ch);
            count.put(ch, c == null ? 0 : c.intValue() + 1);
        }
        int min = Integer.MAX_VALUE;
        for (char ch : count.keySet()) {
            if (count.get(ch) < min) {
                min = count.get(ch);
            }
        }
        int total = 0;
        for (char ch : count.keySet()) {
            if (count.get(ch) > min) {
                total += count.get(ch) - min;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long[] arr = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
        String str = scanner.nextLine();
        for (int i =0 ; i < arr[1]; i++) {
            int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(makeSame(str, arr[0], indexes[0], indexes[1]));
        }
    }
}
