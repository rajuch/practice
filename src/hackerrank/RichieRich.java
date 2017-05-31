package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class RichieRich {

    private static void maxNumber(String str, int length, int noOfChanges) {
        if (length == 1) {
            if (noOfChanges > 0) {
                System.out.println(9);
            } else {
                System.out.println(str);
            }
        }
        int noOfRequiredChanges = 0;
        for (int i = 0; i < length/2; i++) {
            if (str.charAt(i) != str.charAt(length-i- 1)) {
                noOfRequiredChanges++;
            }
        }
        System.out.println(noOfRequiredChanges);
        int changes;
        if ((changes = noOfChanges - noOfRequiredChanges) < 0 ) {
            System.out.println("-1");
        }
        StringBuffer sb = new StringBuffer(str);
        for (int i=0; i<length/2; i++) {
            if (changes > 0 && str.charAt(i) != '9' && str.charAt(length-i- 1) != '9') {
                sb.replace(i, i+1, "9");
                sb.replace(length-i-1, length-i, "9");
                changes -= 2;
            } else if (str.charAt(i) != str.charAt(length-i- 1)) {
                if (str.charAt(i) > str.charAt(length-i-1)) {
                    sb.replace(length-i-1, length-i, ""+str.charAt(i));
                } else {
                    sb.replace(i, i+1, ""+str.charAt(length-i-1));
                }
            }
        }
        if (changes > 0 && length % 2 != 0) {
            sb.replace(length/2, length/2+1, "9");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input[] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String str = scanner.nextLine();
        maxNumber(str, input[0], input[1]);
    }
}
