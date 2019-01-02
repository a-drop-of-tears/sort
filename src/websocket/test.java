package websocket;

import org.java_websocket.client.WebSocketClient;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * test
 *
 * @author Mr Li
 * @date 2019/1/2
 */
public class test {
    public static void main(String[] args) {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(300);

            for (int i=0;i<200;i++){
                executorService.schedule(new Runnable() {
                    @Override
                    public void run() {
                        WebSocketDemo webSocketDemo=new WebSocketDemo();
                        WebSocketClient session = webSocketDemo.getSession();
                        System.out.println(session);
                        System.out.println(Thread.currentThread().getName());
                        while (true) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            session.send("{\"openID\":\"otYjSs-Ti6MoQCQAfqBb7rzZoGPg\", \"times\": 1 }");
                        }
//                        System.out.println("{\"openID\":\"otYjSs-Ti6MoQCQAfqBb7rzZoGPg\", \"times\": 1 }");
                    }
                },1, TimeUnit.SECONDS);
            }
            executorService.shutdown();
    }
}
