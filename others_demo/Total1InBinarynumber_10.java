package sword;

/**
 * Created by CLAY on 2017/3/8.
 * 二进制中 1 的个数
 */
public class Total1InBinarynumber_10 {
    public static void main(String[] args) {

        int n = total(3);
        System.out.println(n);

    }

    //一个整数减去1之后再和原来的整数做位与运算，得到的值相当于把原来的整数二进制
    //表示中的最右边一个1变为0,。
    public static int total(int n) {

        if (n == 0) {
            return 0;
        }

        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }

        return count;
    }
}
