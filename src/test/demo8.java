package test;


import javax.xml.crypto.Data;
import java.io.*;

/**
 * @program: sort
 * @Date: 2018/10/13 10:00
 * @Author: Mr.Li
 * @Description:
 */
public class demo8 {
    public static void main(String[] args) {
        copy();
    }
    private static void fileWriteFunction(){
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter("D:\\test.txt");
            fileWriter.write("21313213213");
            fileWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件写入失败");
        }finally {
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("文件释放资源异常");
                }

            }
        }
    }
    private static void fileReadFunction(){
        FileReader fileReader=null;
        try {
            fileReader=new FileReader("D:test.txt");
            int len=0;
            char[] data=new char[1024];
            while ((len=fileReader.read(data))!=-1){
                System.out.println(len);
                System.out.print(new String(data,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件读取异常");

        }finally {
            try {
                fileReader.close();
            }catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException("文件资源释放异常");
            }
        }
    }
    private static void copy(){
        FileReader fileReader=null;
        FileWriter fileWriter=null;
        try {
            fileReader =new FileReader("D:\\test.txt");
            fileWriter=new FileWriter("D:\\test1.txt");
            char[] buffer=new char[1024];
            int len=0;
            while ((len=fileReader.read(buffer))!=-1){
                fileWriter.write(buffer,0,len);
                fileWriter.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件操作异常，重试");
        }finally {
            if (fileWriter!=null){
                try {
                    fileWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                    throw new RuntimeException("文件资源释放异常");
                }finally {
                    if (fileReader!=null){
                        try {
                            fileReader.close();
                        }catch (IOException e){
                            e.printStackTrace();
                            throw new RuntimeException("资源释放异常");
                        }

                    }
                }

            }

        }
    }
}
