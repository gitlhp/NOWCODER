package com.lhp.coder;

import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName: Code19
 * @Description:数组中出现次数超过一半的数字
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/11/13 19:46
 * @Version： V1.0
 **/
public class Code19 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int len = array.length;
        if (array == null || len == 0) {
            return 0;
        }
        if (len == 1) {
            return array[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i : array) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i)>array.length/2){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Code19 code19 = new Code19();
        int[] arr = {};
        System.out.println(code19.MoreThanHalfNum_Solution(arr));
    }
}
