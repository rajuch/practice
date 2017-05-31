package java8.thread;

public class ReentrantEx {

    private static final class Test implements Runnable {

        @Override
        public void run() {

        }
    }


    public static void main(String[] args) throws InterruptedException {
        Test thread1 = new Test();
        Test thread2 = new Test();
        Test thread3 = new Test();
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.join();
        t2.join();
    }
}
