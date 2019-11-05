package com.lhp.coder;

import java.util.ArrayList;

/**
 * @ClassName: Code16
 * @Description:寻找最小的k个数
 * @Author: lhp
 * @Date: 2019/11/5 23:27
 * @Version: V1.0
 **/
public class Code16 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (input == null) {
            return arrayList;
        }
        if (k < 0 || k > input.length) {
            return arrayList;
        }
        kuaisu(input, 0, input.length - 1);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }
        return arrayList;

    }

    private void kuaisu(int[] ints, int low, int high) {
        if (ints == null || ints.length == 0) {
            return;
        }
        if (low > high) {
            return;
        }
        int index = getIndex(ints, low, high);
        kuaisu(ints, 0, index - 1);
        kuaisu(ints, index + 1, high);

    }

    private int getIndex(int[] ints, int low, int high) {
        //基准数据
        int temp = ints[low];
        while (low < high) {
            while (ints[high] >= temp && low < high) {
                high--;
            }
            ints[low] = ints[high];
            while (low < high && ints[low] <= temp) {
                low++;
            }
            ints[high] = ints[low];
        }
        ints[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        Code16 code16 = new Code16();
        int[] arr = {1,6,3,884022, 252932};
        ArrayList<Integer> arrayList = code16.GetLeastNumbers_Solution(arr, 8);
        for (int i : arrayList) {
            System.out.println(i);
        }
    }
}
