import java.util.Stack;
/**
 *定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class GetMinFromStack {

	/*使用两个栈，一个栈中正常保存所有元素（a），另一个栈用于得到最小元素，最小元素位于栈顶(b)
     *1.开始两个栈为空，向 a 中压入一个元素，将这个元素同时压入 b
     *2.之后压入元素时，应当进行判断：当前元素与 b 中栈顶元素比较，若小于 b 栈顶元素，则同时将此元素压入 b 栈；
     *  当前元素若大与 b 栈顶的元素，则将 b 栈顶元素重复压入 b 一次
     *3.如果要使一个元素出栈（从 a 中弹出），那么同时弹出 b 栈顶的元素
     */ 
    private static Stack<Integer> a = new Stack<Integer>();
    
    private static Stack<Integer> b = new Stack<Integer>();
    
    public void push(int node) {
        if(a.empty() && b.empty()){
            a.push(node);
            b.push(node);
        }else if(node <= b.peek()){
            a.push(node);
            b.push(node);
        }else{
            a.push(node);
            b.push(b.peek());
        }
        
    }
    
    public void pop() {
        if(a.empty() && b.empty()){
    		return;
        }
        a.pop();
       	b.pop();
    }
    
    public int top() {
        if(a.empty() && b.empty()){
    		return -1;
        }
        return a.peek();
    }
    
    public int min() {
        if(a.empty() && b.empty()){
    		return -1;
        }
    	return b.peek();
    }
}