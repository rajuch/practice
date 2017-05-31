package hackerearth;

import java.util.Scanner;

public class DistinctPowers {

    private static void nextNumber(String num) {
        String res = "";
        boolean found = false;
        int length = num.length();
        for (int i = length -1 ; i >= 0 ; i--) {
            if (!found && num.charAt(i) == '0') {
                res += "1";
                found = true;
            } else {
                res += num.charAt(i);
            }
        }
        if (num.equals(res)) {
            res = "1" + res;
        }
        System.out.println(Long.parseLong(new StringBuilder(res).reverse().toString(), 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        while (tests-- > 0) {
            long num = scanner.nextLong();
            nextNumber(Long.toBinaryString(num));
        }
    }
}
