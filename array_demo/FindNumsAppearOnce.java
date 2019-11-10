//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    // 两个不同数字，异或所得结果肯定会存在为 1 的位，即 0 ^ 1。所以，就以数字此位为 0 或 1，
    // 将数组分为两组
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length < 2) {
            return;
        }
        //1. 将数组所有元素依次异或，最后得到的值为这两个要求数字的异或结果。
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        //2. 找到 result 二进制表示中从右至左，第一个 1 出现的位置，记为 n
        int n = 0;
        while (((result & 1) == 0) && n < 32) {
            result = result >> 1;
            n++;
        }
        //3. 将原数组分为两个子数组，每个子数组包含一个要找的数字，将这两组数字分别异或求得两个不同数字
        for (int i = 0; i < array.length; i++) {
            if (isBit1AtNth(array[i], n)) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    public boolean isBit1AtNth(int number, int n) {
        number = number >> n;
        return (number & 1) == 1;
    }
}