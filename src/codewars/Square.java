package codewars;

public class Square {

    private static boolean square(int number) {
        return Math.sqrt(number) % 1 == 0;
    }

    public static void main(String args[]) {
        System.out.println(Square.square(0));
    }
}
