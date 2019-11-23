package com.lhp.coder;

/**
 * @ClassName: Code20
 * @Description:包含min函数的栈：定义栈的数据结构，
 * @请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * @Author: lhp
 * @Date: 2019/11/7 22:11
 * @Version: V1.0
 **/
import java.util.Iterator;
import java.util.Stack;
public class Code20{
    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        //栈顶
        stack.pop();
    }

    public int top() {
        //不删除栈顶
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min<tmp){
                min = tmp;
            }
        }
        return min;
    }
}
