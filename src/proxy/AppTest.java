package proxy;

/**
 * AppTest
 *  测试类
 * @author Mr Li
 * @date 2018/12/14
 */
public class AppTest {
    public static void main(String[] args) {
/*        //目标对象
        UserDaoImpl target=new UserDaoImpl();
        //代理对象，把目标对象传输给代理对象，建立代理关系
        UserDaoProxy proxy=new UserDaoProxy(target);
//        执行的是代理方法
        proxy.save();*/

        UserDaoImpl target=new UserDaoImpl();
        IUserDao proxy=(IUserDao)new CglibProxyFactory(target).getProxyInstance();
        proxy.save();
        proxy.update();
    }

}
