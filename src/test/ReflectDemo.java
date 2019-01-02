package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @program: sort
 * @Date: 2018/10/15 19:28
 * @Author: Mr.Li
 * @Description:
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Class c=Class.forName("test.Person");
        Field f=c.getField("p");
        Method m=c.getMethod("setName", String.class);
        Object obj=c.newInstance();
        f.set(obj,"张三");
        m.invoke(obj,"李四");
        //Field name=c.getDeclaredField("name");
        System.out.println(obj);
    }
}
