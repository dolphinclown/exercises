package tree_demo;

import common.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTree {
    // 思路一：对二叉树进行后序遍历，遍历过程中对每个结点进行判断（左右子节点的深度差的绝对值 <= 1），如果不满足，则不平衡。
    //       缺点：存在大量深度重复计算
    // 思路二：将计算深度的方法进行改进，采用后序遍历，遍历过程中将计算过的结点深度保存起来，避免重复计算
    public int getDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if(root.left != null){
            leftDepth = getDepth(root.left);
        }
        if(root.right != null){
            rightDepth = getDepth(root.right);
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

    // 方法一：
    public boolean isBalanced(TreeNode root){
        if(root == null){
            return true;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(Math.abs(leftDepth - rightDepth) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // 方法二：
    public boolean IsBalanced2(TreeNode root) {
        if(checkDepth(root) == -1) {
            return false;
        }else{
            return true;
        }
    }

    public int checkDepth(TreeNode root){
        if (null == root) return 0;
        int leftDepth = checkDepth(root.left);
        if ( leftDepth == -1) {
            return -1; //unbalanced
        }

        int rightDepth = checkDepth(root.right);
        if ( rightDepth == -1) {
            return -1; //unbalanced
        }

        int depthDiff = leftDepth - rightDepth;
        if (Math.abs(depthDiff) > 1) {
            return -1; // unbalanced
        }
        else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}