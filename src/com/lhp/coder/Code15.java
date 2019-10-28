package com.lhp.coder;

import java.util.*;

/**
 * @ClassName: Code15
 * @Description:合并两个排序的链表
 * @Author: lhp
 * @Date: 2019/10/26 20:10
 * @Version: V1.0
 **/
public class Code15 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode root = list1;
        List<Integer> list = new ArrayList<>();
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode listNode =null;
        //把所有数据放进集合然后排序
        while (list1 != null) {
            list.add(list1.val);
            listNode =list1;
            list1 = list1.next;
        }
        //连接
        list1 = list2;
        listNode.next=list1;
        while (list2 != null) {
            list.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(list);
        System.out.println(list.size());
        ListNode head = root;
        for (int i:list){
            root.val=i;
            root=root.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Code15 code15 = new Code15();
        ListNode node = new ListNode(1);
        ListNode node11 = new ListNode(5);
        ListNode temp = node;
        ListNode temp1 = node11;
        for (int i = 2; i <= 4; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node1;
        }
        for (int i = 6; i <= 7; i++) {
            ListNode node2 = new ListNode(i);
            node11.next = node2;
            node11 = node2;
        }
        ListNode node22 =null;
        ListNode node1 = code15.Merge(temp,node22);
        while (node1!=null){
            System.out.println(node1.val);
            node1=node1.next;
        }

    }
}
