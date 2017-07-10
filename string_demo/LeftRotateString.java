/**
  * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
  */
public class LeftRotateString {
    // abcXYZdef
    // fedZYXcba 先将字符串整体翻转，然后将两部分分别翻转
    public String leftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n < 0) {
            return "";
        }
        char[] array = str.toCharArray();
		// 1. 整体翻转
        reverse(array, 0, array.length - 1);
        int move = n % array.length;
		// 2. 分别翻转两部分
        reverse(array, 0, array.length - 1 - move);
        reverse(array, array.length - move, array.length - 1);
        return new String(array);
    }
    public void reverse(char[] array, int left, int right) {
        for (; left <= right; left++, right--) {
            swap(array, left, right);
        }
    }
    public void swap(char[] array, int left, int right) {
        char temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}