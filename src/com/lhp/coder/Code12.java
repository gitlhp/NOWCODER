package com.lhp.coder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code12
 * @Description: 调整数组奇偶顺序 感觉这思路好low ...
 * @Author: lhp
 * @Date: 2019/10/24 22:24
 * @Version: V1.0
 **/
public class Code12 {
    public void reOrderArray(int [] array) {
        Queue<Integer> jishu = new LinkedList<>();
        Queue<Integer> oushu = new LinkedList<>();
        for (int i =0;i<array.length;i++){
            if (array[i]%2==0) {
                oushu.add(array[i]);
            }else {
                jishu.add(array[i]);
            }
        }
        bianhuan(array,jishu,oushu);
    }
    private void bianhuan(int[] arr,Queue<Integer> i,Queue<Integer> j){
        int len1 = i.size();
        for (int i1= 0;i1<arr.length;i1++){
            if (i1<len1){
                arr[i1]=i.poll();
            }else {
                arr[i1]=j.poll();
            }
        }
    }

    public static void main(String[] args) {
        Code12 code12 =new Code12();
        int[] array = {1,3,2,5,4,6,8,7};
        code12.reOrderArray(array);
        for (int i:array){
            System.out.println(i);
        }

    }
}
