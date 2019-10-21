package com.lhp.coder;

/**
 * @ClassName: Code7
 * @Description: 斐波那契数列
 * @Author: 李怀鹏
 * @Company: bjut
 * @Date： 2019/10/21 13:49
 * @Version： V1.0
 **/
public class Code7 {
    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-1)+Fibonacci(n-2);
    }
}
