/**
  * 0,1,...,n - 1 这 n 个数字排成一个圆圈，从数字0开始每次从这个圆圈里
  * 删除第 m 个数字。求出这个圆圈中剩下的最后一个数字。
  */
public class LastRemaining {
	//约瑟夫环问题：1.用环形链表模拟圆圈的解法   2.分析每次删除的数字规律并直接计算出最后一个数
    public int lastRemaining1(int n, int m) {
         
        if(m <= 0 || n <= 0){
            return -1;
        }
        //先构造循环链表
        ListNode head = new ListNode(0); //头结点, 值为0
        ListNode pre = head;
        ListNode temp = null;
        for(int i = 1; i < n; i++){
            temp = new ListNode(i);
            pre.next = temp;
            pre = temp;
        }
        temp.next = head;//将第n-1个结点(也就是尾结点)指向头结点
         
        ListNode temp2 = null;
        while(n != 1){
            temp2 = head;
            //先找到第m个结点的前驱
            for(int i = 1; i < m - 1; i++){
                temp2 = temp2.next;
            }
            //删除第m个结点：将第m个结点的前驱指向第m个结点后面那个结点,temp2表示第m个结点的前驱
            temp2.next = temp2.next.next;
            head = temp2.next; //更新头结点
            n--;
        }
     
        return head.value;
         
    }

	public int lastRemaining2(int n, int m) {
		if (n <= 0 || m <= 0) {
			return -1;
		}
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
 
/**
 * 结点
 */
class ListNode {
    int value;
    ListNode next = null;
     
    public ListNode(int val) {
        this.value = val;
    }
}