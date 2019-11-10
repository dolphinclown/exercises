/**
 * 翻转单词序列：student. a am I  ————>  I am a student.
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char[] array = str.toCharArray();
        //1. 翻转整个单词序列	student. a am I ————> I ma a .tneduts
        reverse(array, 0,  array.length - 1);
        //2. 分别翻转序列中的每个单词
        int begin = 0;
        int position = 1;
        while (begin < array.length) {
            if (array[begin] == ' ') {
                begin++;
                if (begin >= array.length) {
                    break;
                }
                position = begin + 1;
            }

            if (position == array.length || array[position] == ' ') {
                reverse(array, begin, position - 1);
                begin = position;
            }else{
                position++;
            }
        }
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