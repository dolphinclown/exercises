package tree_demo;

import java.util.LinkedList;

public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // 思路：前序遍历二叉树，分别找出从根结点到 A B 两个结点的路径，
        //       然后，问题就转化成了求两个链表的公共结点，遍历过程中，
        //       将路径保存在栈中。
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> pathA = new LinkedList<TreeNode>();
        LinkedList<TreeNode> pathB = new LinkedList<TreeNode>();
        getPath(root, A, pathA);
        getPath(root, B, pathB);
        TreeNode result = getLowestCommonAncestor(pathA, pathB);
        return result;
    }

    public static boolean getPath(TreeNode root, TreeNode aim, LinkedList<TreeNode> path) {
        path.add(root);
        if (root == aim)
            return true;
        boolean found = false;
        if (root.left != null)
            found = getPath(root.left, aim, path);
        if (found == false && root.right != null)
            found = getPath(root.right, aim, path);
        if (!found)
            path.removeLast();
        return found;
    }

    public static TreeNode getLowestCommonAncestor(LinkedList<TreeNode> pathA, LinkedList<TreeNode> pathB) {
        TreeNode result = null;
        int lengthA = pathA.size();
        int lengthB = pathB.size();
        int diff = 0;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            for (int i = 0; i < diff; i++) {
                pathA.removeLast();
            }
        } else {
            diff = lengthB - lengthA;
            for (int i = 0; i < diff; i++) {
                pathB.removeLast();
            }
        }
        while (pathA.size() != 0 && pathB.size() != 0) {
            if (pathA.getLast() == pathB.getLast()) {
                result = pathA.getLast();
                break;
            }
            pathA.removeLast();
            pathB.removeLast();
        }
        return result;
    }

    private static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }
}