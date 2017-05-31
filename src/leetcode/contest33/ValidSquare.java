package leetcode.contest33;

public class ValidSquare {

    private static double distance(int[] p1, int[] p2) {
        return (p1[0] - p2[0])*(p1[0]-p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]);
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double d2 = distance(p1, p2);
        double d3 = distance(p1, p3);
        double d4 = distance(p1, p4);

        if (d2 == d3 && 2*d2 == d4) {
            double d = distance(p2, p4);
            return d == distance(p3, p4) && d == d2;
        }
        if (d3 == d4 &&  2*d3 == d2) {
            double d = distance(p3, p2);
            return d == distance(p4, p2) && d == d3;
        }
        if (d2 == d4 && 2*d2 == d3) {
            double d = distance(p2, p3);
            return d == distance(p4, p3) && d == d2;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] p1 = {0, 0};
        int[] p2 = {1, 1};
        int[] p3 = {1, 0};
        int[] p4 = {0, 1};

        System.out.println(validSquare(p1, p2, p3, p4));
    }
}
