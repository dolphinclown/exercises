package list_demo;

/*输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
  另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
  public class RandomListNode {
      int label;
      RandomListNode next = null;
      RandomListNode random = null;

      RandomListNode(int label) {
          this.label = label;
      }
  }
*/
public class CloneComplexList {
    public RandomListNode clone(RandomListNode pHead)
    {
        if(pHead == null){
            return null;
        }
        RandomListNode position = pHead;
        //1.首先，将链表中每一个结点都进行复制，将得到的新结点放在原结点后面
        while(position != null){
            RandomListNode newNode = new RandomListNode(position.label);
            newNode.next = position.next;
            position.next = newNode;
            position = newNode.next;
        }
        position = pHead;
        //2.将复制得到结点的特殊指针指向正确的结点处
        while(position != null){
            RandomListNode tempPosition = position.next;
            if(position.random != null){
                tempPosition.random = position.random.next;
            }
            position = tempPosition.next;
        }
        position = pHead;
        //3.将复制的结点拆分出来
        RandomListNode newHead = null;
        RandomListNode clonedPosition = null;
        if(position != null){
            newHead = clonedPosition = position.next;
            position.next = clonedPosition.next;
            position = position.next;
        }
        while(position != null){
            clonedPosition.next = position.next;
            clonedPosition = clonedPosition.next;
            position.next = clonedPosition.next;
            position = position.next;
        }
        return newHead;
    }

    private class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}