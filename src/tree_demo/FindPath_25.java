package tree_demo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by CLAY on 2017/3/15.
 * 求二叉树中所有和为某一值得路径（到叶节点停止为一条）
 */
public class FindPath_25 {
    public static void main(String[] args) {
        BinaryTreeNode t1 = new BinaryTreeNode(10);
        BinaryTreeNode t2 = new BinaryTreeNode(5);
        BinaryTreeNode t3 = new BinaryTreeNode(12);
        BinaryTreeNode t4 = new BinaryTreeNode(4);
        BinaryTreeNode t5 = new BinaryTreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        ArrayList<LinkedList<Integer>> paths = findPath(t1, 22);
        System.out.println(paths);
    }

    static class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static ArrayList<LinkedList<Integer>>  findPath(BinaryTreeNode root, int aimVal) {
        if(root == null){
            return null;
        }
        if(aimVal < root.val){
            return null;
        }
        ArrayList<LinkedList<Integer>> paths = new ArrayList<LinkedList<Integer>>();
        LinkedList<Integer> path = new LinkedList<Integer>();
        int currentSum = 0;
        findPath(root, aimVal, path, paths, currentSum);
        return paths;
    }

    private static void findPath(BinaryTreeNode root, int aimVal, LinkedList<Integer> path, ArrayList<LinkedList<Integer>> paths, int currentSum) {
        currentSum += root.val;
        path.addLast(root.val);

        //若为叶节点，并且当前路径上个的节点和等于输入值，添加此路径到 paths
        if(currentSum == aimVal && root.left == null && root.right == null){
            paths.add(new LinkedList<Integer>(path));
        }

        //如果不是叶节点，遍历它的子节点
        if (root.left != null) {
            findPath(root.left, aimVal, path, paths, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, aimVal, path, paths, currentSum);
        }

        //退回父节点前，在当前路径上删除此节点
        path.removeLast();
    }
}
