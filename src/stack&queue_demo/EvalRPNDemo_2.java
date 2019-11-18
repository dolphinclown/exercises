import java.util.Stack;

/**
 * Created by CLAY on 2016/12/1.
 * 计算逆波兰式的值：从前至后计算
 * 例如：["2","1","+","3","*"]->((2+1)*3)->9
 */
public class EvalRPNDemo_2 {
    public static void main(String[] args) {
        String[] strs = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(strs));
    }

    public static int evalRPN(String[] strs) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < strs.length; i++) {
            try {
                int n = Integer.parseInt(strs[i]);
                stack.push(n);

            } catch (Exception e) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(a,b,strs[i]));
            }
        }
        return stack.pop();

    }
    private static int calculate(int a,int b,String str) {
        //jdk8可以直接将String作为switch的判定条件
        char c = str.charAt(0);
        switch (c) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                return a/b;
            default:
                return 0;
        }
    }
}



