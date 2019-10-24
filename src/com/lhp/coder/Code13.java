package com.lhp.coder;

import java.util.Stack;

/**
 * @ClassName: Code13
 * @Description: 链表倒数第K个节点
 * @Author: lhp
 * @Date: 2019/10/24 22:50
 * @Version: V1.0
 **/
public class Code13 {
    //方法一 时间和空间复杂度高 但是思路简单
    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode node = null;
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        //全部入栈 0(n)
        int k1 = 0;
        while (head != null) {
            stack.push(head);
            head = head.next;
            k1++;
        }
        if (k > k1) {
            return null;
        } else {
            for (int i = 0; i < k; i++) {
                node = stack.pop();
            }
        }
        return node;
    }

    //方法二 双指针法
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        int count = 0;
        while (count < k && p2 != null) {
            p2 = p2.next;
            count++;
        }
        //到头跳出循环但是count<k说明 k大于size();
        if (count < k) {
            return null;
        }
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }


    public static void main(String[] args) {
        Code13 code13 = new Code13();
        ListNode node = new ListNode(1);
        ListNode temp = node;
        for (int i = 2; i <= 6; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node1;
        }
        System.out.println(code13.FindKthToTail(temp, 8).val);
    }
}
