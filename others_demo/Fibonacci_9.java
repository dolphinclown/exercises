package sword;

/**
 * Created by CLAY on 2017/3/2.
 * 斐波那契数列
 */
public class Fibonacci_9 {
    public static void main(String[] args) {
        int a = recursiveIml(10);
        System.out.println(a);

        int b = iteration(10);
        System.out.println(b);
    }

    public static int recursiveIml(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return recursiveIml(n - 1) + recursiveIml(n - 2);
    }

    public static int iteration(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int FibonacciOne = 0;
        int FibonacciTwo = 1;
        int temp = 0;
        for (int i = 2; i <= n; i++) {
            temp = FibonacciOne + FibonacciTwo;
            if (i == n) {
                break;
            }
            FibonacciOne = FibonacciTwo;
            FibonacciTwo = temp;
        }
        return temp;
    }
}
