package com.lhp.coder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: Code16
 * @Description:从上往下打印二叉树
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/10/28 19:56
 * @Version： V1.0
 **/

public class Code16 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root==null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if (root.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }
}
