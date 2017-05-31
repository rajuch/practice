package leetcode;

import java.math.BigDecimal;

public class Power {

    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = myPow(x, n/2);
        if (n%2 == 0) {
            return temp * temp;
        } else {
            return n > 0 ? x * temp * temp : temp * temp/x;
        }
    }
    public static void main(String[] args) {
        System.out.println(myPow(2, -3));
        BigDecimal val = new BigDecimal(0);
        System.out.println(val.doubleValue() == 0);
    }
}
