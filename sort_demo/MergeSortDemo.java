package sortDemo;

import java.util.Arrays;

/**
 * Created by CLAY on 2017/2/15.
 * 数组存储时间复杂度O(nlogn),空间复杂度O(n).
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        Integer[] arr = {2,1,6,8,3};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /**
     * Mergesort algorithm.
     *
     * @param a an array of Comparable items.
     */
    public static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a) {
        AnyType[] tempArray = (AnyType[]) new Comparable[a.length];
        mergeSort(a, tempArray, 0, a.length - 1);
    }

    /**
     * Internal method that makes recursive calls.
     *
     * @param a         an array of Comparable items.
     * @param tempArray an array to place the merged result.
     * @param left      the left-most index of the subarray.
     * @param right     the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> void mergeSort(AnyType[] a, AnyType[] tempArray,
                                                                                int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center + 1, right);
        }
    }

    /**
     * Internal method that merges two sorted halves of a subarray.
     *
     * @param a         an array of Comparable items.
     * @param tempArray an array to place the merged result.
     * @param leftPos   the left-most index of the subarray.
     * @param rightPos  the index of the start of the second half.
     * @param rightEnd  the right-most index of the subarray.
     */
    private static <AnyType extends Comparable<? super AnyType>> void merge(AnyType[] a, AnyType[] tempArray,
                                                                            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int temPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        //Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tempArray[temPos++] = a[leftPos++];
            } else {
                tempArray[temPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) { //Copy rest of first half
            tempArray[temPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) { ////Copy rest of right half
            tempArray[temPos++] = a[rightPos++];
        }

        //Copy tempArray back
        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tempArray[rightEnd];
        }
    }
}
