/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0; //进位
        int value; //当前位置两个数相加的结果
        //确定结果链表头结点
        ListNode head = null;
        if (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                carry = 1;
            }
            value = sum % 10;
            head = new ListNode(value);
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode position = head;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
            }
            value = sum % 10;
            position.next = new ListNode(value);
            position = position.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
            }
            value = sum % 10;
            position.next = new ListNode(value);
            position = position.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = 0;
            if (sum >= 10) {
                carry = 1;
            }
            value = sum % 10;
            position.next = new ListNode(value);
            position = position.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            position.next = new ListNode(1);
        }
        return head;
    }
}