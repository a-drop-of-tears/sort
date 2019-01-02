package traditional;

/**
 * TraditionalThreadSynchronized
 *
 * @author Mr Li
 * @date 2018/12/6
 */
public class TraditionalThreadSynchronized {
    public static void main(String[] args) {
       new TraditionalThreadSynchronized().init();
    }
    private void init(){
        OutPuter outPuter=new OutPuter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output("zhangxiaoxiang");
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    outPuter.output1("lihuoming");
                }
            }
        }).start();
    }
    static class OutPuter{
        public void output(String name){
            int len=name.length();
            synchronized(OutPuter.class){
                for (int i = 0; i < len; i++) {
                    System.out.print(name.charAt(i));
                }
                System.out.println();
            }
        }
        public static synchronized void output1(String name){
            int len=name.length();
            for (int i = 0; i < len; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.println();
        }
    }
}
