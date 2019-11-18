package array_demo;

/**
 * Created by CLAY on 2017/3/2.
 * 旋转数组的最小值
 */
public class FindMinInRotationArr_8 {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        int min = findMin(arr);
        System.out.println(min);
    }

    public static int findMin(int[] arr) {

        int index1 = 0;
        int index2 = arr.length - 1;

        //如果数组是事先排好序的，那么直接返回第一个元素
        int midIndex = index1;
        while (arr[index1] > arr[index2]) {

            if ((index2 - index1) == 1) {
                break;
            }
            midIndex = (index1 + index2) / 2;

            //针对特殊数列，无法确定最小元素在左边还是右边的，进行顺序查找
            if (arr[index1] == arr[index2] && arr[index1] == arr[midIndex]) {
                return finInOreder( arr, index1, index2);
            }

            //中间位置元素大于等于index1下标位置的元素，表明最小元素应该在midIndex下标的右边位置
            //中间位置元素小于等于index1下标位置的元素，表明最小元素应该在当前位置或当前位置之前
            if (arr[midIndex] >= arr[index1]) {
                index1 = midIndex;
            } else if (arr[midIndex] <= arr[index1]) {
                index2 = midIndex;
            }
        }

        return arr[midIndex];
    }

    private static int finInOreder(int[] arr, int index1, int index2) {

        int temp = arr[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (arr[i] < temp) {
                temp = arr[i];
            }
        }
        return temp;
    }

}
