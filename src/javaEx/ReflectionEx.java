package javaEx;

import java.util.Date;

class Test1 {
    private int a;
    private int b;

    private Test1() {
    }

    public String toString() {
        return "" + a + " " + b;
    }
}

public class ReflectionEx {

    public static void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        });
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
//        Test1 obj = new Test1();
//        Field a = obj.getClass().getDeclaredField("a");
//
//        a.setAccessible(true);
//        a.setInt(obj, 10);
//        System.out.println(obj.toString());
        addShutdownHook();
    }
}
