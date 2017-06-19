import java.util.ArrayList;
import java.util.Stack;
/**
 *输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 *但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public boolean isPopOrder(int[] pushA,int[] popA) {
        if(pushA == null || pushA.length == 0 || popA == null || popA.length == 0 || pushA.length != popA.length){
        	return false;
        }
        
        //1.分别在两个数组设置一个指向当前位置的指针：pushA--p; popA--q
        //2.遍历 pushA，遍历过程中将元素压入栈中，直到遇到与 popA 中相等的元素（此元素不压栈），将 p 和 q 分别向后移动一个位置。
        //3.当 pushA 中的元素遍历完时，将栈中元素执行出栈操作并与 popA 中的剩余元素相比，最后，如果栈中元素为空，并且 q == popA.length
        //  则表示 popA 是 pushA 的弹出序列。
        Stack<Integer> stack = new Stack<Integer>();
        int p = 0;
        int q = 0;
        while(p < pushA.length && q < popA.length){
            if(pushA[p] == popA[q]){
                p++;
                q++;
                //判断当前栈顶的元素，和 popA[q]是否相等，如果相等，将栈顶元素弹出，q 向后移动一个下标
                if(!stack.empty()){
                    if(stack.peek() == popA[q]){
                        stack.pop();
                        q++;
                    }
                }
            }else{
                stack.push(pushA[p]);
                p++;
            }
        }
        
        while(!stack.empty() && q < popA.length){
            if(stack.pop() != popA[q]){
                break;
            }
            q++;
        }
        
        if(stack.empty() && q == popA.length){
            return true;
        }
        return false;
    }
}