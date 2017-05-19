package demo;

/**
 * Created by CLAY on 2017/2/27.
 * 最大子序列和
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int[] arr = {-2, 11, -4, 13, -5, -2};
        int maxSubSum = maxSubSum(arr);
        System.out.println(maxSubSum);
    }

    public static int maxSubSum(int[] a) {
        int maxSum = 0;
        int thisSum = 0;

        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];

            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
