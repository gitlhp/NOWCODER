package com.lhp.coder;

import java.util.HashSet;
import java.util.Set;

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
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }
        int len1 = set.size();
        if (len1 > len / 2 + 1) {
            return 0;
        }

        return 222;
    }
}
