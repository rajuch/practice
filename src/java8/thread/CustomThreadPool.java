package java8.thread;

import java.util.concurrent.LinkedBlockingQueue;

class ThreadPool {
    int noOfThreads = 5;
    LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue();
    PoolWorker[] workers;

    public ThreadPool(int noOfThreads) {
        this.noOfThreads = noOfThreads;
        workers = new PoolWorker[noOfThreads];
        for (int i = 0; i < noOfThreads; i++) {
            workers[i] = new PoolWorker();
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task = null;
            try {
                task = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
        }
    }
}

public class CustomThreadPool {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(5);
        pool.execute(() -> {
            System.out.println("run");
        });
    }
}
