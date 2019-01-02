package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyFactory
 *
 * @author Mr Li
 * @date 2018/12/14
 */
public class ProxyFactory {
    /**
    维护一个目标对象
     */
    private final static String SAVE_METHOD="save";
    private Object target;

    public ProxyFactory(Object target) {
        this.target=target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (SAVE_METHOD.equals(method.getName())){
                            System.out.println("开始事务");
                            Object returnValue = method.invoke(target, args);
                            System.out.println("结束事务");
                            return returnValue;
                        }else{
                            System.out.println("开始事务2");
                            //执行目标对象的方法
                            Object returnValue = method.invoke(target, args);
                            System.out.println("结束事务2");
                            return returnValue;
                        }
                    }
                });
    }

}
