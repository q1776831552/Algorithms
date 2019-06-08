package lambda;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字： " + mainGroup.getName());
        new MyThread("主线程组的线程").start();
        ThreadGroup tg = new ThreadGroup("新线程组");
        new MyThread(tg, "tg组的线程甲").start();
    }
}

