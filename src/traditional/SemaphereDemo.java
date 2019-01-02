package traditional;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * SemaphereDemo
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class SemaphereDemo {
    private static Semaphore semaphore=new Semaphore(3);
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
          Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"进入，当前已有"+(3-semaphore.availablePermits())+"并发");
                    try {
                        Thread.sleep((long) Math.random()*10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                    semaphore.release();
                    System.out.println("线程"+Thread.currentThread().getName()+"已离开，当前已有"+(3-semaphore.availablePermits())+"并发");
                }
            };
          executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
