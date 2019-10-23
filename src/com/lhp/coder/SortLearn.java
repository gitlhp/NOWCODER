package com.lhp.coder;

import java.util.Arrays;

/**
 * @ClassName: SortLearn
 * @Description
 * @Author: lhp
 * @Date: 2019/10/22 22:34
 * @Version: V1.0
 **/
public class SortLearn {
    //内部排序

    /**
     * 冒泡排序
     */
    public void maopao(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            System.out.println(array[n - i - 1]);
        }
    }

    /**
     * 快速排序
     */
    public void kuaisu(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low > high) {
            return;
        }
        int index = getIndex(arr, low, high);
        //进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
        kuaisu(arr, 0, index - 1);
        kuaisu(arr, index + 1, high);
    }

    /**
     * 快速排序求递归参数，每一次确定的地址
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private int getIndex(int[] arr, int low, int high) {
        //基准数据
        int temp = arr[low];//第一个数
        while (low < high) {
            //当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= temp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= temp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];
            // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
            // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        }
        arr[low] = temp;
        return low;//返回temp的正确地址
    }

    /**
     * 交换方法
     */
    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * 直接插入算法
     *
     * @param arr
     */
    public void zhijie(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[i]) {
                arr[j + 1] = arr[j] + arr[j + 1];      //只要大就交换操作
                arr[j] = arr[j + 1] - arr[j];
                arr[j + 1] = arr[j + 1] - arr[j];
            }
        }
        System.out.println("Sorting:  " + Arrays.toString(arr));
    }

    public static void main(String[] lhp) {
        SortLearn sortLearn = new SortLearn();
        //冒泡排序
        int[] arr = {49, 38, 65, 97, 23, 22, 76, 1, 5, 8, 2, 0, -1, 22};
//        sortLearn.maopao(arr);
        sortLearn.kuaisu(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
//        sortLearn.zhijie(arr);
    }
}
