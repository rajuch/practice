package java8.thread;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureEx {

    private static class PiCalculator implements Callable<Double> {

        @Override
        public Double call() throws Exception {
            double currVal = 1.0;
            double nextVal = 0.0;
            double denominator = 1.0;
            for(int i = 0;
                Math.abs(nextVal - currVal) > 0.000000001d;
                denominator += 2.0, i++) {
                currVal = nextVal;
                if(i % 2 == 1) {
                    nextVal = currVal - (1 / denominator);
                } else {
                    nextVal = currVal + (1 / denominator);
                }
            }
            return currVal * 4;
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future result = executor.submit(new PiCalculator());
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main thread " + Thread.currentThread().getName());
        executor.shutdown();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("fds", "fdsds");
        map.remove("fds");
    }

}
