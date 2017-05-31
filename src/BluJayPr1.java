public class BluJayPr1 {

    private static int match(String str) {
        int maxLength = -1, start = 0;
        boolean found = false;
        int i = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (found) {
                    maxLength = Math.max(maxLength, i - start);
                    found = false;
                }
                start = i + 1;
            }
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                found = true;
            }
        }
        return found ? Math.max(maxLength, i - start) : maxLength;
    }

    public static void main(String[] args) {
        String str1 ="000BBB00B";
        System.out.println(match(str1));
//        Pattern pattern = Pattern.compile("^.*?([a-z]*[A-Z]+[a-z]*).*?$");
//        Matcher matcher = pattern.matcher(str1);
//        if (matcher.matches()) {
//            System.out.println("fdfas");
//        }
//        for (int i = 0 ; i < matcher.groupCount(); i++) {
//            System.out.println(matcher.group(i));
//        }
    }
}
