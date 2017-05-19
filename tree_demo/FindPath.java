package sword;

import java.util.LinkedList;

/**
 * Created by CLAY on 2017/3/15.
 * 打印和为目标值的所有路径(到叶节点停止)
 */
public class FindPath_25 {
    public static void main(String[] args) {

        BinTreeNode t1 = new BinTreeNode(10);
        BinTreeNode t2 = new BinTreeNode(5);
        BinTreeNode t3 = new BinTreeNode(12);
        BinTreeNode t4 = new BinTreeNode(4);
        BinTreeNode t5 = new BinTreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        findPath(t1, 22);
    }

    static class BinTreeNode {
        int val;
        BinTreeNode left;
        BinTreeNode right;

        public BinTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void findPath(BinTreeNode root, int aimVal) {
        if (root == null || aimVal <= 0) {
            return;
        }

        if (aimVal < root.val) {
            return;
        }

        LinkedList<BinTreeNode> list = new LinkedList<BinTreeNode>();
        int currentSum = 0;
        BinTreeNode cur = root;
        BinTreeNode pre = null;

        while (cur != null || !list.isEmpty()) {
            while (cur != null) {
                currentSum += cur.val;
                list.addLast(cur);
                pre = cur;
                cur = cur.left;
            }

            //当前路径和为目标值，并且当前路径所有节点已经加入路径中
            if (currentSum == aimVal && pre.left == null && pre.right == null) {
                for (BinTreeNode t : list) {
                    System.out.print(t.val + " ");
                }
                    System.out.println();
            }

            if (!list.isEmpty()) {
                cur = list.getLast();
                if (cur.left == null || cur.right == null) {
                    currentSum -= list.removeLast().val;
                }
                cur = cur.right;
            }
        }
    }

}
