/**
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 *使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 *并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
    //第一个思路：类似冒泡算法，前偶后奇数就交换：
    public void reOrderArray(int [] array) {
        for(int i= 0; i < array.length - 1; i++){
            for(int j=0; j < array.length - 1 - i; j++){
                if(array[j] % 2 == 0 && array[j+1] % 2 == 1){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }

    //第二个思路：再创建一个数组
    //时间复杂度为O（n），空间复杂度为O（n）的算法
    //首先统计奇数的个数
    //然后新建一个等长数组，设置两个指针，奇数指针从0开始，偶数指针从奇数个数的末尾开始 遍历，填数
    public void reOrderArray(int [] array) {
        if(array.length == 0|| array.length == 1) return;
        int oddCount=0;
        int oddBegin=0;
        int[] newArray = new int[array.length];
        for(int i=0; i < array.length; i++){
            if((array[i]&1)==1)
                oddCount++;
        }
        for(int i=0; i < array.length; i++){
            if((array[i]&1)==1)
                newArray[oddBegin++] = array[i];
            else
                newArray[oddCount++] = array[i];
        }
        for(int i=0; i < array.length; i++){
            array[i] = newArray[i];
        }
    }
}