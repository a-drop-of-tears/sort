package traditional;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * CollectModifyException
 *
 * @author Mr Li
 * @date 2018/12/10
 */
public class CollectModifyException {
    public static void main(String[] args) {
        Collection users= new CopyOnWriteArrayList();
        users.add(new User("张三","20"));
        users.add(new User("李四","21"));
        users.add(new User("王五","22"));
        Iterator iterator=users.iterator();
        while (iterator.hasNext()){
            User user=(User) iterator.next();
            if("李四".equals(user.getName())){
                users.remove(user);
            }else {
                System.out.println(user);
            }
        }
    }
    public void test(){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
              1,
                1,
                10,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(1),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        threadPoolExecutor.execute(()->{
            try {
                //TODO执行方法
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                threadPoolExecutor.shutdown();
            }
        });
    }
}
