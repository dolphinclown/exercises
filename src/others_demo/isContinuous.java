package others_demo;

/**
 * 从扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。 2-10位数字本身
 * A 为 1，J 为 11， Q 为 12，K 为 13，而大小王可以看成任意数字
 */
public class isContinuous {
    //思路：首先把数组排序，统计数组中 0 的个数，然后找出数组中是否有空缺位，
    //如果有空缺位，判断 0 的个数是否可以弥补，可以的话，则说明是连续的。
    //还需要注意一点：如果排序好的数组存在两个相同的数字，在扑克牌角度看就是存在对子，
    //			   那么也是不连续的。
    public boolean isContinuous(int[] numbers) {
        if(numbers == null || numbers.length == 0){
            return false;
        }
        //1. 将数组排序
        sort(numbers);
        //2. 统计数组中 0 的个数
        int timesOfZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                timesOfZero++;
            }
        }
        //3. 统计空位的个数
        int numbersOfGap = 0;
        int small = timesOfZero; //第一个非 0 数字
        int big = small + 1;
        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }
            numbersOfGap +=  numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return timesOfZero >= numbersOfGap ? true : false;
    }
    public void sort(int[] numbers) {
        int i;
        for (int p = 1; p < numbers.length; p++) {
            int temp = numbers[p];
            for (i = p; i > 0 && temp < numbers[i - 1]; i--) {
                numbers[i] = numbers[i - 1];
            }
            numbers[i] = temp;
        }
    }
}