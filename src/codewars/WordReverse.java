package codewars;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordReverse {


    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
                .collect(Collectors.joining(" "));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String res = spinWords(scanner.nextLine());
        System.out.println(res);
    }
}
