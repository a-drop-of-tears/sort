package traditional;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExchangerDemo
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Exchanger<String> exchanger=new Exchanger<>();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data1="zxx";
                    System.out.println("线程"+Thread.currentThread().getName()+"正准备把数据"+data1+"换出去");
                    Thread.sleep((long)(Math.random()*10000));
                    String data2=exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为"+data2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String data1="lhm";
                    System.out.println("线程"+Thread.currentThread().getName()+"正在把数据"+data1+"换出去");
                    Thread.sleep((long)(Math.random()*10000));
                    String data2=exchanger.exchange(data1);
                    System.out.println("线程"+Thread.currentThread().getName()+"换回的数据为"+data2);

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }
}
