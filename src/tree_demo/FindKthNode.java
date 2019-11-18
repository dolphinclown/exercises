package tree_demo;

import common.TreeNode;

/*
给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class FindKthNode {
    private static int num;
    public TreeNode KthNode(TreeNode pRoot, int k){
        if (pRoot == null || k <= 0) {
            return null;
        }
        num = k;
        return findKthNode(pRoot);
    }
    public TreeNode findKthNode(TreeNode pRoot){
        TreeNode target = null;
        if (pRoot.left != null) {
            target = findKthNode(pRoot.left);
        }
        if (target == null) {
            if (num == 1) {
                target = pRoot;
            }
            num--;
        }
        if (target == null && pRoot.right != null) {
            target = findKthNode(pRoot.right);
        }
        return target;
    }
}