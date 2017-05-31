package java8.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Producer implements Runnable {
    ArrayBlockingQueue queue;

    public Producer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("executing..");
            System.out.println("Adding element i = " + i);
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Current state " + queue);
        }
    }
}

class Consumer implements Runnable {

    ArrayBlockingQueue queue;

    public Consumer(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("executing.. consumer.." + queue.size());
            try {
                System.out.println("Taking one element " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class ExecutorEx {

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(producer);
        executor.submit(consumer);
    }
}
