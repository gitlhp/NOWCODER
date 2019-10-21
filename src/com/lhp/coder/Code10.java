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

    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n - 1);
        return a[K-1];
    }

    public static void main(String[] args) {
        Code10 code10 = new Code10();
        int[] arr = {1, 3, 3, 3, 4, 55, 23, 6, 2, 8, 9, 5};
        Code10.quickSort(arr,0,arr.length-1);
        for (int i :arr){
            System.out.println(i);
        }
        System.out.println("第K大数为："+code10.findKth(arr, arr.length, 6));

    }
}
