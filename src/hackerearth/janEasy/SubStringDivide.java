package hackerearth.janEasy;

import java.util.Scanner;

public class SubStringDivide {

    private static int calculate(String str, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length - i; j++) {
                long number = Long.parseLong(str.substring(i, j+i));
                if ( number % 8 == 0 && number % 3 > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < tests; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            System.out.println(calculate(str, size));
        }
    }
}
