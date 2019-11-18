package sort_demo;

import java.util.Arrays;

/**
 * Created by CLAY on 2017/2/27.
 * 三数中值分割法  选择枢纽元
 */
public class QuickSortDemo {
    private static final int CUTOFF = 10;

    public static void main(String[] args) {
        Integer[] a = {8, 1,12,17, 4, 9, 0, 3, 5, 2, 7, 6,10};
        quicksort(a);
        System.out.println(Arrays.toString(a));
//         insertionSort(a,0,9);
//        System.out.println(Arrays.toString(a));
    }

    /**
     * 驱动程序
     * Quicksort algorithm
     *
     * @param a         an array of Comparable items.
     * @param <AnyType>
     */
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a) {
        quicksort(a, 0, a.length - 1);

    }

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     *
     * @param a
     * @param left      left the left-most index of the subarray.
     * @param right     right the right-most index of the subarray.
     * @param <AnyType>
     */
    private static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            AnyType pivot = median(a, left, right);
            System.out.println(pivot);
            //使用三数中值法划分后数组第一个元素left，最后一个元素right，以及枢纽元素pivot三个位置符合由小至大排列
            //枢纽元素位于right - 1 下标

            //Begin partitioning
            int i = left;
            int j = right - 1;

            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }

                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }

            //将下标i的元素与pivot元素交换位置
            swapReferences(a, i, right - 1);
            System.out.println(Arrays.toString(a));
            quicksort(a, left, i - 1); //Sort smal elements
            quicksort(a, i + 1, right); //Sort large elements

        } else {
            //Do an insertion sort on the subarray
            insertionSort(a,left,right);
        }
    }

    /**
     * @param a
     * @param left
     * @param right
     * @param <AnyType>
     * @return median of left, center, and right.
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median(AnyType[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0) {
            swapReferences(a, left, center);
        }

        if (a[right].compareTo(a[left]) < 0) {
            swapReferences(a, right, left);
        }

        if (a[right].compareTo(a[center]) < 0) {
            swapReferences(a, center, right);
        }

        //Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }

    private static <AnyType> void swapReferences(AnyType[] a, int i, int j) {
        AnyType temp;

        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] arr,int left,int right) {
        int i;
        for (int p = left; p < right + 1; p++) {
            AnyType temp = arr[p];
            for (i = p; i > left && temp.compareTo(arr[i - 1]) < 0 ; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = temp;
        }
    }
}
