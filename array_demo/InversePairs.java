package sword;

/**
 * Created by CLAY on 2017/7/9.
 * 求数组中的逆序对数
 */
public class InversePairs {
	// 思路：利用归并思想，先将数组拆分，然后边合并边计算逆序对数。
    public static int inversePairs(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        return mergeSort(array, copy, 0, array.length - 1);
    }

    public static int mergeSort(int[] array, int[] copy, int left, int right) {
        if (left == right) {
            copy[left] = copy[right];
            return 0;
        }
        int mid = (left + right) / 2;
        int leftPairs = mergeSort(array, copy, left, mid);
        int rightPairs = mergeSort(array, copy, mid + 1, right);

        int leftEnd = mid;
        int rightPos = mid + 1;
        int rightEnd = right;
        int indexCopy = right; //后半段最后一个数的下标
        int count = 0;
        while (leftEnd >= left && rightEnd >= rightPos) {
            if (array[leftEnd] > array[rightEnd]) {
                copy[indexCopy--] = array[leftEnd--];
                count += rightEnd - rightPos + 1;
            } else {
                copy[indexCopy--] = array[rightEnd--];
            }
        }
        while (leftEnd >= left) {
            copy[indexCopy--] = array[leftEnd--];
        }
        while (rightEnd >= rightPos) {
            copy[indexCopy--] = array[rightEnd--];
        }
        for (int i = left; i <= right; i++) {
            array[i] = copy[i];
        }
        return leftPairs + rightPairs + count;
    }
}
