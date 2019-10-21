package com.lhp.coder;

/**
 * @ClassName: Code8
 * @Description: 跳台阶
 * @Author: 李怀鹏
 * @Company: bjut
 * @Date： 2019/10/21 13:55
 * @Version： V1.0
 **/
public class Code8 {
    public int JumpFloor(int target) {
        //沿用菲波那切数列思想 但是递归耗时
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        //台阶大于2时
        int one = 1;
        int two = 2;
        int sum = 0;
        for (int i = 2; i < target; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Code8 code8=new Code8();
        System.out.println(code8.JumpFloor(4));
    }
}
