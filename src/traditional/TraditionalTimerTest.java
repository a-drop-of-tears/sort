package traditional;


import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * TraditionalTimerTest
 *
 * @author Mr Li
 * @date 2018/12/4
 */
public class TraditionalTimerTest {
    private static int count=0;
    private static int sep=1000;
    public static void main(String[] args) {
        /*new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing");
            }
        },2000,3000);*/
        class MyTimerTask extends TimerTask  {

            @Override
            public void run() {
                count=(count+1)%2;
                System.out.println("bombing1");
                new Timer().schedule(new MyTimerTask()
                        , 2000+2000*count);
            }
        }
        new Timer().schedule(new MyTimerTask() ,2000);
      /*  new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                count=(count+1)%2;
                System.out.println("bombing"+count);
                sep=(2000+2000*count);
            }
        },2000,sep);*/
        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
