package test;

import java.io.File;
import java.io.IOException;

/**
 * @program: sort
 * @Date: 2018/10/12 11:16
 * @Author: Mr.Li
 * @Description:
 */
public class demo6 {
    public static void main(String[] args) {
        String path = File.pathSeparator;
        System.out.println(path);
        System.out.println(File.separator);
        File file=new File("D:\\");
        function(file);
    }

    private static void function(File file) {
        File[] fileList=file.listFiles();
        for (File file1:fileList){
         //   if (file1.isDirectory()){
            //    function(file1);
          //  }
           // else {
                System.out.println(file1);
            //}
        }



    }
}
