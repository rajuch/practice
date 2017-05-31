package codewars;

import java.util.Arrays;
import java.util.Scanner;

public class OrderWords {

    private static String orderWord(String word) {
        if (word == null || word.equals("")) {
            return "Invalid String!";
        }
        char[] chars =  word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(orderWord(s));
    }
}
