package traditional;

import java.util.concurrent.*;

/**
 * ThreadPoolTest
 *
 * @author Mr Li
 * @date 2018/12/7
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(3);固定线程数
//        ExecutorService executorService = Executors.newCachedThreadPool();不确定线程数
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        //单一线程池（如何实现线程死掉之后重新启动）


        for (int i = 0; i < 10; i++) {
            final int task=i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("thread name:"+Thread.currentThread().getName()+" loop of "+ j+"for task of "+task);
                    }
                }
            });
        }
        System.out.println("all of 10 tasks have committed");
        executorService.shutdown();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        //定时器线程池
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },10,TimeUnit.SECONDS);
    }
}
