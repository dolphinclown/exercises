package demo;

/**
 * Created by CLAY on 2017/2/11.
 * Sum of Two Integers:
 * Calculate the sum of two integers a and b,but you
 * are not allowed to use the operator + and -.
 * Example: Given a = 1 and b = 2,return 3.
 */
public class SpecialAdd {
    public static void main(String[] args) {
        System.out.println(getSum(3,2));
    }

    public static int getSum(int a,int b){
        while (a != 0) {
            int x = a^b; //不带进位的结果
            a = (a & b) << 1; //a&b 的到a + b产生进位的位构成的二进制，然后左移一位（*2）
            b = x; //将上面两个二进制相异或
        }
        return b;
    }

//    }
}
