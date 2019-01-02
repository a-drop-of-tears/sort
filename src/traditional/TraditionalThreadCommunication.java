package traditional;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TraditionalThreadCommunication
 *
 * @author Mr Li
 * @date 2018/12/6
 */
public class TraditionalThreadCommunication {
    public static void main(String[] args) {
       new TraditionalThreadCommunication().init();
    }
    public void init(){
        Business business=new Business();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=1;i<=50;i++) {
                    business.sub(i);
                }
            }
        }).start();
        for (int i=1;i<=50;i++) {
            business.main(i);
        }
    }
    class Business{
        private Lock lock=new ReentrantLock();
        private Condition condition=lock.newCondition();
        private boolean bShouldSub=true;
        public  void sub(int i){
            lock.lock();
            try {
                //while防止伪唤醒
                while (!bShouldSub){
                    try {
                        //this.wait();
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 10; j++) {
                    System.out.println("sub thread sequece of " + j + ",loop of" + i);
                }
                bShouldSub=false;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
        public  void main(int i){
            lock.lock();
            try {
                while (bShouldSub){
                    try {
                        //this.wait();
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                for (int j = 1; j <= 100; j++) {
                    System.out.println("main thread sequece of " + j + ",loop of" + i);
                }
                bShouldSub=true;
                //this.notify();
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
