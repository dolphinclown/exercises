package others_demo;

/**
 * Created by CLAY on 2017/3/29.
 * 输入n，求0-n的阶乘和
 */
public class factoriaDemo {
    public static void main(String[] args) {
        System.out.println(add(3));
    }

    public static long recursive(int n){

        if (n < 0) {
            return 0L;
        }

        if (n == 1 || n == 0) {
            return 1L;
        }

        return n * recursive(n - 1); //某个数的阶乘
    }

    public static long add(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += recursive(i);
        }

        return sum;
    }
}
