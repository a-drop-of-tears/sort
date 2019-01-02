package traditional;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQuenceDemo
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class BlockingQuenceDemo {
    public static void main(String[] args) {
        final BlockingQueue queue=new ArrayBlockingQueue(3);
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            Thread.sleep((long)(Math.random()*10000));
                            System.out.println(Thread.currentThread().getName()+"准备放数据");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName()+"已经放了数据，队列目前有"+queue.size()+"个数据");
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(true) {
                        try {
                            Thread.sleep(100);
                            System.out.println(Thread.currentThread().getName() + "准备取数据");
                            queue.take();
                            System.out.println(Thread.currentThread().getName() + "已经取走数据，队列目前有" + queue.size() + "个数据");

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();
        }

            
    }
}
