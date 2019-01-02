package traditional;

import sun.font.FontRunIterator;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * BlockingQueueCommunication
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class BlockingQueueCommunication {
    public static void main(String[] args) {
        Business  business=new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 50; i++) {
                    business.sub(i);
                }
            }
        }).start();

        for (int i = 1; i <= 50; i++) {
            business.main(i);
        }
    }

    static class Business{
        private boolean bShouldSub=true;
        final BlockingQueue queue1=new ArrayBlockingQueue(1);
        final BlockingQueue queue2=new ArrayBlockingQueue(1);
        {
            try {
                queue1.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public  void sub(int i){
            try {
                queue2.take();
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequece of " + j + ",loop of" + i);
                }
                queue1.put(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        public  void main(int i){
            try {
                queue1.take();
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequece of " + j + ",loop of" + i);
                }
                queue2.put(1);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
