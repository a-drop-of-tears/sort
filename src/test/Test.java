package test;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Mr.Li
 * @date 2018/10/10 20:56
 */
public class Test {
    public static void main(String[] args) {
        function_4();
    }

    private static void function() {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toBinaryString(20));
        System.out.println(Integer.toOctalString(20));
        System.out.println(Integer.toHexString(20));
        //自动装箱 基本数据类型直接变成包装类
        Integer in = 1;
        //本质上 Integer in= new Integer(1)
        System.out.println(in.toString());
        //自动拆箱 包装类型直接变成基本数据类型
        System.out.println(in + 1);
        //本质上 in.intValue()+1
        //自动拆箱和自动装箱的好处，基本数据类型和引用类型直接运算。弊端：null 会出现空指针异常

    }

    private static void function_1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        System.out.println(i.equals(j));

        Integer a = 500;
        Integer b = 500;
        System.out.println(a == b);
        System.out.println(a.equals(b));

        System.out.println("===========");

        Integer aa = 127;
        Integer bb = 127;
        System.out.println(aa == bb);
        System.out.println(aa.equals(bb));

        System.out.println("===========");
        System.out.println(System.currentTimeMillis());

        //System.out.println(System.getProperties());
        int[] src = {11, 22, 33, 44, 55, 66};
        int[] desc = {77, 88, 99, 0};
        System.arraycopy(src, 0, desc, 0, 2);
        for (int h : desc) {
            System.out.println(h);
        }
        System.out.println(Math.ceil(-2.3));
        System.out.println(Math.pow(3, 2));
        System.out.println(Math.floor(-2.3));
        System.out.println(Math.random() * 100);
        System.out.println(Math.round(2.41322));

    }

    private static void function_2() {
        BigInteger b1 = new BigInteger("1233333333");
        BigInteger b2 = new BigInteger("4565456546545454646464646465454654");
        BigInteger bigInteger = b1.add(b2);
        BigInteger bigInteger1 = b1.subtract(b2);
        BigInteger bigInteger2 = b1.multiply(b2);
        BigInteger bigInteger3 = b1.divide(b2);
        System.out.println(bigInteger);
        System.out.println(bigInteger1);
        System.out.println(bigInteger2);
        System.out.println(bigInteger3);
    }

    private static void function_3() {
        BigDecimal b1 = new BigDecimal("1.015");
        BigDecimal b2 = new BigDecimal("100");
        //BigDecimal bigDecimal=b1.add(b2);
//        BigDecimal bigDecimal=b1.subtract(b2);
        BigDecimal bigDecimal = b1.multiply(b2);
        System.out.println(bigDecimal);
    }
    private static void function_4(){
        Collection<String> coll=new ArrayList<String>();
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");
        Iterator<String> i=coll.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }



    }

}
