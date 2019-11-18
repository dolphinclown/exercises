package sort_demo;

/**
 * Created by CLAY on 2017/2/15.
 * 链表存储时间复杂度O(nlogn),空间复杂度O(1).
 */
public class MergeSortDemo_list {
    public static void main(String[] args) {
        ListNode<Integer> e1 = new ListNode<Integer>(1);
        ListNode<Integer> e2 = new ListNode<Integer>(5);
        ListNode<Integer> e3 = new ListNode<Integer>(2);
        ListNode<Integer> e4 = new ListNode<Integer>(3);
        ListNode<Integer> e5 = new ListNode<Integer>(4);

        e1.next = e2;
        e2.next = e3;
        e3.next = e4;
        e4.next = e5;

        e1 = mergeSort(e1);
        while (e1 != null) {
            System.out.print(e1.val+",");
            e1 = e1.next;
        }
    }

    static class ListNode<AnyType> {
        AnyType val;
        ListNode next;

        ListNode(AnyType val) {
            this.val = val;
            next = null;
        }
    }

    public static <AnyType extends Comparable<? super AnyType>> ListNode<AnyType> mergeSort(ListNode<AnyType> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<AnyType> mid = getMid(head);
        ListNode<AnyType> right = mergeSort(mid.next);
        mid.next = null;
        ListNode<AnyType> left = mergeSort(head);
        return merge(left, right);
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

    private static <AnyType extends Comparable<? super AnyType>> ListNode<AnyType> merge(ListNode<AnyType> left, ListNode<AnyType> right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode<AnyType> head = null;
        if (left.val.compareTo(right.val) > 0) {
            head = right;
            right = right.next;
        } else {
            head = left;
            left =  left.next;
        }

        ListNode<AnyType> temp = head;
        while (left != null && right != null) {
            if (left.val.compareTo(right.val) > 0) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }

        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return head;
    }

}
