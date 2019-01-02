package test;

import java.io.*;

/**
 * @program: sort
 * @Date: 2018/10/13 12:26
 * @Author: Mr.Li
 * @Description:
 */
public class demo10 {
    public static void main(String[] args) throws IOException{
        //bufferCopy(new File("D:\\test.txt"),new File("D:test1.txt"));
        bufferCopyFunction(new File("D:\\test.txt"),new File("D:test1.txt"));
    }
    private static void bufferCopy(File src,File desc) throws IOException {
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(desc));
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(src));
        int len=0;
        byte[] buffer=new byte[1024];
        while ((len=bufferedInputStream.read(buffer))!=-1){
            bufferedOutputStream.write(buffer,0,len);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
    private static void bufferCopyFunction(File src,File desc) throws IOException{
        BufferedReader bufferedReader=new
                BufferedReader(new InputStreamReader(new FileInputStream(src),"GBK"));
        BufferedWriter bufferedWriter=new
                BufferedWriter(new OutputStreamWriter(new FileOutputStream(desc),"GBK"));
        int len=0;
        char[] buffer=new char[1024];
        while ((len=bufferedReader.read(buffer))!=-1){
            bufferedWriter.write(buffer,0,len);
        }
        bufferedWriter.close();
        bufferedReader.close();
    }
}
