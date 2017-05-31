package java8;

interface Test {

    default void printIt() {
        System.out.println("printing");
    }

    static void print() {
        System.out.println("printed");
    }

    default void test() {
        System.out.println("testing");
    }
}

interface Test1  {
    void test();
    void test1();
    default void printIt() {
        System.out.println("printing");
    }
}


public class InterfaceEx implements Test1, Test {



    public static void main(String[] args) {
        Test1 test2 = new Test1() {
            public void test() {

            }

            public void test1() {

            }
        };

    }

    @Override
    public void test() {

    }

    @Override
    public void test1() {

    }

    @Override
    public void printIt() {

    }
}
