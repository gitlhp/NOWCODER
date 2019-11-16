package com.lhp.coder;

import java.util.*;

/**
 * @ClassName: Code23
 * @Description:删除链表中重复的节点 前提是已经排序好的链表
 * @Author: lhp
 * @Date: 2019/11/16 13:04
 * @Version: V1.0
 **/
public class Code23 {
    //错误版本  这是去重 题意错误
    public ListNode deleteDuplication1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode root = pHead;
        while (pHead.next != null) {
            ListNode node = pHead.next;
            if (node.val == pHead.val) {
                pHead.next = node.next;
            }
            pHead = node;
        }
        return root;
    }

    //思路一气呵成，不是最佳方法 通过
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode root = pHead;
        ListNode root1 = pHead;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        while (pHead != null) {
            if (!map.containsKey(pHead.val)) {
                map.put(pHead.val, 1);
            } else {
                map.put(pHead.val, map.get(pHead.val) + 1);
            }
            pHead = pHead.next;
        }
        for (int i : map.keySet()) {
            if (map.get(i).equals(1)) {
                set.add(i);
                System.out.println(i);
            }
        }
        Iterator<Integer> integerIterator = set.iterator();
        ListNode node1 = null;
        while (integerIterator.hasNext()) {
            root.val = integerIterator.next();
            node1 = root;
            root = root.next;
        }
        if (node1 != null) {
            node1.next = null;
        } else {
            return null;
        }
        return root1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        Code23 code23 = new Code23();
        ListNode node9 = new ListNode(5);
        ListNode node10 = null;
        ListNode node = new ListNode(1);
        ListNode temp = node;

        ListNode node1 = new ListNode(1);
        node.next = node1;
        ListNode node2 = new ListNode(1);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        node3.next = node4;
        ListNode node5 = new ListNode(1);
        node4.next = node5;
        ListNode node6 = new ListNode(1);
        node5.next = node6;

        code23.deleteDuplication(node);
    }
}
