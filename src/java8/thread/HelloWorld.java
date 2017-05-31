package java8.thread;

import java8.A;

public class HelloWorld implements Runnable {

    Counter counter = new Counter();
    static class Counter {
        private  int c;
        void increment() {
            c++;
        }
        int value() {
            return c;
        }
        void decrement() {
            c--;
        }
    }

    public void run() {
        if (Thread.currentThread().getName().equals("Thread1")) {
            System.out.println("Hello");
        } else {
            System.out.println("World");
        }
        for (int i=0; i<5; i++) {
            counter.increment();
            counter.decrement();
            System.out.println(Thread.currentThread().getName() + " " + counter.value());
        }
    }

    public static void main(String[] args) {
        HelloWorld obj = new HelloWorld();
        //Thread t3 = new Thread(new A(1));
        Thread t1 = new Thread(obj, "Thread1");
        t1.start();
        Thread t2 = new Thread(obj, "Thread2");
        t2.start();


    }
}
