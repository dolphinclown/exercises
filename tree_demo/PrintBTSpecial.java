import java.util.ArrayList;
import java.util.Stack;

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
public class PrintBTSpecial {
    //思路：借助两个栈来完成，分别保存奇数和偶数层的数据，奇数层的从右到左入栈，偶数层相反
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (pRoot == null) {
            return result;
        }
        Stack[] stack = new Stack[2];
        stack[0] = new Stack<TreeNode>();
        stack[1] = new Stack<TreeNode>();
        int current = 0;
        int next = 1;
        TreeNode cur;
        stack[current].push(pRoot);
        while (!stack[0].empty() || !stack[1].empty()) {
            cur = (TreeNode)stack[current].pop();
            temp.add(cur.val);
            if (current == 0) {
                if (cur.left != null) {
                    stack[next].push(cur.left);
                }
                if (cur.right != null) {
                    stack[next].push(cur.right);
                }
            } else {
                if (cur.right != null) {
                    stack[next].push(cur.right);
                }
                if (cur.left != null) {
                    stack[next].push(cur.left);
                }
            }

            if (stack[current].empty()) {
                result.add(new ArrayList<Integer>(temp));
                temp.clear();
                current = 1 - current;
                next = 1 - next;
            }
        }
        return result;
    }
}