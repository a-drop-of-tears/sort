package test;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * @program: sort
 * @Date: 2018/10/13 15:46
 * @Author: Mr.Li
 * @Description:
 */
public class demo11 {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
        //writeProperties();
        //readProperties();
        //writeObjectProperties();
        readObjectProperties();
    }
    private static void writeProperties() throws IOException {
        Properties properties=new Properties();
        properties.setProperty("name","张三");
        properties.setProperty("number","李四");
        FileOutputStream fileOutputStream=new FileOutputStream(new File("D:\\pro.properties"));
        //FileWriter fileWriter=new FileWriter(new File("D:\\pro.properties"));
        //properties.store(fileWriter,"");
        properties.store(fileOutputStream,"");
        Set<String> keys=properties.stringPropertyNames();
        for (String key:keys){
            System.out.println(key+"-->"+properties.getProperty(key));
        }
    }
    private static void readProperties() throws IOException {
        Properties properties=new Properties();
        //FileReader fileReader=new FileReader(new File("D:\\pro.properties"));
        FileInputStream fileInputStream=new FileInputStream(new File("D:\\pro.properties"));
        //properties.load(fileReader);
        properties.load(fileInputStream);
        Set<String> keys=properties.stringPropertyNames();
        Iterator<String> is=keys.iterator();
        while (is.hasNext()){
            String key=is.next();
            String value=properties.getProperty(key);
            System.out.println(key+"..."+value);
        }

    }
    //对象的序列化
    private static void readObjectProperties() throws IOException,ClassNotFoundException{
        FileInputStream fileInputStream=new FileInputStream(new File("D:\\person.txt"));
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Person p=(Person) objectInputStream.readObject();
        System.out.println(p);
    }
    private static void writeObjectProperties() throws IOException{
        Person person=new Person("张三",20);
        FileOutputStream fileOutputStream=new FileOutputStream(new File("D:person.txt"));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.close();
    }


}
