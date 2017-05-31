package java8;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class A extends B implements Comparable {

    private int number;
    public A(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static void testMap() {
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("name", "raju");
        map.put("age", "27");
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()) {
            System.out.println(map.get(iter.next()));
            map.put("addr", "fdsa");
        }
    }

    @Override
    public void printName() {
        System.out.println(s);
    }

    public void printName(String name) {
        System.out.println(name);
    }

    private static void validate(String str) {
        String regEx = "([A-Za-z0-9_-])*";
        System.out.println(str.matches(regEx));
    }

    public static void main(String[] args) {
        A a = new A(1);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
