import java.util.Arrays;
import java.util.List;

public class BluJayPr2 {

    private String maxTime(int A, int B, int C, int D) {
        List<Integer> list = Arrays.asList(A, B, C, D);
        boolean found = false;
        int hours, maxHours = Integer.MIN_VALUE, minutes, maxMinuntes = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                hours = list.get(i) * 10 + list.get(j);
                if (i == j || hours > 23) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    if (list.get(k) * 10 > 50 || j == k || k == i) {
                        continue;
                    }
                    for (int l = 0; l < 4; l++) {
                        minutes = list.get(k) * 10 + list.get(l);
                        if (l == k || l == i || l == j || minutes > 59) {
                            continue;
                        }
                        found = true;
                        if (maxHours < hours) {
                            maxHours = hours;
                            maxMinuntes = minutes;
                        } else if (maxHours == hours) {
                            maxMinuntes = Math.max(maxMinuntes, minutes);
                        }
                    }
                }
            }
        }
        if (!found) {
            return "NOT POSSIBLE";
        }
        String res = "" + maxHours + ":";
        if (maxHours <= 9) {
            res = "0" + maxHours + ":";
        }
        res += maxMinuntes <= 9 ? "0" + maxMinuntes : maxMinuntes;

        return res;
    }

    public static void main(String[] args) {
        BluJayPr2 obj = new BluJayPr2();
        System.out.println(obj.maxTime(1, 4, 0, 0));
    }
}
