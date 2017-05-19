package leetcode;

import java.util.Arrays;

/**
 * Created by CLAY on 2016/11/28.
 * 找出一组数中的第K大数
 */
public class FindKDemo {
    public static void main(String[] args) {
        int[] arr = {5, 7, 1, 4, 6, 8, 3};

        System.out.println(findK_A(arr, 3));
        System.out.println(findK_B(arr, 3));
    }

    //排序直接找出
    public static int findK_A(int[] arr, int k) {
        arr = sort(arr);
        return arr[k - 1];
    }

    //将前K个数进行排序  随后将剩余的数逐一和第K个数相比，若大于第k个数，则将其插入正确位置
    public static int findK_B(int[] arr, int k) {
        int[] arrCopy = Arrays.copyOfRange(arr, 0, k + 1);
        arrCopy = sort(arrCopy);

        for (int i = k; i < arr.length; i++) {
            if (arr[k] > arrCopy[k - 1]) {
                for (int n = 0; n < arrCopy.length; n++) {
                    if (arrCopy[n] < arr[k]) {
                        for (int m = arrCopy.length - 1; m > n; m--) {
                            arrCopy[m] = arrCopy[m - 1];
                        }
                        arrCopy[n] = arr[k];
                    }
                }
            }
        }


        return arrCopy[k - 1];
    }

    //冒泡排序
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int y = 0; y < arr.length - i - 1; y++) {
                if (arr[y] < arr[y + 1]) {
                    int temp = arr[y + 1];
                    arr[y + 1] = arr[y];
                    arr[y] = temp;
                }
            }
        }
        return arr;
    }
}

