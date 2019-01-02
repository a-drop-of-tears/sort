package traditional;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * QuenceCache
 *
 * @author Mr Li
 * @date 2018/12/8
 */
public class QuenceCache {
    public static void main(String[] args) {
        PUTGET putget=new PUTGET();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(putget.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                putget.put(new Random().nextInt(10));
            }
        }).start();
    }
    static class PUTGET{
        final Lock lock=new ReentrantLock();
        final Condition notEmpty=lock.newCondition();
        final Condition notFull=lock.newCondition();
        final Object[] items = new Object[10];
        int putptr, takeptr, count;


        private Object get(){
            lock.lock();
            try {
                while (count == 0)
                {
                    try {
                        notEmpty.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Object x = items[takeptr];
                if (++takeptr == items.length)
                {
                    takeptr = 0;
                }
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }


        }
        private void put(Object x){
            lock.lock();
            try {
                while (count == items.length)
                {
                    try {
                        notFull.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                items[putptr] = x;
                if (++putptr == items.length)
                {
                    putptr = 0;
                }
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }

        }
    }
}
