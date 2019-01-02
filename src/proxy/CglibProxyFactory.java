package proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CglibProxyFactory
 *
 * @author Mr Li
 * @date 2018/12/14
 */
public class CglibProxyFactory implements MethodInterceptor {
    /**
     * 维护目标对象
     */
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建代理对象
     * @return
     */
    public Object getProxyInstance(){
        //工具类
        Enhancer enhancer=new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("-----开始事务--------");
//        执行目标对象方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("-----结束事务--------");
        return returnValue;
    }
}
