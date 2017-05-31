package hackerrank;

import java.util.Scanner;

public class RecoverArray {

    public void RecoverArray() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] file = new int[n];
        int count = 0;
        int index = -1;
        for(int file_i=0; file_i < n; file_i++){
            file[file_i] = in.nextInt();
            if (index == -1) {
                index = file[file_i] + 1;
                count++;
            } else if (index == file_i) {
                index += file[file_i] + 1;
                count++;
            }
        }
        System.out.println(count);
    }
}
