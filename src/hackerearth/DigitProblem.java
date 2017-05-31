package hackerearth;

import java.util.Scanner;

public class DigitProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] numbers = scanner.next().toCharArray();
        int times = scanner.nextInt();
        int length = numbers.length;
        int start = 0;
        for (; start < length; start++) {
            if (times > 0 && numbers[start] != '9') {
                numbers[start] = '9';
                times--;
            }
            if(times == 0) {
                break;
            }
        }

        System.out.println(new String(numbers));
    }
}
