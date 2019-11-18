import java.util.Stack;

/**
 * Created by CLAY on 2017/3/14.
 * 判断是否为出栈序列
 */
public class IsPopOrder_22 {
    public static void main(String[] args) {
        int[] push = new int[]{1, 2, 3, 4, 5};
        int[] pop = new int[]{4, 5, 3, 2, 1};
        int[] pop1 = new int[]{5,4, 3, 2, 1};
        int[] pop2 = new int[]{4, 3, 2, 5, 1};

        System.out.println(isPopOrder(push, pop));
        System.out.println(isPopOrder(push, pop1));
        System.out.println(isPopOrder(push, pop2));

    }

    /**
     * @param aPush 压栈序列
     * @param aPop  出栈序列
     * @return
     */
    public static boolean isPopOrder(int[] aPush, int[] aPop) {
        if (aPush == null || aPop == null || aPush.length <= 0 ||
                aPop.length <= 0 || aPush.length != aPop.length) {
            return false;
        }

        int length = aPush.length;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0; //aPop指针，指向下一个应该弹出的元素
        int j = 0; //aPush指针
        while (i < length) {
            //如果栈为空或者栈顶元素与下一个应弹出的元素不等
            while (s.empty() || s.peek() != aPop[i]) {
                if (j == length) {
                    break; //压栈序列全部处理完
                }
                s.push(aPush[j]);
                j++;
            }

            if (s.peek() != aPop[i]) {
                break;
            }
            //栈顶元素与当前出栈序列中的元素相等，指针指向下一个元素
            s.pop();
            i++;
        }

        if (s.empty() && i == length) {
            return true;
        }

        return false;
    }


}
