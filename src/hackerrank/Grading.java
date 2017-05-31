package hackerrank;

import java.util.Scanner;

public class Grading {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            int grade = in.nextInt();
            int rem = 5 - (grade % 5);
            if (rem < 3 && grade >= 38) {
                System.out.println(grade + rem);
            } else {
                System.out.println(grade);
            }
        }
    }
}
