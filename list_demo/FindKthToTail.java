/*输出链表倒数第 k 个结点
static class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}*/
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k){
        if(head == null){
            return null;
        }

        if(k <= 0){
            throw new IligalInputException("Invalid Input!");
        }

        //fast 先走 k - 1 步
        ListNode fast = head;
        for(int i = 1; i < k; i++){
            if(fast.next != null){
                fast = fast.next;
            }else{
                if(i <= k - 1){
                    throw new IligalInputException("Invalid Input!");
                }
            }
        }

        while(fast.next != null){
            head = head.next;
            fast = fast.next;
        }

        return head;
    }

    static class IligalInputException extends Exception{
        public IligalInputException(String message){
            super(message);
        }
    }
}
