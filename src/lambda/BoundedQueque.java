package lambda;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueque<T> {
    private Object[] items;
    private int count, addIndex, removeIndex;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    BoundedQueque(int size) {
        items = new Object[size];
    }

    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            while (count == items.length)
                notFull.await();
            items[addIndex] = t;
            count++;
            if (++addIndex == items.length)
                addIndex = 0;
        } finally {
            lock.unlock();
        }

    }

    public T remove() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            T t = (T) items[removeIndex];
            count--;
            if(++removeIndex == items.length)
                removeIndex = 0;
            return t;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedQueque<Integer> queque = new BoundedQueque<>(3);
        queque.add(1);
        queque.add(2);
        queque.add(3);
        queque.remove();
        queque.add(4);
    }
}
