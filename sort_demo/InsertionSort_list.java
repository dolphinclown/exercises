package sortDemo;

/**
 * Created by CLAY on 2017/2/20.
 */
public class InsertionSort_list {
    public static void main(String[] args) {
        ListNode e1 = new ListNode(1);
        ListNode e2 = new ListNode(5);
        ListNode e3 = new ListNode(2);
        ListNode e4 = new ListNode(3);
        ListNode e5 = new ListNode(4);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;

        ListNode list = sort1(e1);
        while (list != null) {
            System.out.print(list.val+",");
            list = list.next;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
            next = null;
        }

    }

    //准备一个空链表，遍历要排序链表，将每个元素插入到
    //新链表正确位置
    public static ListNode sort1(ListNode head){
        //定义头结点
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre;
        while (cur != null) {
            ListNode next = cur.next;
            //每一次刷新pre指针位置，回到新链表头结点
            pre = dumy;
            //寻找当前节点应插入的正确位置
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点加入到新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }
}
