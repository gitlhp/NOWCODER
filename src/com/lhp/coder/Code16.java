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
        ArrayList<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if (root!=null){
            queue.offer(root);
        }
        //队列不为空，执行循环
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }
}
