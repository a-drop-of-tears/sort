package demo;

/**
 * @program: sort
 * @Date: 2018/10/6 17:34
 * @Author: Mr.Li
 * @Description:
 */
public class QuickSort {
    private int division(int[] list, int left, int right) {
        int base = list[left];
        while (left < right) {
            while (left < right && list[right] >= base) {
                right--;
            }
            list[left] = list[right];
            while (left < right && list[left] <= base) {
                left++;
            }
            list[right] = list[left];
        }
        list[left] = base;
        return left;
    }

    private void quickSort(int[] list, int left, int right) {

        // 左下标一定小于右下标，否则就越界了
        if (left < right) {
            // 对数组进行分割，取出下次分割的基准标号
            int base = division(list, left, right);

            System.out.format("base = %d:\t", list[base]);
            printPart(list, left, right);

            // 对“基准标号“左侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, left, base - 1);

            // 对“基准标号“右侧的一组数值进行递归的切割，以至于将这些数值完整的排序
            quickSort(list, base + 1, right);
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
        // 初始化一个序列
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };

        // 调用快速排序方法
        QuickSort quick = new QuickSort();
        System.out.print("排序前:\t\t");
        quick.printPart(array, 0, array.length - 1);
        quick.quickSort(array, 0, array.length - 1);
        System.out.print("排序后:\t\t");
        quick.printPart(array, 0, array.length - 1);
    }
}
