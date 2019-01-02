package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @program: sort
 * @Date: 2018/10/11 15:38
 * @Author: Mr.Li
 * @Description:
 */
public class demo1 {
    public static void main(String[] args) {
        functionTwo();
    }
    private static void function(){
        List<Double> ld=new ArrayList<Double>();
        ld.add(1.1);
        ld.add(1.2);
        ld.add(1.3);
        ld.add(1.4);
        Double j=ld.remove(0);
        System.out.println(j);
        for (Double i:ld){
            System.out.println(i);
        }
    }
    private static void functionOne(){
        List<String> ls=new ArrayList<String>();
        ls.add("abc1");
        ls.add("abc2");
        ls.add("abc3");
        ls.add("abc4");
        Iterator<String> is=ls.iterator();
        //在迭代器遍历过程中修改了集合的长度会出现异常java.util.ConcurrentModificationException
        while (is.hasNext()){
            String s=is.next();
            if ("abc3".equals(s)){
                ls.set(2,"ABC3");
                System.out.println(ls.get(2));
            }
            System.out.println(s);
        }
    }
    private static void functionTwo(){
        HashSet<Person> hp=new HashSet<>();
        hp.add(new Person("a",11));
        hp.add(new Person("b",10));
        hp.add(new Person("b",10));
        hp.add(new Person("d",13));
        for (Person p:hp){
            System.out.println(p);
        }
    }

}
