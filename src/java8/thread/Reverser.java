package java8.thread;

public class Reverser implements Runnable {

    private StringBuffer sb;

    public Reverser(StringBuffer sb) {
        this.sb = sb;
    }

    private synchronized void reverse() {
        sb.reverse();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("in reverse" + sb + Thread.currentThread().getName());
    }

    private void print() {
        System.out.println(sb + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        reverse();
        print();
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer("abc");
        Reverser r = new Reverser(sb);
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
    }
}
