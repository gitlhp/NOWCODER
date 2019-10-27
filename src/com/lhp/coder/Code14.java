package com.lhp.coder;

import java.util.Stack;

/**
 * @ClassName: Code14
 * @Description:反转链表
 * @Author: lhp
 * @Date: 2019/10/26 14:58
 * @Version: V1.0
 **/
public class Code14 {
    /**方法一：暴力思路简单
     * 运行时间：24ms
     * 占用内存：9488k
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        ListNode node = stack.pop();
        ListNode root = node;
        while (!stack.empty()) {
            node.next = stack.pop();
            node =node.next;
        }
        //最后将原链表的头结点.next置为null 否则将死循环
        node.next=null;
        return root;
    }

    /**方法二042-=
     * 示例：1->2->3->4
     * 运行时间：29ms
     * 占用内存：9452k
     * @param head
     * @return
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //先记住想要操作的节点的下个节点 否则丢失  记住 2
            next = head.next;
            //头结点指针指向null作为新链表的尾 1->null
            head.next = pre;
            //第一步记下的节点的下个节点 pre = null 变成 pre = 1
            pre = head;
            //处理下个节点 head = 2
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Code14 code14 = new Code14();
        ListNode node = new ListNode(1);
        ListNode temp = node;
        for (int i = 2; i <= 4; i++) {
            ListNode node1 = new ListNode(i);
            node.next = node1;
            node = node1;
        }
        ListNode node2 = code14.ReverseList1(temp);
        while (node2!=null){
            System.out.println(node2.val);
            node2=node2.next;
        }
    }
}
