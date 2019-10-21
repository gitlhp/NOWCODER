package com.lhp.coder;

import java.util.Stack;

/**
 * @ClassName: Code5
 * @Description:
 * @Author: 李怀鹏
 * @Company: JD-数字科技-生态中心-后台研发部
 * @Date： 2019/10/21 13:22
 * @Version： V1.0
 **/
public class Code5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        //stack1存放，2中转 2不空则先回到1
        while (!stack2.empty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();

    }

    public static void main(String[] args) {
        Code5 code5= new Code5();
        code5.push(1);
        code5.push(2);
        code5.push(3);
        System.out.println(code5.pop());
        System.out.println(code5.pop());
        System.out.println(code5.pop());
    }
}
