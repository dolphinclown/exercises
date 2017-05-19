package sortDemo;

import java.util.Arrays;

/**
 * Created by CLAY on 2017/2/17.
 */
public class ShellsortDemo {
    public static void main(String[] args) {
        int[] arr = {7,1,5,12,2,15,8,9,11};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(9 / 2);
    }
    /**
     * 7   1   5   12   2   15   8   9   11
     * 7               2                11
     * |_______________|________________|
     *     1               15
     *     |_______________|
     *         5               8
     *         |_______________|
     *             12              9
     *             |_______________|
     * 一次排序后结果：
     * 2   1   5   9   7   15   8   12   11
     */
    public static void sort(int[] arr) {
        int j;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}
