package list_demo;

import common.ListNode;

/*两个链表的第一个公共结点
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class FindFirstCommonNode {
    //先分别计算两个链表的长度，计算两个链表的长度差值 n，然后让较长的链表先走 n 步，
    //最后同时遍历两个链表，遍历过程中将两个链表的结点值相比较，直到找到第一个相等节点，返回
    public ListNode fFindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        //1.计算两个链表长度
        int length1 = 0;
        int length2 = 0;
        ListNode position1 = pHead1;
        ListNode position2 = pHead2;
        while(position1 != null){
            length1++;
            position1 = position1.next;
        }
        while(position2 != null){
            length2++;
            position2 = position2.next;
        }
        //2.计算差值
        int diff = 0;
        //3.较长的链表先走 diff 步
        if(length1 >= length2){
            diff = length1 - length2;
            for(int i = 1; i <= diff; i++){
                pHead1 = pHead1.next;
            }
        }else{
            diff = length2 - length1;
            for(int i = 1; i <= diff; i++){
                pHead2 = pHead2.next;
            }
        }
        //4.同时遍历两个链表，找到第一个公共结点
        while(pHead1 != null && pHead2 != null){
            if(pHead1.val == pHead2.val){
                return pHead1;
            }else{
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }
        }
        return null;
    }
}