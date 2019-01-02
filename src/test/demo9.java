package test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * @program: sort
 * @Date: 2018/10/13 10:47
 * @Author: Mr.Li
 * @Description:
 */
public class demo9 {
    public static void main(String[] args) throws IOException {
        readGbk();
        readUtf();

    }

    private static void writeUtf() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    private static void writeGbk() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test1.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "gb2312");
        outputStreamWriter.write("你好");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }
    private static void readGbk() throws IOException{
        FileInputStream fileInputStream=new FileInputStream("D:\\test1.txt");
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"gb2312");
        int len=0;
        char[] buffer=new char[1024];
        while ((len=inputStreamReader.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
        inputStreamReader.close();
    }
    private static void readUtf() throws IOException{
        FileInputStream fileInputStream=new FileInputStream("D:\\test.txt");
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream,"UTF-8");
        int len=0;
        char[] buffer=new char[1024];
        while ((len=inputStreamReader.read(buffer))!=-1){
            System.out.println(new String(buffer,0,len));
        }
    }
}
