package zhenti;

import lambda.Interrupted;

import static java.lang.Thread.interrupted;

public class Test2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TestThread());
        thread1.start();
        System.out.println(2);
        thread1.interrupt();
    }


}

class TestThread implements Runnable {

    @Override
    public void run() {
        while(!interrupted()) {
            System.out.print(1);
        }
    }
}
