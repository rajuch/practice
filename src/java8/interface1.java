package java8;

public interface interface1 {

    default void printName() {
        System.out.println("interface1");
    }

    default void test() {
        System.out.println("testing default diamond");
    }
}
