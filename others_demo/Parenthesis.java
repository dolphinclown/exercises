import java.util.*;
/**
  * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
  * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
  */
public class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        if (A == null || n == 0) {
            return false;
        }
        // 定义一个变量 num，如果遇到左括号 num++，遇到右括号 num--，当 num < 0 
        // 时，表示此串不符合条件
        int num = 0;
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c != '(' && c != '(') {
                return false;
            } else if (c == '(') {
                num++;
            } else if (c == ')') {
                num--;
            }
            if (num < 0) {
                return false;
            }
        }
        if (num != 0) {
            return false;
        }
        return true;
    }
}