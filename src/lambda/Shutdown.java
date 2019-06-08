package lambda;

import java.util.concurrent.TimeUnit;

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runner(), "Thread1");
        thread1.start();
        TimeUnit.SECONDS.sleep(1);
        thread1.interrupt();
        Runner two = new Runner();
        Thread thread2 = new Thread(two, "Thread2");
        thread2.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();
    }


    private static class Runner implements Runnable{
        private long i;
        private volatile boolean on = true;
        @Override
        public void run() {
            while (on && !Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("Count i = " + i);
        }

        public void cancel() {
            on = false;
        }
    }
}
