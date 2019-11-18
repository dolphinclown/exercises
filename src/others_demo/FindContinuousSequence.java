package others_demo;

import java.util.ArrayList;
/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer> > findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (sum < 3) {
            return result;
        }
        int small = 1;
        int big = 2;
        int middle = (sum + 1) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(int i = small; i <= big; i++){
                    list.add(i);
                }
                result.add(list);
                curSum -= small;
                small++;
            } else if (curSum < sum) {
                big++;
                curSum += big;
            } else {
                curSum -= small;
                small++;
            }
        }
        return result;
    }
}