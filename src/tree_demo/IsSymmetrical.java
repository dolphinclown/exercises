package tree_demo;

import common.TreeNode;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class IsSymmetrical {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return ifSymmetrical(pRoot.left, pRoot.right);
    }
    
    public boolean ifSymmetrical (TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot1 == null && pRoot2 == null) {
            return true;
        }
        if (pRoot1 == null || pRoot2 == null) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }
        return ifSymmetrical(pRoot1.left, pRoot2.right) && ifSymmetrical(pRoot1.right, pRoot2.left);
    }
}