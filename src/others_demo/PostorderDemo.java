package others_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CLAY on 2017/2/21.
 * Given a binary tree,return the psotorder traversal of its
 * nodes'values.
 * For example:
 *      Given binary tree{1,#,2,3};
 *      1
 *       \
 *       2
 *      /
 *    3
 *    return[3,2,1]
 * Note: Recursive solution is trivial,could you do it iteratively?
 */
public class PostorderDemo {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        List<Integer> list = postorderTraversalRecursive(t1);
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
    static List<Integer> list = new ArrayList<Integer>();
    //1.递归实现
    public static ArrayList postorderTraversalRecursive(TreeNode root) {

        if (root != null) {
            postorderTraversalRecursive(root.left);
            postorderTraversalRecursive(root.right);
            list.add(root.val);
        }else {
            return null;
        }
        return (ArrayList) list;
    }

    //2.迭代实现
    public static ArrayList postorderTraversalInterative(TreeNode root) {

        return (ArrayList) list;
    }
}
