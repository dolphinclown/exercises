package demo;

/**
 * 删除排序链表中重复的元素
 */
public class DeleteDuplication {

    // 思路：需要两个指针，一个指向前一个节点 preNode，另一个指向当前节点 curNode，
    // 如果遇到相等的节点，curNode 向后移动，preNode 不动，存下 curNode.val方便后面的比较，
    // 直到遇到 curNode 和 curNode.next 不相等，preNode 就可以指向 curNode.next
    // 注意：链表的第一个结点可能就会重复，初始 preNode=null，若 preNode 为 null，那就把 pHead 设置为 curNode.next
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode curNode = pHead; //用于遍历链表找到下一个不重复的结点
        while (curNode != null) {
            if (curNode.next != null && curNode.val == curNode.next.val) {
                //链表当前节点和当前节点的下一个结点值相等
                int value = curNode.val;
                while (curNode.next != null && curNode.next.val == value) {
                    curNode = curNode.next;
                }
                if (preNode == null) {
                    pHead = curNode.next;
                } else {
                    preNode.next = curNode.next;
                }
            } else {
                //当前结点不存在重复，更新 preNode 为当前结点
                preNode = curNode;
            }
            //更新当前结点指针，指向下一个结点
            curNode = curNode.next;
        }
        return pHead;

    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
