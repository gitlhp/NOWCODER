package com.lhp.coder;

/**
 * @ClassName: Code10
 * @Description:寻找第K大数
 * @Author: 李怀鹏
 * @Company: BJUT
 * @Date： 2019/10/21 14:18
 * @Version： V1.0
 **/
public class Code10 {
    //实现快速排序
    private static void quickSort(int[] arr, int start, int end) {
        if (start > end) {
            return;
        }
        int low = start;
        int high = end;
        int target = arr[start];//基准数
        //当low和high相遇时找到基准数坐在位置
        while (low < high) {//循环判断是否找到基准最终位置
            //从end开始，也就是从最右边开始找比基准数小的数
            while (arr[high] > target && low < high) {
                high--;//向左走
        }
            //找到则填坑
            if (low < high) {
                arr[low] = arr[high];
                low++;//开始从基准的右边第一个找比基准大的数
            }
            while (arr[low] < target && low < high) {
                low++;//左边向右走
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;//下一轮开始要从填坑的左边第一个开始向左找比基准小的继续
            }
        }
        arr[low] = target;//相遇时即
        quickSort(arr, 0, low - 1);
        quickSort(arr, low + 1, end);
    }

    //小小改进版
    public static void quickSort1(int[] arr, int start, int end, int k) {
        if (start > end) {
            return;
        }
        int low = start;
        int high = end;
        int target = arr[start];//基准数
        //当low和high相遇时找到基准数坐在位置
        while (low < high) {//循环判断是否找到基准最终位置
            //从end开始，也就是从最右边开始找比基准数小的数
            while (arr[high] > target && low < high) {
                high--;//向左走
            }
            //找到则填坑
            if (low < high) {
                arr[low] = arr[high];
                low++;//开始从基准的右边第一个找比基准大的数
            }
            while (arr[low] < target && low < high) {
                low++;//左边向右走
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;//下一轮开始要从填坑的左边第一个开始向左找比基准小的继续
            }
        }
        arr[low] = target;//相遇时即
        //第一轮结束 基准数左边是小 右边为大  判断k在右边还是左边 减少递归次数
        //第一种K刚好是第一轮结束基准的位置
        if (k - 1 == low) {
            return;
        }
        //第二种K小于基准位置
        if (k - 1 < low) {
            quickSort1(arr, 0, low - 1, k);
        }
        //第三种K大于基准位置
        if (k - 1 > low) {
            quickSort1(arr, low + 1, end, k);
        }
    }

    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort1(a, 0, n - 1, K);
        return a[K - 1];
    }

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort2(int[] array) {
        int len;
        if(array == null
                || (len = array.length) == 0
                || len == 1) {
            return ;
        }
        sort(array, 0, len - 1);
    }

    /**
     * 快排核心算法，递归实现
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right) {
        if(left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while(i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while(array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while(array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if(i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }
    public static void main(String[] args) {
        Code10 code10 = new Code10();
//        int[] arr = {7, 3, 3, 3, 4, 55, 23, 6, 2, 8, 9, 5};
        int[] arr1 = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
//        Code10.quickSort(arr, 0, arr.length - 1);
//        for (int i : arr1) {
//            System.out.println(i);
//        }
////        System.out.println("第K大数为："+code10.findKth(arr1, arr.length, 24));
//while (true){
//
//}
        Code10.quickSort2(arr1);
        for (int i : arr1) {
            System.out.println(i);
        }
    }
}