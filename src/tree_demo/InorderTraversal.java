package tree_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAY on 2017/3/14.
 */
public class InorderTraversal {
    public static void main(String[] args) {
        /*
                          8
                       /     \
                      6       10
                    /    \   /   \
                   5     7  9     11
                          \
                           1
          中序遍历：5,6,7,1,8,9,10,11
         */
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(6);
        TreeNode t3 = new TreeNode(10);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(9);
        TreeNode t7 = new TreeNode(11);
        TreeNode t8 = new TreeNode(1);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.right = t8;
        List<Integer> list = inorderTraversal(t1);
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

    //出栈时访问
    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.empty()) {
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }

        return list;
    }
}
