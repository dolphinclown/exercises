package sword;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by CLAY on 2017/6/22.
 * 求一个字符串的全排列（注意去重）
 */
public class Permulation {
    public static ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return list;
        }
        TreeSet<String> set = new TreeSet<String>();
        permutation(set, str.toCharArray(), 0);
        list.addAll(set);
        return list;
    }

    public static void permutation(TreeSet<String> set, char[] arr, int begin) {
        if (begin == arr.length) {
            set.add(new String(arr));
            return;
        }
        for (int position = begin; position < arr.length; position++) {
            char temp = arr[begin];
            arr[begin] = arr[position];
            arr[position] = temp;

            permutation(set, arr, begin + 1);

            temp = arr[begin];
            arr[begin] = arr[position];
            arr[position] = temp;
        }

    }

}
