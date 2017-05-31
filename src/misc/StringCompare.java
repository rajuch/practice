package misc;

public class StringCompare {

    enum Compare {
        A, B, C
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        String str3 = str1;

        if (str1 == str2) {
            System.out.println("same");
        }
        if (str1 == str3) {
            System.out.println("13same");
        }
        if (str2 == str3) {
            System.out.println("23same");
        }
        String str4 = new String("abc");
        if (str1 == str4) {
            System.out.println("hehe");
        }
        String str = null;
        try {
            str.charAt(0);
        } catch (Exception e) {
            System.out.println("catched");
        }
    }
}
