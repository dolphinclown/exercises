package array_demo;

/**
 * Created by CLAY on 2017/2/27.
 */
public class FindEFromArray_3 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};

        System.out.println(find(arr,17));
    }

    public static boolean find(int[][] a, int x) {
        if (a == null) {
            return false;
        }
        int rows = a.length;
        int cols = a[0].length;

        int i = 0;
        int j = cols - 1;
        while (i < rows && j >= 0) {
            if (x == a[i][j]) {
                return true;
            } else if (x > a[i][j]) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
