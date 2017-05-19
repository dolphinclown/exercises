package binaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAY on 2017/2/21.
 */
public class PostorderTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<Integer> list = postorder1(t1);
        System.out.println(list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
            this.left = null;
            this.right = null;
        }
    }
    

    public static List postorder1(TreeNode root) {

        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (root == null) {
            return null;
        }

        TreeNode pre = null;
        TreeNode cur;
        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if (cur.left == null && cur.right == null ||
                    pre != null && (pre == cur.left || pre == cur.right)) {
                //当前节点没有左右孩子，或者左孩子右孩子存在却已经被访问,才可以访问当前节点
                list.add(cur.val);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
        return list;
    }

}
