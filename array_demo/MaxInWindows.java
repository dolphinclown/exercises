import java.util.*;
/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}
 */
public class MaxInWindows {
    //使用双端队列，队列中存放元素下标，遍历数组，保持队列头部为窗口最大值，
    //当一个元素入队时，先判断队列是否为空，并且队列中元素是否小于此元素。
    //队列为空，元素直接入队，队尾元素小于此元素，将队列中两个元素出队，插入此元素
    //作为头部，反之，将此元素先插入队尾，如果此元素下标减去队列头部元素下标大于或等于
    //窗口值，将头部元素出队。
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> ret = new ArrayList<>();
        if(num == null){
            return ret;
        }
        if(num.length < size || size < 1){
            return ret;
        }

        LinkedList<Integer> indexDeque = new LinkedList<>();//用于保存滑动窗口中的数字

        //滑动窗口内部，用于判断窗口中的最大值
        for (int i = 0; i < size - 1; i++){
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();            //将前面比K小的直接移除队列，因为不可能成为滑动窗口的最大值
            }
            indexDeque.addLast(i);//将数字存入滑动窗口中
        }

        //滑动整个窗口
        for (int i = size - 1; i < num.length; i++) {
            while(!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]){
                indexDeque.removeLast();//将前面比K小的直接移除队列，因为不可能成为滑动窗口的最大值
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }

            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }
}