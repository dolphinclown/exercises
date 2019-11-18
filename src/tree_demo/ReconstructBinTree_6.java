package tree_demo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CLAY on 2017/3/1.
 * 根据前序和中序重构二叉树
 */
public class ReconstructBinTree_6 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = null;
        try {
            root = construct(pre, in);
        } catch (InvalidInputException e) {
            System.out.println(e.toString());
        }
        print(root);
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

    public static TreeNode construct(int[] pre, int[] in) throws InvalidInputException {
        if (pre == null || in == null
                || pre.length != in.length
                || pre.length == 0 || in.length == 0) {
            throw new InvalidInputException("Invalid input");
        }
        TreeNode root = constructCore(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private static TreeNode constructCore(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) throws InvalidInputException {
        if (endPre < 0 || endIn < 0) {
            return null;
        }

        //前序遍历的第一个元素为根结点
        TreeNode root = new TreeNode(pre[startPre]);

        //中序遍历得到左右子树的元素,并确定结点数量
        int rootIn = startIn;   //rootIn指针对中序数组进行遍历，最后指向根结点下标（中序遍历数组中）
        while (rootIn <= endIn && in[rootIn] != root.val) {
            ++rootIn;
        }
        if (rootIn == endIn && in[rootIn] != root.val) {
           throw new InvalidInputException("Invalid input");  //错误输入
        }


        int leftLength = rootIn - startIn;

        //前序遍历数组中左子树元素，最后一个的下标
        int leftPreorderEnd = startPre + leftLength;
        if (leftLength > 0) {
            //构建左子树
            root.left = constructCore(pre, startPre + 1, leftPreorderEnd, in, startIn, rootIn - 1);
        }
        //前序数组中，除了左子树哪些元素，是否还有剩余
        if (leftLength < endPre - startPre) {
            //构建右子树
            root.right = constructCore(pre, leftPreorderEnd + 1, endPre, in, rootIn + 1, endIn);
        }
        return root;
    }


    //打印二叉树
    public static void print(TreeNode root) {

        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int current = 1; //当前层还未打印的结点数
        int next = 0; //下一层的结点个数

        TreeNode cur;
        queue.offer(root);

        while (!queue.isEmpty()) {
            cur = queue.poll();
            System.out.print(cur.val+"  ");
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

    static class InvalidInputException extends Exception {
        public InvalidInputException(String s) {
            super(s);
        }
    }
}
