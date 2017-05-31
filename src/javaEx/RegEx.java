package javaEx;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {

    private static void test(String str) {
        String pattern = "(.*)(\\d{10})(.*)";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(str);

        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
    }

    public static void main(String[] args) {
        test("hi hello 9999990000 jflsds");
    }
}
