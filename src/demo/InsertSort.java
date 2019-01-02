package demo;


import java.awt.*;
import java.util.Random;

/**
 * @program: sort
 * @Date: 2018/10/6 11:49
 * @Author: Mr.Li
 * @Description:
 */
public class InsertSort {
    private void insertSort(int[] list) {
        System.out.format("i=%d:\t", 0);
        printPart(list, 0, 0);
        for (int i = 0; i < list.length; i++) {
            int j = 0;
            int temp = list[i];
            //取出第i个数
            for (j = i - 1; j >= 0 && temp < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = temp;
            System.out.format("i=%d:\t", i);
            printPart(list, 0, i);
        }
    }


    private void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int maxSize = 10;
        int[] array = new int[maxSize];
        Random random = new Random();
        for (int i = 0; i < maxSize; i++) {
            array[i] = random.nextInt(maxSize);
        }
        //调用冒泡排序的方法
        InsertSort insertSort=new InsertSort();
        System.out.println("排序前：\t");
        insertSort.printPart(array,0,array.length-1);
        insertSort.insertSort(array);
        System.out.println("排序后：\t");
        insertSort.printPart(array,0,array.length-1);
    }
}
