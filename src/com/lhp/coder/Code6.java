package com.lhp.coder;

/**
 * @ClassName: Code6
 * @Description: 旋转数组中的最小数字
 * @Author: 李怀鹏
 * @Company: bjut
 * @Date： 2019/10/21 13:30
 * @Version： V1.0
 **/
public class Code6 {
    public int minNumberInRotateArray(int[] array) {
        //0,1卫语句除特殊
        if (array.length==0) {
            return 0;
        }
        if (array.length==1){
            return array[0];
        }
        //3,4,5,5,1,2>>1,2,3,4,5,5 当后者小于前者时则就是最小 情况一 数组默认不递减
        for (int i=0;i<array.length-1;i++){
            if (array[i]<=array[i+1]){
                continue;
            }
            int j= i+1;
            return array[j];
        }
        return array[0];
    }

    public static void main(String[] args) {
        Code6 code6=new Code6();
        //test
        int[] array= {3,4,5,5,1,2};
        int[] array1= {3,3,4,5,5,1,2};
        int[] array2= {1,1,1};
        System.out.println(code6.minNumberInRotateArray(array));

    }
}
