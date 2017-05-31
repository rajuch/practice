package java8.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadSeq {
    ReentrantLock lock1 = new ReentrantLock();
    //Condition helloDone = lock1.newCondition();
    static boolean helloDone = false;
    static Object lock = new Object();

    static class Hello implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                synchronized (lock) {
                    while (helloDone) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("Hello ");
                    i++;
                    helloDone = true;
                    lock.notify();
                }

            }
        }
    }

    static class World implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i < 5) {
                synchronized (lock) {
                    while (!helloDone) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("World");
                    i++;
                    helloDone = false;
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Hello());
        Thread t2 = new Thread(new World());
        t1.start();
        t2.start();
    }
}