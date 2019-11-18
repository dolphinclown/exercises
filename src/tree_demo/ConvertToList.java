package tree_demo;

/**
 * Created by CLAY on 2017/6/21.
 *输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertToList {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //最后加入的链表中的结点
    public static TreeNode lastNodeInList = null;
    public static TreeNode convert(TreeNode pRootOfTree) {
        /*left 相当于双链表的 pre 指针， right 相当于双链表的 next 指针
          使用中序遍历，非叶结点的左子树为 left 指针指向的结点，右子树为 right 指针指向的结点
          树的根结点的 left 指针指向左子树的最大值，right 指针指向右子树的最小值
         */
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        convertNode(pRootOfTree);
        //从后往前，找到链表的头结点
        TreeNode headNodeInList = lastNodeInList;
        while (headNodeInList != null && headNodeInList.left != null) {
            headNodeInList = headNodeInList.left;
        }
        return headNodeInList;
    }

    public static void convertNode(TreeNode root ) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            convertNode(root.left);
        }

        //将当前结点的 left 指针更新为上一次加入链表的结点（lastNodeInList），
        //并将上一次加入链表的结点（lastNodeInList）的 right 指针指向当前结点
        root.left = lastNodeInList;
        if (lastNodeInList != null) {
            lastNodeInList.right = root;
        }
        //将 lastNodeINList 更新为最后加入链表的结点
        lastNodeInList = root;

        if (root.right != null) {
            convertNode(root.right);
        }
    }
}
