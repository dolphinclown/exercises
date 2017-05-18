package sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by CLAY on 2017/2/28.
 */
public class ReverseList_5 {

    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);

        t1.next = t2;
        t2.next = t3;

//        List list = reverse1(t1);
        List list = reverse2(t1);
        System.out.println(list);
    }

    private static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    //1.递归
    public static List reverse1(ListNode head) {

        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head;

        if (head == null) {
            return null;
        } else if (p.next != null) {
           reverse1(p.next);
        }
        // System.out.println(head.value);
        list.add(head.value);
        return list;
    }

    //2.用栈的特性
    public static List reverse2(ListNode head) {

        Stack stack = new Stack();
        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head;
        if (head == null) {
            return null;
        } else {
            while (p != null) {
                stack.push(p.value);
                p = p.next;
            }
        }

        while (!stack.empty()) {
            list.add((Integer) stack.pop());
        }
        return list;
    }

}
