package traditional;

/**
 * ConditionCommunication
 *
 * @author Mr Li
 * @date 2018/12/8
 */
public class ConditionCommunication {
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
        private boolean bShouldSub=true;
        public synchronized void sub(int i){
            //while防止伪唤醒
            while (!bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 10; j++) {
                System.out.println("sub thread sequece of " + j + ",loop of" + i);
            }
            bShouldSub=false;
            this.notify();
        }
        public synchronized void main(int i){
            while (bShouldSub){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int j = 1; j <= 100; j++) {
                System.out.println("main thread sequece of " + j + ",loop of" + i);
            }
            bShouldSub=true;
            this.notify();
        }
    }
}
