package com.lhp.coder;

import java.util.Arrays;

/**
 * @ClassName: Code4
 * @Description:重建二叉树
 * @Author: lhp
 * @Date: 2019/10/20 22:55
 * @Version: V1.0
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.val = x;
    }
}

public class Code4 {
    //递归比较容易理解
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 && in.length == 0) {
            return null;
        }
        //首先根据先序遍历建立根节点
        TreeNode root = new TreeNode(pre[0]);
        //确定根节点在中序遍历系列中的位置
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                //创建左子树
                /*
                Arrays.copyOfRange(T[ ] original,int from,int to) 左闭右开【）
                 将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组
                 */
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                //右子树同
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                //
                break;
            }
        }
        return root;
    }
    //先序检验
    private void pre(TreeNode node){
        if (node==null) {
            return;
        }
        System.out.println(node.val);
        pre(node.left);
        pre(node.right);
    }

    public static void main(String[] args) {
        Code4 code4 = new Code4();
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = code4.reConstructBinaryTree(pre, in);
        code4.pre(treeNode);

    }

}
