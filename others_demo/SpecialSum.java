package demo;

/**
 * Created by CLAY on 2017/1/18.
 * 限制条件判断语句和循环语句，计算1~n的和
 */
public class SpecialSum {
    public static void main(String[] args) {
        int n= sum(100);
        System.out.println(n);
    }
    private static int sum;
    public static int sum(int n){
        sum += n;
        sum = n == 0? sum:sum(--n);
        return sum;
    }
}
