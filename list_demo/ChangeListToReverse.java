/*输入一个链表，反转链表后，输出链表的所有元素。
public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
 		if(head == null){
           return null; 
        }
        
        //使用三个指针，head 指针保持不变，pre 指向新的头结点，behind 指向下一个要移动的结点
        ListNode pre = head;
        ListNode behind = head.next;
        
        while(behind != null){
            head.next = behind.next;
            behind.next = pre;
            pre = behind;
            behind = head.next;
        }
        
        return pre;
    }
}