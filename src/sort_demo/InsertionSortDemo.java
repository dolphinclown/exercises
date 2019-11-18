package sort_demo;

import java.util.Arrays;

/**
 * Created by CLAY on 2016/12/3.
 */
public class InsertionSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 3, 1, 2, 7, 8, 6};
        System.out.println(Arrays.toString(insertSort(arr)));
    }

    public static int[] insertSort(int[] arr) {
        int i;
        for (int p = 1; p < arr.length; p++) {
            int temp = arr[p];
            for (i = p; i > 0 && temp < arr[i - 1]; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = temp;
        }
        return arr;
    }
}
