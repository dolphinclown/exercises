package tree_demo;

import common.TreeNode;

/**操作给定的二叉树，将其变换为源二叉树的镜像
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Mirror {
    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        //使用前序遍历，如果遍历到的结点有子节点就交换两个子节点,
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left != null){
            Mirror(root.left);
        }

        if(root.right != null){
            Mirror(root.right);
        }
    }
}