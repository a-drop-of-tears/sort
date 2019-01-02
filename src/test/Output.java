package test;

/**
 * @program: sort
 * @Date: 2018/10/14 15:45
 * @Author: Mr.Li
 * @Description:
 */
public class Output implements Runnable {
    private Resource r;
    public Output(Resource r){
        this.r=r;
    }
    @Override
    public void run() {
        while (true){
            synchronized (r) {
                if(!r.flag){
                    try {
                        r.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name + "----" + r.sex);
                r.flag=false;
                r.notify();
            }
        }
    }
}
