package carerrcup;

public class ConsecutiveIncreasingSubString {

    private static boolean isItSorted(String str) {
        char prevChar = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (prevChar > str.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    private static void printSubStrings(String str, int k) {
        int length = str.length();
        for (int i = 0; i <= length - k; i++) {
            for (int j = i+k; j <= length; j++) {
                if (isItSorted(str.substring(i, j))) {
                    System.out.println(str.substring(i, j));
                }
            }
        }
    }

    public static void main(String[] args) {
        printSubStrings("harshini", 2);
    }
}
