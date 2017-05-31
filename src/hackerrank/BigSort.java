package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class BigComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        String str1 = (String)o1;
        String str2 = (String)o2;
        if (str1.length() > str2.length()) {
            return 1;
        } else if (str1.length() == str2.length()) {
            return str1.compareTo(str2);
        } else {
            return -1;
        }
    }
}
public class BigSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            unsorted[unsorted_i] = in.next();
        }
        Arrays.sort(unsorted, new BigComparator());
        for (String str: unsorted) {
            System.out.println(str);
        }
    }
}
