package string_demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by CLAY on 2017/2/28.
 * 将字符串的空格替换为“20%”
 */
public class ReplaceBlank_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入字符串:");

        String str = reader.readLine();
        reader.close();
        String newStr = replace(str);
        System.out.println(newStr);
    }

    public static String replace(String str) {
        if (str == null) {
            return null;
        }

        int n = str.length();
        int count = 0; //记录输入字符串中空字符的个数
        for (int i = 0; i < n; i++) {
            if (' ' == str.charAt(i)) {
                count++;
            }
        }

        //开辟辅助空间，用以存放组成替换后字符串的字符
        char[] arr = new char[n + 2 * count];

        int i = 0;  //指针，遍历原字符串
        int j = 0;
        while (i < n) {
            char c = str.charAt(i);
            if (' ' == c) {
                arr[j] = '2';
                arr[j + 1] = '0';
                arr[j + 2] = '%';
                j += 3;
            } else {
                arr[j] = c;
                j++;
            }
            i++;
        }

        return new String(arr);
    }
}
