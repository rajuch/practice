package java8;

enum abc {
    TEST_ABC,
    TEST_XYZ
}

public class TestEnum {
    public static void main(String[] args) {
        System.out.println(abc.valueOf("TEST_ABC"));

    }
}
