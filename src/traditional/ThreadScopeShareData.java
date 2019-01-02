package traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ThreadScopeShareData
 *
 * @author Mr Li
 * @date 2018/12/6
 */
public class ThreadScopeShareData {
    private static int data=0;
    private static Map<Thread,Integer> threadData=new HashMap<Thread, Integer>();
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    data=new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" has put data:"+data);
                    synchronized (threadData){
                        threadData.put(Thread.currentThread(),data);
                    }
                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){
            System.out.println("A from "+Thread.currentThread().getName()+" has put data:"+threadData.get(Thread.currentThread()));

        }
    }
    static class B{
        public void get(){
            System.out.println("B from "+Thread.currentThread().getName()+" has put data:"+threadData.get(Thread.currentThread()));
        }
    }
}
