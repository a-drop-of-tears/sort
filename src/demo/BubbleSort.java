package demo;

import java.util.Random;

/**
 * @date 2018/10/6 11:08
 * @author Mr.Li
 */
public class BubbleSort {
    private void bubbleSort(int[] list) {
        int temp = 0;
        for (int i = 0; i < list.length; i++) {
            //从后向前依次比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = list.length - 1; j > i; j--) {
                //比较相邻的元素，如果前面的数大于后面的数，则交换
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                }
            }
            System.out.format("第 %d 趟:\t", i);
            printAll(list);
        }
    }

    //冒泡排序的优化
    private void bubbleSort_1(int[] list) {
        int temp = 0;
        //交换的标志
        boolean bChange = false;
        for (int i = 0; i < list.length - 1; i++) {
            bChange = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j - 1] > list[j]) {
                    temp = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = temp;
                    bChange = true;
                }
            }
            //如果标志为false,说明本轮遍历没有交换，已经是有序数列，可以结束排序
            if (!bChange) {
                break;
            }
            System.out.format("第 %d 趟:\t", i);
            printAll(list);
        }
    }

    private void printAll(int[] list) {
        for (int value : list) {
            System.out.print(value + "\t");
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
        BubbleSort bubbleSort = new BubbleSort();
        System.out.println("排序前：\t");
        bubbleSort.printAll(array);
        bubbleSort.bubbleSort(array);
        bubbleSort.bubbleSort_1(array);
        System.out.println("排序后：\t");
        bubbleSort.printAll(array);
    }
}
