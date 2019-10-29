package com.lhp.coder;

/**
 * @ClassName: Code17
 * @Description:二叉树的镜像
 * @Author: 李怀鹏
 * @Company: JD-BJUT
 * @Date： 2019/10/29 18:10
 * @Version： V1.0
 **/
public class Code17 {
    public void Mirror(TreeNode root) {
        if (root==null) {
            return;
        }
        if (root.left!=null||root.right!=null){
            TreeNode node = root.left;
            root.left=root.right;
            root.right = node;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

}
