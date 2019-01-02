package traditional;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchDemo
 *
 * @author Mr Li
 * @date 2018/12/10
 */

/**
 * countdownlatch 相当于倒计时器 减到0时放行
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch cdOrder=new CountDownLatch(1);
        final CountDownLatch cdAnswer=new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("线程"+Thread.currentThread().getName()+"正准备接受命令");
                        cdOrder.await();
                        System.out.println("线程"+Thread.currentThread().getName()+"已接受命令");
                        Thread.sleep((long)(Math.random()*10000));
                        System.out.println("线程"+Thread.currentThread().getName()+"回应命令处理结果");
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        cdAnswer.countDown();
                    }
                }
            });
        }
        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("线程" + Thread.currentThread().getName() + "即将发布命令");
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            cdOrder.countDown();
        }
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"已发送命令，正在等待结果");
            cdAnswer.await();
            System.out.println("线程"+Thread.currentThread().getName()+"已收到所有响应结果");
        }catch (Exception e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
