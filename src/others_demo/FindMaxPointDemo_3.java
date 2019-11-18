package others_demo;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by CLAY on 2016/11/29.
 * Given n points on a 2D plane,find the maximum number of points that
 * lie on the same straight line
 */
public class FindMaxPointDemo_3 {
    public static void main(String[] args) {
        Point[] points = {new Point(0,0),new Point(1,1),new Point(2,2),new Point(3,0),new Point(0,2)};
        System.out.println(FindMaxPoint(points));
    }

    public static int FindMaxPoint(Point[] points){
        //当前存在最多点直线上的点数
        int ret = 0;

        int length = points.length;
        if (length <= 2) {
            return  length;
        }

        for (int i = 0; i < length; i++) {
            //注意重合的点，和以该点为起点构成直线垂直于x轴
            //两种情况
            int dup = 1;  //初始为1，表示该点本身
            int vertical = 0;
            Point a = points[i];

            //键-斜率   值-点的个数
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();

            for (int j = 0; j < length; j++) {
                //是当前点本身，跳过，进行下一次遍历
                if (i == j) {
                    continue;
                }
                Point b = points[j];
                if (a.x == b.x) {
                    //1.重合点
                    if (a.y == b.y) {
                        dup += 1;
                    }
                    //2.垂直（无斜率），非重合点的个数
                    vertical++;
                }else{
                    //计算斜率相同的点的个数
                    double k = (double) (a.y - b.y) / (a.x - b.x);
                    if (map.get(k) == null) {
                        map.put(k,1);
                    }else {
                        map.put(k, map.get(k) + 1);
                    }
                }
            }
            int max = vertical;
            for (double k:map.keySet()) {
                max = Math.max(max,map.get(k));
            }
            ret = Math.max(ret,max + dup);
        }
        return ret;
    }
}
