package com.lhp.coder;

import java.util.ArrayList;

/**
 * @ClassName: Code3
 * @Description: 倒着打印链表
 * @Author: lhp
 * @Date: 2019/10/20 20:52
 * @Version: V1.0
 **/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Code3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        int length = list.size();
        System.out.println("ss"+length);
        for (int i = length-1; i >= 0; i--) {
            list1.add(list.get(i));
        }
        return list1;
    }

    public static void main(String[] args) {
        Code3 code3 = new Code3();
        ListNode node = new ListNode(1);
        ListNode temp = node;
        for (int i = 2; i < 6; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node1;
        }
//        while (temp != null) {
//            System.out.println(temp.val);
//            temp = temp.next;
//        }
        ArrayList<Integer> list = code3.printListFromTailToHead(temp);
        System.out.println(list.size());
        for (int j :list){
            System.out.println(j);
        }
    }
}
