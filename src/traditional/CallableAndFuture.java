package traditional;

import java.util.concurrent.*;

/**
 * CallableAndFuture
 *
 * @author Mr Li
 * @date 2018/12/7
 */
public class CallableAndFuture {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future=
        executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "hello";
            }
        });
        System.out.println("等待结果");
        try {
            System.out.println("结果"+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
