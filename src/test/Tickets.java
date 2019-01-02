package test;

/**
 * @program: sort
 * @Date: 2018/10/14 13:42
 * @Author: Mr.Li
 * @Description:
 */
public class Tickets implements Runnable {
    private static int tickets=100;
    @Override
    public void run(){
        while (true){
                boolean b=payTickets();
                if(true==b){
                    break;
                }
            }
    }
    private static synchronized boolean payTickets(){
        if (tickets <= 0) {
           return true;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "票数:" + tickets--);
        return false;
    }

}
