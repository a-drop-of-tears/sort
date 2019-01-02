package test;



import javax.xml.crypto.Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @program: sort
 * @Date: 2018/10/12 21:54
 * @Author: Mr.Li
 * @Description:
 */
public class demo7 {
    public static void main(String[] args) {
        currentDate();
    }
    private static void writeFile() {
        File file=new File("D:\\test.txt");
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file,true);
            byte[] data={97,98,99,100};
            fileOutputStream.write(data);
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("写入文件异常，重试");
        }finally {
            try {
                if (fileOutputStream!=null){
                    fileOutputStream.close();
                }
                System.out.println("文件写入完毕");
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("文件关闭异常，重试");
            }

        }


    }
    private static void readFile(){

        File file=new File("D:\\test.txt");
        File file1=new File("D:\\test1.txt");
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream=new FileOutputStream(file1);
            int len=0;
            byte[] data=new byte[1024];
            while ((len=fileInputStream.read(data))!=-1){
                fileOutputStream.write(data,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件异常，重试");
        }finally {
            try {
                if (fileOutputStream!=null) {
                    fileOutputStream.close();
                }
                if (fileInputStream!=null){
                    fileInputStream.close();
                }
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("文件关闭异常，重试");
            }

        }
    }
    private static void currentDate(){
        Date date=new Date();
        System.out.println(date.getTime());
    }
}
