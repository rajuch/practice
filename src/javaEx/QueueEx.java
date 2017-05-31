package javaEx;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueueEx {

    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                String str1 = (String)o1;
                String str2 = (String)o2;
                return str2.compareTo(str1);
            }
        });
        q.add("harshini");
        q.add("raju");
        q.add("raju");
        q.add("haha");
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }

        PriorityQueue<String> q1 = new PriorityQueue<>();
    }
}
