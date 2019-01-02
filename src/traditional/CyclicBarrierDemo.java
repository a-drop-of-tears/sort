package traditional;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * CyclicBarrierDemo
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        final Lock lock=new ReentrantLock();
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到达集合点1，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
                                (cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));
                        cyclicBarrier.await();
                        Thread.sleep((long) (Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到达集合点2，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
                                (cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));
                        cyclicBarrier.await();
                        Thread.sleep((long)(1000));
                        lock.lock();
                        System.out.println("线程"+Thread.currentThread().getName()+
                                "即将到达集合点3，当前已有"+(cyclicBarrier.getNumberWaiting()+1)+"个已经到达，"+
                                (cyclicBarrier.getNumberWaiting()==2?"都到齐了，继续走啊":"正在等候"));
                        lock.unlock();
                        cyclicBarrier.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        executorService.shutdown();
    }
}
