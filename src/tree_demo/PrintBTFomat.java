package tree_demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CLAY on 2017/3/1.
 * 层序打印二叉树结点，每层一行
 */
public class PrintBTFomat {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.right = t2;
        t2.left = t3;
        print(t1);
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

    public static void print(TreeNode root) {

        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int current = 1; //当前层还未打印的结点数
        int next = 0; //下一层的结点个数

        TreeNode cur ;
        queue.offer(root);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val + " ");
            current--;

            if (cur.left != null) {
                queue.offer(cur.left);
                next++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                next++;
            }

            if (current == 0) {
                System.out.println();
                current = next;
                next = 0;
            }

        }

    }
}
