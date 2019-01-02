package traditional;

/**
 * MultiThreadShareData
 *
 * @author Mr Li
 * @date 2018/12/7
 */
public class MultiThreadShareData {
    public static void main(String[] args) {
        final ShareData shareData=new ShareData();
        new Thread(new MyRunnabel1(shareData)).start();
        new Thread(new MyRunnabel2(shareData)).start();
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.decrement();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                shareData.increment();
            }
        }).start();*/
    }

}
class MyRunnabel1 implements Runnable{
    private ShareData data;
    public MyRunnabel1(ShareData data){
        this.data=data;
    }

    @Override
    public void run() {
        data.decrement();
    }
}

class MyRunnabel2 implements Runnable{
    private ShareData data;
    public MyRunnabel2(ShareData data){
        this.data=data;
    }

    @Override
    public void run() {
        data.increment();
    }
}
class ShareData{
/*    private Integer count=100;
    @Override
    public void run() {
        while (true){
            count--;
        }
    }*/

    private int j=0;
    public synchronized void increment(){
        j++;
    }

    public synchronized void decrement(){
        j--;
    }
}