/*输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }else if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        ListNode head = null;
        //1.确定头结点
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }

        ListNode p = head; //指向合并链表的当前合并结点
        //2.合并链表
        while(list1 != null && list2 != null){
            if(list1.val >= list2.val){
                p.next = list2;
                list2 = list2.next;
                p = p.next;
            }else{
                p.next = list1;
                list1 = list1.next;
                p = p.next;
            }
        }

        if(list1 != null){
            p.next = list1;
        }

        if(list2 != null){
            p.next = list2;
        }


        return head;
    }
}