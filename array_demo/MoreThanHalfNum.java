package sword;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CLAY on 2017/6/24.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    //方法一：利用 HashMap<Integer, Integer> K-当前数字，V-代表出现次数，最后找出超过数组长度一半的数字--[空间复杂度O(n),时间复杂度O(n)]
    //方法二：使用攻守阵地法，开始初始化一个变量 times 为1，初始化结果变量为数组第一个元素，遍历数组，遇到与结果变量相同的数字将
    //		 值加一；遇到一个不相同的数字，将值减一，若此时 times < 0,将 times 赋值为 1，并将结果变量设置为当前元素，
    //    	 最后检查对应结果变量是否超过数组长度一半，输出对应结果--[时间复杂度O(n)]
    //方法三：根据数组的特点，利用部分快排 partition() 找出中间元素即为要选的--[时间复杂度O(nlogn)]
    //        注意：会改变数组元素相对位置

    //方法一：
    public static int moreThanHalfNum1(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > result) {
                result = entry.getKey();
            }
        }
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    //方法二：
    public static int moreThanHalfNum2(int[] array) {
        //使用攻守阵地
        if (array == null || array.length == 0) {
            return 0;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result) {
                times += 1;
            } else {
                times -= 1;
                if (times <= 0) {
                    times = 1;
                    result = array[i];
                }
            }
        }
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    //方法三：
    public static int moreThanHalfNum3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int mid = array.length / 2;
        int position = partition(array, 0, array.length - 1);
        int result;
        int start = 0;
        int end = array.length - 1;
        while (position != mid) {
            if (position < mid) {
                start = position + 1;
                position = partition(array, start, end);
            } else {
                end = position - 1;
                position = partition(array, start, end);
            }
        }
        result = array[position];
        if (!checkMoreThanHalf(array, result)) {
            return 0;
        }
        return result;
    }

    private static int partition(int[] array, int left, int right) {
        int pos = array[left];
        int i = left;
        int j = right + 1;
        for (; ; ) {
            while (array[++i] < pos && i < right);
            while (array[--j] > pos);
            if (i >= j) {
                break;
            } else {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static boolean checkMoreThanHalf(int[] array, int result) {
        int count = 0;
        int halfOfLength = array.length / 2;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            }
        }
        if (count > halfOfLength) {
            return true;
        }
        return false;
    }
}
