package test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;


/**
 * @date 2018/10/14 13:44
 * @author  Mr.Li
 */
public class demo12 {
    public static void main(String[] args) {
        Tickets tickets=new Tickets();
        Thread t0=new Thread(tickets);
        Thread t1=new Thread(tickets);
        Thread t2=new Thread(tickets);
        t0.start();
        t1.start();
        t2.start();
    }
}
