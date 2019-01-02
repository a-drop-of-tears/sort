package websocket;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * WebSocketDemo
 *
 * @author Mr Li
 * @date 2019/1/2
 */
public class WebSocketDemo {
    private WebSocketClient client;

    public WebSocketClient getSession() {
        try {
            client = new WebSocketClient(new URI("ws://132.232.63.248:10080/lottery/websocket_phone"), new Draft_6455()) {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {
                    System.out.println("握手成功");
                }

                @Override
                public void onMessage(String msg) {
                    System.out.println("收到消息=====" + msg);
                    if (msg.equals("over")) {
                        client.close();
                    }

                }

                @Override
                public void onClose(int i, String s, boolean b) {
                    System.out.println("连接已关闭");
                }

                @Override
                public void onError(Exception e) {
                    e.printStackTrace();
                    System.out.println("发生错误已关闭");
                }
            };
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        client.connect();
//        logger.info(client.getDraft());
        while (!client.getReadyState().equals(WebSocket.READYSTATE.OPEN)) {
//            logger.info("正在连接...");
            System.out.println("正在连接");
        }
        return client;
    }


    //连接成功,发送信息
//        Thread threads[]=new Thread[200];
//        Timer timer=new Timer();
//        for(int i=0;i<200;i++){
//            threads[i]=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    client.send("{\"openID\":\"otYjSs-Ti6MoQCQAfqBb7rzZoGPg\", \"times\": 1 }");
//                }
//            });
//            threads[i].start();
//
//        }


}
