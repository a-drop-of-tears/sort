package traditional;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * ThreadLocalTest
 *
 * @author Mr Li
 * @date 2018/12/6
 */
public class ThreadLocalTest {
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal<>();
    private static ThreadLocal<MyThreadScopeData> myThreadScopeDataThreadLocal
            =new ThreadLocal<>();
     public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int data=new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+" has put data:"+data);
                    MyThreadScopeData instance = MyThreadScopeData.getInstance();
                    instance.setName("zhangsan"+data);

                    new A().get();
                    new B().get();
                }
            }).start();
        }
    }

    static class A{
        public void get(){
            System.out.println("A from "+Thread.currentThread().getName()+" has put data:"+threadLocal.get());

        }
    }
    static class B{
        public void get(){
            System.out.println("B from "+Thread.currentThread().getName()+" has put data:"+threadLocal.get());
        }
    }

}
class MyThreadScopeData{
    //private static MyThreadScopeData myThreadScopeData=null;
    private MyThreadScopeData(){ }
    public static /*synchronized*/ MyThreadScopeData getInstance(){
        MyThreadScopeData myThreadScopeData=map.get();
        if (myThreadScopeData==null){
            myThreadScopeData=new MyThreadScopeData();
            map.set(myThreadScopeData);
        }
        return myThreadScopeData;
    }
    private static ThreadLocal<MyThreadScopeData> map=new ThreadLocal<MyThreadScopeData>();

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
