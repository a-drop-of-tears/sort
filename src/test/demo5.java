package test;

import java.util.*;

/**
 * @program: sort
 * @Date: 2018/10/12 9:19
 * @Author: Mr.Li
 * @Description:
 */
public class demo5 {
    public static void main(String[] args) {
        HashMap<String,String> javase=new HashMap<>();
        HashMap<String,String> javaee=new HashMap<>();
        javase.put("001","张三");
        javase.put("002","李四");

        javaee.put("001","王五");
        javaee.put("002","赵六");

        HashMap<String,HashMap<String,String>> czbk=new HashMap<>();
        czbk.put("基础班",javase);
        czbk.put("就业班",javaee);
        keySet(czbk);
        entrySet(czbk);

    }
    private static void keySet(HashMap<String,HashMap<String,String>> czbk){
        Set<String> classKeySet=czbk.keySet();
        Iterator<String> iterator=classKeySet.iterator();
        while (iterator.hasNext()){
            String classKey=iterator.next();
            HashMap<String,String> classRoom=czbk.get(classKey);
            Set<String> keySet=classRoom.keySet();
            Iterator<String> is=keySet.iterator();
            while (is.hasNext()){
                String key=is.next();
                System.out.println("班级:"+classKey+"\t"+"学号:"+key+"\t"+"姓名:"+classRoom.get(key));
            }
        }
    }
    private static void entrySet(HashMap<String,HashMap<String,String>> czbk){
        Set<Map.Entry<String,HashMap<String,String>>> classNameEntry=czbk.entrySet();
        Iterator<Map.Entry<String,HashMap<String,String>>> classNameIt=classNameEntry.iterator();
        while (classNameIt.hasNext()){
            Map.Entry<String,HashMap<String,String>> classNameMap=classNameIt.next();
            String className=classNameMap.getKey();
            HashMap<String,String> classMap=classNameMap.getValue();
            Set<Map.Entry<String,String>> classSet=classMap.entrySet();
            Iterator<Map.Entry<String,String>> im=classSet.iterator();
            while (im.hasNext()){
                Map.Entry<String,String> classRoom=im.next();
                String number=classRoom.getKey();
                String name=classRoom.getValue();
                System.out.println("班级:"+className+"\t"+"学号:"+number+"\t"+"名字:"+name);
            }


        }
    }




}
