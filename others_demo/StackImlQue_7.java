package sword;

import java.util.Stack;

/**
 * Created by CLAY on 2017/3/2.
 */
public class StackImlQue_7<AnyType> {

    private Stack<AnyType> stack1 = new Stack<AnyType>();
    private Stack<AnyType> stack2 = new Stack<AnyType>();

    public void push(AnyType element) {
        stack1.push(element);
    }

    public AnyType pop(){
        if (stack1.empty() && stack2.empty()) {
            throw new RuntimeException("The Queue is empty!");
        }

        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();

    }

    public boolean empty(){
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        StackImlQue_7<Integer> que = new StackImlQue_7<Integer>();
        que.push(1);
        que.push(2);
        que.push(3);

        while (!que.empty()) {
            System.out.println(que.pop());
        }
    }


}
