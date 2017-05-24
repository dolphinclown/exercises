package stringdemo;

/**
 * Created by CLAY on 2017/5/24.
 */
public class KMP {
    public static void main(String[] args) {
        String s = "abacabab";
        String p = "abab";
        int position = KMPSearch(s, p);
        System.out.println(position);
    }

    /**
     * KMP 查找方法
     * @param s 文本串
     * @param p 要查找的模式串
     * @return
     */
    public static int KMPSearch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        //求得模式串的 next 数组
        int[] next = getNextImprove(pArr);
        int slen = sArr.length;
        int plen = pArr.length;

        int i = 0;
        int j = 0;

        while (i < slen && j < plen) {
            //如果 j == -1,或者当前字符串配成功，都令 i++, j++
            if (j == -1 || sArr[i] == pArr[j]) {
                i++;
                j++;
            } else {
                //j != -1,且当前字符匹配失效，令 i 不变，j = next[j]
                //next[j] 为 j 所对应的 next 值，这样做相当于将模式串相对文本串向后移动
                //（模式串向后移动位数 = 失配字符位置 - 失配字符对应 next 值）
                j = next[j];
            }
        }

        if (j == plen) {
            return i - j;
        }
        return -1;
    }

    /**
     * 构造 next 数组
     * @param p
     * @return
     */
    public static int[] getNext(char[] p) {
        if (p == null || p.length == 0) {
            return null;
        }

        int plen = p.length;
        int[] next = new int[plen];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < plen - 1) {
            //p[k] 表示前缀，p[j] 表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                next[j] = k;
            }else{
                //向前递归, 判断 p[next[k]] == p[j]是否成立 ,如果找到相等的串则停止，
                //此时 p[k] == p[j] , next[j + 1] = next[j] + 1 = k + 1
                //否则，k 将在等于 -1 时停止。当前位置的 next 值为0
                k = next[k];
            }

        }

        return next;
    }

    /**改进获取 next 数组的方法，主要解决问题如下：
     * 文本串：          a b a c a b
     * 模式串：          a b a b
     * 对应 next 数组：[-1 0 0 1]
     * 当 b 和 c 匹配失效，模式串向右移动两位-->
     *      文本串：          a b a c a b
     *      模式串：              a b a b
     * 此时又是 b 和 c 比较
     * 所以，不该出现 p[j] = p[next[j]],如果相等，下一步也会失败，因此，如果出现了这样的
     * 情况，需要再次递归 next[j] = next[next[j]];
     */
    public static int[] getNextImprove(char[] p) {
        if (p == null || p.length == 0) {
            return null;
        }

        int plen = p.length;
        int[] next = new int[plen];
        next[0] = -1;
        int k = -1;
        int j = 0;

        while (j < plen - 1) {
            //p[k] 表示前缀，p[j] 表示后缀
            if (k == -1 || p[j] == p[k]) {
                ++k;
                ++j;
                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    next[j] = next[k];
                }
            }else{
                //向前递归, 判断 p[next[k]] == p[j]是否成立 ,如果找到相等的串则停止，
                //此时 p[k] == p[j] , next[j + 1] = next[j] + 1 = k + 1
                //否则，k 将在等于 -1 时停止。当前位置的 next 值为0
                k = next[k];
            }

        }

        return next;
    }
}
