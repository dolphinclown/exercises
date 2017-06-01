public class Solution {
    public ListNode FindKthToTail(ListNode head,int k){
		if(head == null){
            return null;
        }
        
        if(k <= 0){
			throw new IligalInputException("Invalid Input!");
        }
        
        //fast ÏÈ×ß k - 1 ²½
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
    
    static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

    static class IligalInputException extends Exception{
   		public IligalInputException(String message){
     		super(message);
   		}
    }
}
