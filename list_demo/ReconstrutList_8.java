package leetcode;

import org.omg.CORBA.Any;

import java.util.List;

/**
 * Created by CLAY on 2017/3/2.
 * Given a singly linked list L: L0 -> L1 ->...-> Ln-1 -> Ln
 * reorder it to: L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ->...
 * You must do this in-palce without altering the nodes' values.
 * For example
 * Given{1,2,3,4},reorder it to{1,4,2,3}
 */
public class ReconstrutList_8 {
    public static void main(String[] args) {
        ListNode<Integer> e1 = new ListNode<Integer>(1);
        ListNode<Integer> e2 = new ListNode<Integer>(2);
        ListNode<Integer> e3 = new ListNode<Integer>(3);
        ListNode<Integer> e4 = new ListNode<Integer>(4);
        ListNode<Integer> e5 = new ListNode<Integer>(5);
        ListNode<Integer> e6 = new ListNode<Integer>(6);
        ListNode<Integer> e7 = new ListNode<Integer>(7);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;
        e5.next = e6;
        e6.next = e7;

        ListNode<Integer> list = reconstruct(e1);
        ListNode<Integer> pre = list;
        while (pre != null) {
            System.out.print(pre.val+" ");
            pre = pre.next;
        }
        //测试头插法翻转链表
//        ListNode<Integer> e1 = new ListNode<Integer>(1);
//        ListNode<Integer> e2 = new ListNode<Integer>(2);
//        ListNode<Integer> e3 = new ListNode<Integer>(3);
//        ListNode<Integer> e4 = new ListNode<Integer>(4);
//
//        e1.next = e2;
//        e2.next = e3;
//        e3.next = e4;
//        ListNode<Integer> list = reverseList(e1);
//        ListNode<Integer> pre = list;
//        while (pre != null) {
//            System.out.println(pre.val);
//            pre = pre.next;
//        }
    }

    static class ListNode<AnyType> {
        AnyType val;
        ListNode next;

        ListNode(AnyType val) {
            this.val = val;
            next = null;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> ListNode<AnyType> getMid(ListNode<AnyType> head) {
        //设置快慢指针，慢指针走一步，快指针两步。
        ListNode<AnyType> slow = head;
        ListNode<AnyType> fast = head;
        while (fast.next != null && fast.next.next != null) { //缺一不可，链表结点个数可能为奇数，也可能为偶数
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static <AnyType extends Comparable<? super AnyType>> ListNode<AnyType> reconstruct(ListNode<AnyType> head) {

        ListNode<AnyType> mid = getMid(head);
        //将链表分为左右两部分
        ListNode<AnyType> leftEnd = mid;
        mid = mid.next;
        leftEnd.next = null;
        //头插法翻转右半部分链表
        ListNode<AnyType> rightHead = reverseList(mid);

        ListNode<AnyType> p = head;
        ListNode<AnyType> q = rightHead;
        while (p != null && q != null) {
            rightHead = q.next;
            q.next = p.next;
            p.next = q;
            p = q.next;
            q = rightHead;
        }


        return head;
    }

    private static <AnyType extends Comparable<? super AnyType>> ListNode<AnyType> reverseList(ListNode<AnyType> mid) {
        if (mid == null && mid.next == null) {
            return mid;
        }
        ListNode<AnyType> tailHead; //反转后链表的头结点
        ListNode<AnyType> pre; //记录上一次移动到前面的结点，随后更新到mid位置
        pre = mid;
        tailHead = mid;
        while (mid != null && mid.next != null) {
            pre = mid.next;
            mid.next = pre.next;
            pre.next = tailHead;
            tailHead = pre;
            pre = mid;
        }
        return tailHead;
    }
}
